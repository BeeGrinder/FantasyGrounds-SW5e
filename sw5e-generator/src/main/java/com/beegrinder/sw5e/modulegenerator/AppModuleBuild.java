package com.beegrinder.sw5e.modulegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.shared.utils.io.FileUtils;

import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Item;
import com.beegrinder.sw5e.objects.Parcel;
import com.beegrinder.sw5e.objects.Spell;

public class AppModuleBuild {

	public final static String BEGIN_XML_TAG = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
	public final static String PARCEL_COIN_LIST = "<coinlist><id-00001><amount type=\"number\">0</amount><description type=\"string\">cr</description></id-00001></coinlist>";
	public final static String PARCEL_LOCKED = "<locked type=\"number\">1</locked>";
	public final static String DEX_BONUS_PLUS_2 = "Yes  (max 2)";
	public final static String DEX_BONUS = "Yes";
	public final static String CONCENTRATION_STRING = "Concentration, ";
	public final static String MODULE_SPELL_GROUP = "Spells";
	public final static Integer EQUIP_CATEGORY_WEAPON = 3;
	public final static Integer EQUIP_CATEGORY_ARMOR = 4;
	public final static Integer EQUIP_CATEGORY_TOOLS = 12;
	public final static Integer EQUIP_CATEGORY_GAME = 17;
	public final static Integer EQUIP_CATEGORY_KIT = 21;
	public final static Integer EQUIP_CATEGORY_MUSIC = 18;

	public static void buildModule(AppScreen frame) throws Exception {
		Path modulePath = null;
		// check that the module parent directory exists
		if (!validateModuleDirectory(frame.getTextFieldModuleFolder().getText())) {
			throw new Exception("Error. Module directory not found.");
		}

		//read par5e module (client) xml file into string
		try {
			ModuleGenerator.par5eClientString=
			new String(Files.readAllBytes(Paths.get(ModuleGenerator.defaultProps.getProperty("input.filename.par5eclient"))));
			ModuleGenerator.addLogEntry("Read par5e client file.");
		}catch(Exception e) {
			ModuleGenerator.addLogEntry("Error reading par5e client module file. " + e.getMessage());
		}
		

		// Prepare for FG Module to be stored as a directory rather than a .mod file.
		try {
			removeModFileIfExists(frame.getTextFieldModuleFolder().getText(),
					ModuleGenerator.moduleName);
			modulePath = createModWorkDirectory(frame.getTextFieldModuleFolder().getText(),
					ModuleGenerator.moduleName);
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error preparing to deploy module as directory. " + e.getMessage());
		}
		// copy thumbnail for module file
		try {
			Files.copy(Path.of(frame.getTextFieldThumbnail().getText()),
					Path.of(modulePath.toString() + ModuleGenerator.delim + "thumbnail.png"),
					StandardCopyOption.REPLACE_EXISTING);
			ModuleGenerator.addLogEntry("Copied thumbnail file.");
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error copying thumbnail to module. " + e.getMessage());
		}
		// copy definition.xml for module file (should be copied from par5e output)
		try {
			Files.copy(
					Path.of(ModuleGenerator.defaultProps.getProperty("input.filename.par5edefinition")),
					Path.of(modulePath.toString() + ModuleGenerator.delim + "definition.xml"),
					StandardCopyOption.REPLACE_EXISTING);
			ModuleGenerator.addLogEntry("Copied definition.xml file.");
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error creating definition.xml file. " + e.getMessage());
		}
		// create new entries (spell, items, parcels)
		try {
			ModuleGenerator.newModuleEntries=createNewModuleEntries(modulePath, frame);
			ModuleGenerator.addLogEntry("Done creating additional sections (Spell, Equipment, etc).");
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error creating main module file. " + e.getMessage());
		}

		//edit par5e output xml with fixes
		String editedPar5eFile=fixPar5eFile(ModuleGenerator.par5eClientString);
		//merge new sections into par5e module xml
		String finalModuleString=addNewModuleEntriesToEnd(editedPar5eFile);
		//write new module file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(modulePath.toString() + ModuleGenerator.delim + "client.xml"));
		    writer.write(finalModuleString);
		    writer.close();
		    ModuleGenerator.addLogEntry("New client.xml file written.");
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error creating client.xml file. " + e.getMessage());
		}
		//finally we need to copy the images and tokens into destination
		File tokenSource=new File(ModuleGenerator.defaultProps.getProperty("input.filename.par5etokens"));
		File imageSource=new File(ModuleGenerator.defaultProps.getProperty("input.filename.par5eimages"));
		try {
			FileUtils.copyDirectoryStructure(tokenSource, new File(modulePath.toString() + ModuleGenerator.delim + "tokens"));
			FileUtils.copyDirectoryStructure(imageSource, new File(modulePath.toString() + ModuleGenerator.delim + "images"));
			ModuleGenerator.addLogEntry("Copied image and token directories.");
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error copying image and/or token directories. " + e.getMessage());
		}
		
		if (! frame.getChckbxAsDirectory().isSelected()) {
			// package files created above into zip file and rename to module, then remove above files/directory
			
		}
	}

	private static String addNewModuleEntriesToEnd(String input) {
		return input.replace("</root>", ModuleGenerator.newModuleEntries+"</root>");
	}
	
	private static String fixPar5eFile(String input) {

		return input
			.replaceAll("<name type=\"string\">Berserker Approach<\\/name>", "<name type=\"string\">Berserker Approach<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Consular Tradition<\\/name>", "<name type=\"string\">Consular Tradition<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Engineering Discipline<\\/name>","<name type=\"string\">Engineering Discipline<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Fighter Speciality<\\/name>","<name type=\"string\">Fighter Speciality<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Operative Practice<\\/name>","<name type=\"string\">Operative Practice<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Guardian Focus<\\/name>","<name type=\"string\">Guardian Focus<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Monastic Order<\\/name>","<name type=\"string\">Monastic Order<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Academic Pursuit<\\/name>","<name type=\"string\">Academic Pursuit<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Scout Technique<\\/name>","<name type=\"string\">Scout Technique<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("<name type=\"string\">Sentinel Calling<\\/name>","<name type=\"string\">Sentinel Calling<\\/name><specializationchoice type=\"number\">1<\\/specializationchoice>")
			.replaceAll("----FightingMasteryReferenceList----","<link class=\"referencetext\" recordname=\"reference.refmanualdata.refpage_000001fightingmastery\\@"+ModuleGenerator.moduleName+"\">Fighting Mastery List<\\/link>")
			.replaceAll("----LightsaberFormsReferenceList----","<link class=\"referencetext\" recordname=\"reference.refmanualdata.refpage_000003lightsaberforms\\@"+ModuleGenerator.moduleName+"\">Saber Form List<\\/link>")
			.replaceAll("----FightingStyleReferenceList----","<link class=\"referencetext\" recordname=\"reference.refmanualdata.refpage_000002fightingstyle\\@"+ModuleGenerator.moduleName+"\">Fighting Style List<\\/link>")
			.replace("<token type=\"token\">tokens\\SW5e Player Bookr", "<token type=\"token\">tokens\\SW5e Player Book\\r")
			;
	}
	
	private static String createNewModuleEntries(Path modulePath, AppScreen frame) throws Exception {
		// create root
		StringBuffer buff = new StringBuffer();

		// now add sections if they have been checked off (selected)
		if (frame.getChckbxEquipment().isSelected()) {
			// create <item> element
			try {
				buff = buildItemSection(buff);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error.  Unable to create <item> element. " + e.getMessage());
			}
		}
		if (frame.getChckbxSpells().isSelected()) {
			// create <power> element
			try {
				buff = buildPowerSection(buff);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error.  Unable to create <power> element. " + e.getMessage());
			}
		}
		if (frame.getChckbxParcels().isSelected()) {
			// create <treasureparcels> element
			try {
				buff = buildParcelSection(buff);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error.  Unable to create <power> element. " + e.getMessage());
			}
		}

		return buff.toString();
	}

	private static StringBuffer buildParcelSection(StringBuffer buff) throws Exception {
		Integer curParcelCount=1;
		buff.append(createOpenTag("treasureparcels"));
		buff.append("<category name=\"SW5e Equipment Packs\" baseicon=\"0\" decalicon=\"0\">");
		// now do each parcel
		for (int i = 0; i < ModuleGenerator.parcelList.size(); i++) {
			Parcel p = ModuleGenerator.parcelList.get(i);
			// get items for parcel
			List<Item> iList = p.getItems();

			//now create parcel code
			final String currParcelId = "id-" + String.format("%05d", (curParcelCount));
			// things at parcel level
			buff.append(createOpenTag(currParcelId));
			buff.append(createOpenTag("name", "string"));
			buff.append(p.getName());
			buff.append(createCloseTag("name"));
			buff.append("<temp/>");
			buff.append(PARCEL_LOCKED);
			buff.append(PARCEL_COIN_LIST);
			// now for each item
			Integer curItemCount=1;
			buff.append(createOpenTag("itemlist"));
			for (Item item : iList) {
				Equipment e = findEquipmentByName(item.getName());
				if (e == null) {
					throw new Exception("Unable to find " + item.getName() + " for parcel " + p.getName());
				} else {
					final String currEquipId = "id-" + String.format("%05d", (curItemCount));
					buff.append(createOpenTag(currEquipId));
					//cost
					buff.append(createOpenTag("cost", "string"));
					buff.append(e.getCost().toString()+" cr");
					buff.append(createCloseTag("cost"));
					//count
					buff.append(createOpenTag("count", "number"));
					buff.append(item.getQuantity());
					buff.append(createCloseTag("count"));
					//name
					buff.append(createOpenTag("name", "string"));
					buff.append(e.getName());
					buff.append(createCloseTag("name"));
					//weight
					buff.append(createOpenTag("weight", "number"));
					buff.append(e.getWeight());
					buff.append(createCloseTag("weight"));
					//type
					String typeString = (e.getEquipmentCategory() == null) ? "Standard"
							: splitcamelcase(e.getEquipmentCategory());
					String subtypeString = "Adventuring Gear";
					buff.append(createOpenTag("type", "string"));
					buff.append(typeString);
					buff.append(createCloseTag("type"));
					buff.append(createOpenTag("subtype", "string"));
					buff.append(subtypeString);
					buff.append(createCloseTag("subtype"));
					buff.append(PARCEL_LOCKED);
					buff.append(createCloseTag(currEquipId));
					curItemCount++;
				}
			}
			//end of item list, close list
			buff.append(createCloseTag("itemlist"));
			buff.append(createCloseTag(currParcelId));
			curParcelCount++;
		}
		// all done with parcels
		buff.append("</category>");
		buff.append(createCloseTag("treasureparcels"));
		return buff;
	}

	private static Equipment findEquipmentByName(String name) {
		Equipment retVal = null;
		for (Equipment e : ModuleGenerator.equipmentList) {
			if (e.getName().trim().equalsIgnoreCase(name.trim())) {
				if (retVal != null)
					ModuleGenerator.addLogEntry("Error.  Multiple found for equipment name " + name);
				retVal = e;
			}
		}
		return retVal;
	}

	private static StringBuffer buildPowerSection(StringBuffer buff) throws Exception {
		buff.append(createOpenTag("spell", null)); // open spell section
		buff.append("<category name=\"\" baseicon=\"0\" decalicon=\"0\">");
		if ((ModuleGenerator.spellList != null) && (!ModuleGenerator.spellList.isEmpty())) {
			int curSpellCount = 1;
			Collections.sort(ModuleGenerator.spellList);
			for (int i = 0; i < ModuleGenerator.spellList.size(); i++) {
				Spell e = ModuleGenerator.spellList.get(i);
				boolean actions = false;
				final String currId = "id-" + String.format("%05d", (curSpellCount));
				buff.append(createOpenTag(currId));
				/*
				 * Begin processing spell data
				 */
				/*
				 * A C T I O N S *
				 */
				String act=AppActionOverride.getActionOverrideMap().get(e.getName());
				// if action override does not exist, get from current spell or if that is blank append filler action.
				if( StringUtils.isBlank(act) ) {
					act = StringUtils.isBlank(e.getActions()) ? "<actions/>" : e.getActions() ;
				}
				// now add action to buffer
				buff.append(act);
				// if action code exists, flip boolean for later description update
				if( (! StringUtils.isBlank(act)) && (! act.equals("<actions/>")) ) {
					actions=true;
				}

				/*
				 * add static sections
				 */
				buff.append("<cast type=\"number\">0</cast>");
				buff.append("<components type=\"string\"/>");
				buff.append("<group type=\"string\">" + MODULE_SPELL_GROUP + "</group>");
				buff.append("<locked type=\"number\">1</locked>");
				buff.append("<prepared type=\"number\">0</prepared>");
				buff.append("<ritual type=\"number\">0</ritual>");
				/*
				 * name
				 */
				buff.append(createOpenTag("name", "string"));
				buff.append(e.getName());
				buff.append(createCloseTag("name"));
				/*
				 * castingtime
				 */
				buff.append(createOpenTag("castingtime", "string"));
				buff.append(e.getCasting_time());
				buff.append(createCloseTag("castingtime"));
				/*
				 * description
				 */
				buff.append(createOpenTag("description", "formattedtext"));
				final String desc = e.getSw5e_description();
				if (StringUtils.isBlank(desc)) {
					buff.append("<p />");
				} else {
					buff.append("<p>").append(desc.replace("***", "").replace("\r\n\r\n", "</p><p>")).append("</p>");
				}
				if (actions) {
					buff.append("<p>(*FG Coding)</p>");
				}
				buff.append(createCloseTag("description"));
				/*
				 * duration
				 */
				buff.append(createOpenTag("duration", "string"));
				if (e.getConcentration() != null && e.getConcentration() == 1) {
					buff.append(CONCENTRATION_STRING);
				}
				buff.append(e.getDuration());
				buff.append(createCloseTag("duration"));
				/*
				 * level
				 */
				buff.append(createOpenTag("level", "number"));
				buff.append(e.getPower_level().toString());
				buff.append(createCloseTag("level"));
				/*
				 * range
				 */
				buff.append(createOpenTag("range", "string"));
				buff.append(e.getRange());
				buff.append(createCloseTag("range"));
				/*
				 * school
				 */
				buff.append(createOpenTag("school", "string"));
				buff.append(e.getSchool());
				buff.append(createCloseTag("school"));
				/*
				 * source
				 */
				buff.append(createOpenTag("source", "string"));
				buff.append(e.getPower_source());
				buff.append(createCloseTag("source"));

				/*
				 * Done processing spell object.
				 */
				buff.append(createCloseTag(currId));
				curSpellCount++;

			}
		}
		buff.append("</category>");
		buff.append(createCloseTag("spell")); // close spell section
		return buff;
	}

//	private static String buildLibrarySelction(String moduleName, String moduleCategory) throws Exception {
//		StringBuffer buff = new StringBuffer();
//		buff.append(createOpenTag("library"));
//		String idTag = "id-" + moduleName.toLowerCase();
//		buff.append(createOpenTag(idTag));
//		buff.append(createOpenTag("categoryname", "string")).append(moduleCategory)
//				.append(createCloseTag("categoryname"));
//		buff.append(createOpenTag("name", "string")).append(moduleName).append(createCloseTag("name"));
//		buff.append(createOpenTag("entries")).append(createCloseTag("entries"));
//		buff.append(createCloseTag(idTag));
//		buff.append(createCloseTag("library"));
//		return buff.toString();
//	}

	private static StringBuffer buildItemSection(StringBuffer buff) throws Exception {

		buff.append(createOpenTag("item", null)); // open item section
		if ((ModuleGenerator.equipmentList != null) && (!ModuleGenerator.equipmentList.isEmpty())) {
			int curItemCount = 1;
			for (int i = 0; i < ModuleGenerator.equipmentList.size(); i++) {
				Equipment e = ModuleGenerator.equipmentList.get(i);
				if (ModuleGenerator.ALLOWED_CONTENT_CODES.contains(e.getContentSource())) {
					final String currId = "id-" + String.format("%05d", (curItemCount));
					buff.append(createOpenTag(currId, null));
					/*
					 * Begin processing item data
					 */
					// ** ac
					String dexBonusString = "-";
					buff.append(createOpenTag("ac", "number"));
					if (e.getAc() == null) {
						buff.append("0");
					} else {
						String acString = e.getAc();
						if (acString.contains("+ Dex modifier") && acString.contains("max 2")) {
							dexBonusString = DEX_BONUS_PLUS_2;
						} else if (acString.contains("+ Dex modifier")) {
							dexBonusString = DEX_BONUS;
						}
						buff.append(
								acString.replace("+", "").replace("Dex modifier", "").replace("(max 2)", "").trim());
					}
					buff.append(createCloseTag("ac"));
					// ** bonus
					buff.append(createOpenTag("bonus", "number"));
					buff.append("0");
					buff.append(createCloseTag("bonus"));
					// **cost
					buff.append(createOpenTag("cost", "string"));
					buff.append(e.getCost() + AppConstants.ITEM_COST_SUFFIX1);
					buff.append(createCloseTag("cost"));
					// **name
					buff.append(createOpenTag("name", "string"));
					buff.append(e.getName());
					buff.append(createCloseTag("name"));
					if (AppConstants.DEBUG)
						ModuleGenerator.addLogEntry("Item name: " + e.getName());
					// **description
					buff.append(createOpenTag("description", "formattedtext"));
					final String desc = e.getDescription();
					if (StringUtils.isBlank(desc)) {
						buff.append("<p />");
					} else {
						buff.append("<p>").append(desc.replace("***", "").replace("\r\n\r\n", "</p><p>"))
								.append("</p>");
					}
					buff.append(createCloseTag("description"));
					// **isidentified
					buff.append(createOpenTag("isidentified", "number"));
					buff.append("1");
					buff.append(createCloseTag("isidentified"));
					// **locked
					buff.append(createOpenTag("locked", "number"));
					buff.append("1");
					buff.append(createCloseTag("locked"));
					/*
					 * begin type and subtype
					 */
					String typeString = "";
					String subtypeString = "";
					final Integer equipCat = (e.getEquipmentCategoryEnum() == null) ? 0 : e.getEquipmentCategoryEnum();
					if ( EQUIP_CATEGORY_WEAPON.equals(equipCat)) { // WEAPON
						typeString = "Weapon";
						subtypeString = (e.getWeaponClassification() == null) ? ""
								: splitcamelcase(e.getWeaponClassification());
						subtypeString=subtypeString.replace("Vibroweapon", "Melee Vibroweapon").replace("Blaster", "Ranged Blaster").replace("Lightweapon", "Melee Lightweapon");
					} else if (EQUIP_CATEGORY_ARMOR.equals(equipCat)) { // ARMOR
						typeString = "Armor";
						subtypeString = (e.getArmorClassification() == null) ? "" : e.getArmorClassification();
					} else if(EQUIP_CATEGORY_TOOLS.equals(equipCat)) { // Artisan's Tools
						typeString = "Tools";
						subtypeString = "Artisan's Tools";
					} else if(EQUIP_CATEGORY_GAME.equals(equipCat)) { // Gaming Set
						typeString = "Tools";
						subtypeString = "Gaming Set";
					} else if(EQUIP_CATEGORY_KIT.equals(equipCat)) { // Kits / Sets
						typeString = "Tools";
						subtypeString = "Kits / Sets";
					} else if(EQUIP_CATEGORY_MUSIC.equals(equipCat)) { //Musical Instrument
						typeString = "Tools";
						subtypeString = "Musical Instrument";
					} else { // all other
						typeString = "Adventuring Gear";
						subtypeString = (e.getEquipmentCategory() == null) ? "Standard"
								: splitcamelcase(e.getEquipmentCategory());
					}
					buff.append(createOpenTag("type", "string"));
					buff.append(typeString);
					buff.append(createCloseTag("type"));
					buff.append(createOpenTag("subtype", "string"));
					buff.append(subtypeString);
					buff.append(createCloseTag("subtype"));
					/*
					 * end of type and subtype
					 */
					// **weight
					buff.append(createOpenTag("weight", "number"));
					buff.append((e.getWeight() == null) ? "" : e.getWeight());
					buff.append(createCloseTag("weight"));
					// **properties
					List<String> propList = (e.getProperties() == null) ? new ArrayList<>() : e.getProperties();
					if (!propList.isEmpty()) {
						buff.append(createOpenTag("properties", "string"));
						for (int x = 0; x < propList.size(); x++) {
							if (x > 0)
								buff.append(", ");
							buff.append(propList.get(x));
						}
						buff.append(createCloseTag("properties"));
					}
					/*
					 * set up properties MAP
					 */
					Map<String, String> propMap = new HashMap<>();
					if (e.getPropertiesMap() != null) {
						propMap = e.getPropertiesMap().getAdditionalProperties();
						if (propMap == null)
							propMap = new HashMap<>();
					}
					/*
					 * ARMOR SPECIFIC
					 */
					// **dexbonus
					if (equipCat == 4) {
						buff.append(createOpenTag("dexbonus", "string"));
						buff.append(dexBonusString);
						buff.append(createCloseTag("dexbonus"));
						// **stealth
						String stealthString = e.getStealthDisadvantage() ? "Disadvantage" : "-";
						buff.append(createOpenTag("stealth", "string")).append(stealthString);
						buff.append(createCloseTag("stealth"));
						// **strength
						if (propMap.size() > 0) {
							String str = propMap.get("Strength");
							if (StringUtils.isBlank(str))
								str = "-";
							if (!StringUtils.isBlank(str)) {
								buff.append(createOpenTag("strength", "string"));
								buff.append(str.replace("strength", "Str"));
								buff.append(createCloseTag("strength"));
							}
						}

					}
					/*
					 * WEAPON SPECIFIC
					 */
					if (equipCat == 3) {
						String damType = (e.getDamageType() == null) ? "" : e.getDamageType().toLowerCase();
						Integer damNumDie = (e.getDamageNumberOfDice() == null) ? 0 : e.getDamageNumberOfDice();
						Integer damDieType = (e.getDamageDieType() == null) ? 0 : e.getDamageDieType();
						Integer damDieModifier = (e.getDamageDieModifier() == null) ? 0 : e.getDamageDieModifier();
						// **damage
						StringBuffer dambuff = new StringBuffer();
						if (damNumDie > 0) {
							dambuff.append(damNumDie.toString() + "d" + damDieType);
							if (damDieModifier != 0) {
								dambuff.append("+" + damDieModifier);
							}
							dambuff.append(" " + damType);
						}
						buff.append(createOpenTag("damage", "string"));
						buff.append(dambuff.toString());
						buff.append(createCloseTag("damage"));

					}

					/*
					 * Done parsing equipment object.
					 */
					buff.append(createCloseTag(currId));
					curItemCount++;
				}
			}
		}

		buff.append(createCloseTag("item")); // close item section
		return buff;
	}

	private static String splitcamelcase(String sourceString) {

		String retVal = "";

		StringBuffer buf = new StringBuffer();
		String[] array = StringUtils.splitByCharacterTypeCamelCase(sourceString);
		if (array != null) {
			for (int i = 0; i < array.length; i++) {
				if (!StringUtils.isBlank(array[i])) {
					if (i > 0)
						buf.append(" ");
					buf.append(array[i].replace("And", "and").replace("Or", "or"));
				}
			}
			retVal = buf.toString();
		}

		return retVal;
	}

//	private static String createOpenRootTag() {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//		return "<root dataversion=\"" + dateFormat.format(new Date()) + "\" version=\""
//				+ AppConstants.DEFINITION_MIN_VERSION + "\">";
//	}

	private static String createOpenTag(String name, String type) throws Exception {
		StringBuffer retVal = new StringBuffer();
		if (!StringUtils.isBlank(name)) {
			retVal.append("<" + name);
			if (!StringUtils.isBlank(type)) {
				retVal.append(" type=\"" + type + "\"");
			}
			retVal.append(">");
		} else {
			throw new Exception("Invalid call to AppModuleBuild.createOpenTag. Field 'name' is blank.");
		}

		return retVal.toString();
	}

	private static String createOpenTag(String name) throws Exception {
		return createOpenTag(name, null);
	}

	private static String createCloseTag(String name) throws Exception {
		StringBuffer retVal = new StringBuffer();
		if (!StringUtils.isBlank(name)) {
			retVal.append("</" + name + ">");
		} else {
			throw new Exception("Invalid call to AppModuleBuild.createCloseTag. Field 'name' is blank.");
		}

		return retVal.toString();
	}

//	private static void createDefinitionFile(Path modulePath, AppScreen frame)
//			throws TransformerException, ParserConfigurationException {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//		Document doc = dBuilder.newDocument();
//		// root element
//		Element rootElement = doc.createElement("root");
//		doc.appendChild(rootElement);
//		rootElement.setAttribute("version", AppConstants.DEFINITION_MIN_VERSION);
//		rootElement.setAttribute("dataversion", dateFormat.format(new Date()));
//		Element nameElement = doc.createElement("name");
//		nameElement.setTextContent(frame.getTextFieldModuleName().getText());
//		rootElement.appendChild(nameElement);
//		Element categoryElement = doc.createElement("ruleset");
//		categoryElement.setTextContent(frame.getTextFieldCategory().getText());
//		rootElement.appendChild(categoryElement);
//		Element authorElement = doc.createElement("author");
//		authorElement.setTextContent(frame.getTextFieldAuthor().getText());
//		rootElement.appendChild(authorElement);
//		Element rulesetElement = doc.createElement("ruleset");
//		rulesetElement.setTextContent(AppConstants.DEFINITION_RULESET);
//		rootElement.appendChild(rulesetElement);
//		TransformerFactory transformerFactory = TransformerFactory.newInstance();
//		Transformer transformer = transformerFactory.newTransformer();
//		DOMSource source = new DOMSource(doc);
//		StreamResult result = new StreamResult(
//				new File(modulePath.toString() + ModuleGenerator.delim + "definition.xml"));
//		transformer.transform(source, result);
//	}

	private static Path createModWorkDirectory(String modDir, String modName) throws Exception {
		Path path = Path.of(modDir + ModuleGenerator.delim + modName);
		if (Files.exists(path) && Files.isDirectory(path)) {
			ModuleGenerator.addLogEntry("Found module build directory " + modName);
		} else {
			ModuleGenerator.addLogEntry("Creating mod work directory: " + modName);
			try {
				path = Files.createDirectory(path);
			} catch (Exception e) {
				throw new Exception("Unable to create mod work directory: " + path.toString());
			}
		}
		return path;
	}

	private static void removeModFileIfExists(String modDir, String modName) {
		Path path = Path.of(modDir + ModuleGenerator.delim + modName + ".mod");
		if (Files.exists(path)) {
			try {
				ModuleGenerator.addLogEntry("Removing file " + path.toString());
				Files.delete(path);
			} catch (IOException e) {
				ModuleGenerator.addLogEntry("Error.  Unable to remove .mod file. " + e.getMessage());
			}
		}
	}

	private static boolean validateModuleDirectory(String folderName) {
		boolean retVal = false;
		Path path = Path.of(folderName);
		if (Files.exists(path) && Files.isDirectory(path)) {
			retVal = true;
		}

		return retVal;
	}

}
