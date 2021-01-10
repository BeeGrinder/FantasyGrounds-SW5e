package com.beegrinder.sw5e.modulegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Power;

public class AppModuleBuild {

	public final static String BEGIN_XML_TAG="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
	public final static String DEX_BONUS_PLUS_2 = "Yes  (max 2)";
	public final static String DEX_BONUS = "Yes";
	
		
	public static void buildModule(AppScreen frame) throws Exception {
		Path modulePath = null;
		// check that the module parent directory exists
		if (!validateModuleDirectory(frame.getTextFieldModuleFolder().getText())) {
			throw new Exception("Error. Module directory not found.");
		}

		if (frame.getChckbxAsDirectory().isSelected()) {
			// Prepare for directory based module
			try {
			removeModFileIfExists(frame.getTextFieldModuleFolder().getText(), frame.getTextFieldModuleName().getText());
			modulePath = createModWorkDirectory(frame.getTextFieldModuleFolder().getText(),
					frame.getTextFieldModuleName().getText());
			} catch ( Exception e ) {
				ModuleGenerator.addLogEntry("Error preparing to deploy module as directory. "+ e.getMessage() );
			}
			// copy thumbnail
			try {
			Files.copy(Path.of(frame.getTextFieldThumbnail().getText()),
					Path.of(modulePath.toString() + ModuleGenerator.delim + "thumbnail.png"), StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error copying thumbnail to module. "+ e.getMessage() );
			}
			// Create definition.xml
			try {
				createDefinitionFile(modulePath, frame);
			} catch (Exception e ) {
				ModuleGenerator.addLogEntry("Error creating definition.xml file. "+ e.getMessage() );
			}
			// TODO: create client.xml
			try {
				createMainModule(modulePath, frame);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error creating main module file. "+ e.getMessage() );
			}
			
		} else {
			// not "As Directory" so we will create a .mod file and remove a directory if
			// present.
		}
	}

	private static void createMainModule(Path modulePath, AppScreen frame) throws Exception {
		//create root
		StringBuffer buff=new StringBuffer();
		buff.append(BEGIN_XML_TAG).append(createOpenRootTag());
		// add library section so it shows up when loaded
		buff.append(buildLibrarySelction(frame.getTextFieldModuleName().getText(),frame.getTextFieldCategory().getText()));
		
		
		// now add sections if they have been checked off (selected)
		if( frame.getChckbxEquipment().isSelected() ) {
			//create <item> element
			try {
				buff = buildItemSection(buff);
			} catch (Exception e ) {
				ModuleGenerator.addLogEntry("Error.  Unable to create <item> element. " + e.getMessage());
			}
		}
		if( frame.getChckbxSpells().isSelected() ) {
			//create <power> element
			try {
				buff = buildPowerSection(buff);
			} catch (Exception e ) {
				ModuleGenerator.addLogEntry("Error.  Unable to create <power> element. " + e.getMessage());
			}
		}
		
		
		buff.append(createCloseTag("root"));
		File file= new File(modulePath.toString() + ModuleGenerator.delim + "client.xml");
		BufferedWriter  writer = null;
		writer=new BufferedWriter(new FileWriter(file));
		writer.write(buff.toString());
		writer.close();
	}
	
	
	private static StringBuffer buildPowerSection(StringBuffer buff) throws Exception {
		buff.append(createOpenTag("spell", null)); //open spell section
		if ( ( ModuleGenerator.powerList != null ) && ( ! ModuleGenerator.powerList.isEmpty() ) ) {
			int curSpellCount = 1;
			for( int i = 0; i < ModuleGenerator.powerList.size(); i++ ) {
				Power e =  ModuleGenerator.powerList.get(i);
				if ( ModuleGenerator.ALLOWED_CONTENT_CODES.contains(e.getContentSource())) {
					final String currId = "id-" + String.format("%05d", (curSpellCount));
					buff.append(createOpenTag(currId, null));
					/*
					 * Begin processing spell data
					 */

					
					
					
					
					
					
					/*
					 * Done processing spell object.
					 */
					buff.append(createCloseTag(currId));
					curSpellCount++;
				}
			}
		}

		buff.append(createCloseTag("spell")); //close spell section
		return buff;
	}

	
	private static String buildLibrarySelction(String moduleName, String moduleCategory) throws Exception {
		StringBuffer buff=new StringBuffer();
		buff.append(createOpenTag("library"));
		String idTag="id-"+moduleName.toLowerCase();
		buff.append(createOpenTag(idTag));
		buff.append(createOpenTag("categoryname", "string")).append(moduleCategory).append(createCloseTag("categoryname"));
		buff.append(createOpenTag("name", "string")).append(moduleName).append(createCloseTag("name"));
		buff.append(createOpenTag("entries")).append(createCloseTag("entries"));
		buff.append(createCloseTag(idTag));
		buff.append(createCloseTag("library"));
		return buff.toString();
	}
	
	private static StringBuffer buildItemSection(StringBuffer buff) throws Exception {

		buff.append(createOpenTag("item", null)); //open item section
		if ( ( ModuleGenerator.equipmentList != null ) && ( ! ModuleGenerator.equipmentList.isEmpty() ) ) {
			int curItemCount = 1;
			for( int i = 0; i < ModuleGenerator.equipmentList.size(); i++ ) {
				Equipment e =  ModuleGenerator.equipmentList.get(i);
				if ( ModuleGenerator.ALLOWED_CONTENT_CODES.contains(e.getContentSource())) {
					final String currId = "id-" + String.format("%05d", (curItemCount));
					buff.append(createOpenTag(currId, null));
					/*
					 * Begin processing item data
					 */
					//** ac
					String dexBonusString = "-";
					buff.append(createOpenTag("ac", "number"));
					if( e.getAc() == null ) {
						buff.append("0");
					} else {
						String acString=e.getAc();
						if( acString.contains("+ Dex modifier") && acString.contains("max 2") ) {
							dexBonusString = DEX_BONUS_PLUS_2;
						} else if (acString.contains("+ Dex modifier")) {
							dexBonusString = DEX_BONUS;
						}
						buff.append(acString.replace("+","").replace("Dex modifier", "").replace("(max 2)", "").trim());
					}
					buff.append(createCloseTag("ac"));
					//** bonus
					buff.append(createOpenTag("bonus", "number"));
					buff.append("0");
					buff.append(createCloseTag("bonus"));
					//**cost
					buff.append(createOpenTag("cost", "string"));
					buff.append(e.getCost()+AppConstants.ITEM_COST_SUFFIX1);
					buff.append(createCloseTag("cost"));
					//**name
					buff.append(createOpenTag("name", "string"));
					buff.append(e.getName());
					buff.append(createCloseTag("name"));
					if(AppConstants.DEBUG)ModuleGenerator.addLogEntry("Item name: "+ e.getName() );
					//**description
					buff.append(createOpenTag("description", "formattedtext"));
					final String desc=e.getDescription();
					if( StringUtils.isBlank(desc) ) {
						buff.append("<p />");
					} else {
						buff.append("<p>").append(desc.replace("***", "").replace("\r\n\r\n", "</p><p>")).append("</p>");
					}
					buff.append(createCloseTag("description"));
					//**isidentified
					buff.append(createOpenTag("isidentified", "number"));
					buff.append("1");
					buff.append(createCloseTag("isidentified"));
					//**locked
					buff.append(createOpenTag("locked", "number"));
					buff.append("1");
					buff.append(createCloseTag("locked"));
					//**type and subtype
					String typeString = "";
					String subtypeString = "";
					final Integer equipCat=(e.getEquipmentCategoryEnum()==null) ? 0 : e.getEquipmentCategoryEnum();
					if (equipCat==3) { //WEAPON
						typeString = "Weapon";
						subtypeString = ( e.getWeaponClassification() ==null) ? "" : splitcamelcase( e.getWeaponClassification() );
					} else if (equipCat==4) { //ARMOR
						typeString = "Armor";
						subtypeString = (e.getArmorClassification()==null)?"": e.getArmorClassification();					
					} else { // all other
						typeString = (e.getEquipmentCategory() == null) ? "Standard" : splitcamelcase( e.getEquipmentCategory() );
						subtypeString = "Adventuring Gear";
					}
					buff.append(createOpenTag("type", "string"));
					buff.append(typeString);
					buff.append(createCloseTag("type"));
					buff.append(createOpenTag("subtype", "string"));
					buff.append(subtypeString);
					buff.append(createCloseTag("subtype"));
					//**weight
					buff.append(createOpenTag("weight", "number"));
					buff.append( (e.getWeight()==null)?"":e.getWeight());
					buff.append(createCloseTag("weight"));
					//**properties
					List<String> propList= (e.getProperties()==null)? new ArrayList<>(): e.getProperties();
					if( ! propList.isEmpty()) {
						buff.append(createOpenTag("properties", "string"));
						for ( int x=0;x<propList.size();x++) {
							if(x>0) buff.append(", ");
							buff.append(propList.get(x));
						}
						buff.append(createCloseTag("properties"));
					}
					/*
					 * set up properties MAP
					 */
					Map <String,String> propMap = new HashMap<>();
					if(e.getPropertiesMap()!=null) {
						propMap = e.getPropertiesMap().getAdditionalProperties();
						if(propMap == null)propMap = new HashMap<>();
					}
					/*
					 * ARMOR SPECIFIC
					 */
					//**dexbonus
					if(equipCat==4) {
						buff.append(createOpenTag("dexbonus", "string"));
						buff.append(dexBonusString);
						buff.append(createCloseTag("dexbonus"));
					//**stealth
						String stealthString = e.getStealthDisadvantage()?"Disadvantage":"-";
						buff.append(createOpenTag("stealth", "string")).append(stealthString);
						buff.append(createCloseTag("stealth"));
					//**strength
						if ( propMap.size() > 0 ) {
							String str = propMap.get("Strength");
							if( StringUtils.isBlank(str))str = "-";
							if( ! StringUtils.isBlank(str)) {
								buff.append(createOpenTag("strength", "string"));
								buff.append(str.replace("strength", "Str"));
								buff.append(createCloseTag("strength"));	
							}
						}
						
					}
					/*
					 * WEAPON SPECIFIC
					 */
					if(equipCat==3) {
						String damType=(e.getDamageType()==null)?"":e.getDamageType().toLowerCase();
						Integer damNumDie=(e.getDamageNumberOfDice()==null)?0:e.getDamageNumberOfDice();
						Integer damDieType=(e.getDamageDieType()==null)?0:e.getDamageDieType();
						Integer damDieModifier=(e.getDamageDieModifier()==null)?0:e.getDamageDieModifier();
						//**damage
						StringBuffer dambuff=new StringBuffer();
						if(damNumDie > 0) {
							dambuff.append(damNumDie.toString()+"d"+damDieType);
							if(damDieModifier!=0) {
								dambuff.append("+"+damDieModifier);
							}
							dambuff.append(" "+damType);
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

		buff.append(createCloseTag("item")); //close item section
		return buff;
	}
	
	private static String splitcamelcase(String sourceString) {
		
		String retVal = "";
		
		StringBuffer buf = new StringBuffer();
		String[] array = StringUtils.splitByCharacterTypeCamelCase(sourceString);
		if ( array != null ) {
			for ( int i=0;i < array.length; i++ ) {
				if( ! StringUtils.isBlank(array[i])) {
					if(i>0) buf.append(" ");
					buf.append(array[i].replace("And", "and").replace( "Or", "or"));
				}
			}
			retVal = buf.toString();
		}
		
		return retVal;
	}
	
	private static String createOpenRootTag() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return "<root dataversion=\""+dateFormat.format(new Date())+"\" version=\""+AppConstants.DEFINITION_MIN_VERSION+"\">";
	}
	
	private static String createOpenTag(String name, String type) throws Exception {
		StringBuffer retVal=new StringBuffer();
		if( ! StringUtils.isBlank(name)) {
			retVal.append("<"+name);
			if ( ! StringUtils.isBlank(type)) {
				retVal.append(" type=\""+type+"\"");
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
		StringBuffer retVal=new StringBuffer();
		if( ! StringUtils.isBlank(name)) {
			retVal.append("</"+name+">");
		} else {
			throw new Exception("Invalid call to AppModuleBuild.createCloseTag. Field 'name' is blank.");
		}
		
		
		return retVal.toString();
	}
	
	private static void createDefinitionFile(Path modulePath, AppScreen frame)
			throws TransformerException, ParserConfigurationException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		// root element
		Element rootElement = doc.createElement("root");
		doc.appendChild(rootElement);
		rootElement.setAttribute("version", AppConstants.DEFINITION_MIN_VERSION);
		rootElement.setAttribute("dataversion", dateFormat.format(new Date()));
		Element nameElement = doc.createElement("name");
		nameElement.setTextContent(frame.getTextFieldModuleName().getText());
		rootElement.appendChild(nameElement);
		Element categoryElement = doc.createElement("ruleset");
		categoryElement.setTextContent(frame.getTextFieldCategory().getText());
		rootElement.appendChild(categoryElement);
		Element authorElement = doc.createElement("author");
		authorElement.setTextContent(frame.getTextFieldAuthor().getText());
		rootElement.appendChild(authorElement);
		Element rulesetElement = doc.createElement("ruleset");
		rulesetElement.setTextContent(AppConstants.DEFINITION_RULESET);
		rootElement.appendChild(rulesetElement);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(modulePath.toString() + ModuleGenerator.delim + "definition.xml"));
		transformer.transform(source, result);
	}

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
