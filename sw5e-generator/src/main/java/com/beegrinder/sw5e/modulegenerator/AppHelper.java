package com.beegrinder.sw5e.modulegenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Power;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppHelper {

	public static void buildModule(AppScreen frame) throws Exception {
		// check that the module parent directory exists
		if ( ! validateModuleDirectory(frame.getTextFieldModuleFolder().getText())) {
			throw new Exception("Error. Module directory not found.");
		}
		
		if( frame.getChckbxAsDirectory().isSelected() ) {
			// "As Directory" removes a .mod file if present and puts files in module directory
			removeModFileIfExists(frame.getTextFieldModuleFolder().getText(), frame.getTextFieldModuleName().getText());
			
		} else {
			// not "As Directory" so we will create a .mod file and remove a directory if present.
		}
	}
	
	private static void removeModFileIfExists(String modDir, String modName ) {
		Path path = Path.of(modDir+"\\"+modName);
		if ( Files.exists(path) ) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				ModuleGenerator.addLogEntry("Error.  Unable to remove .mod file. "+ e.getMessage());
			}
		}
	}
	
	private static boolean validateModuleDirectory(String folderName ) {
		boolean retVal = false;
		Path path = Path.of(folderName);
		if ( Files.exists( path )  && Files.isDirectory( path ) ) {
			retVal = true;
	}
		
		
		return retVal;
	}
	
	public static List<Equipment> equipmentListFromJson(String equipmentJson) {

		List<Equipment> retVal = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
//		TypeFactory typeFactory = objectMapper.getTypeFactory();	
		try {
			if ( StringUtils.isBlank(equipmentJson)) {
				throw new Exception("Equipment data is empty");
			}
			Equipment[] equipArray = objectMapper.readValue(equipmentJson, Equipment[].class);
			retVal = Arrays.asList(equipArray);
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error in equipmentListFromJson: " + e.getMessage());
		}

		return retVal;
	}


	public static String getEquipmentUrl(Properties defaultProps) {

		String retVal = new String();

		String urlString = defaultProps.getProperty("sw5e.api.url") + "/"
				+ defaultProps.getProperty("sw5e.api.equipment");
		if (StringUtils.isNotBlank(urlString)) {
			retVal = urlString;
		}

		return retVal;
	}

	public static String getPowerUrl(Properties defaultProps) {

		String retVal = new String();

		String urlString = defaultProps.getProperty("sw5e.api.url") + "/" + defaultProps.getProperty("sw5e.api.spells");
		if (StringUtils.isNotBlank(urlString)) {
			retVal = urlString;
		}

		return retVal;
	}

	public static void populateDefaultsToScreen(AppScreen frame, Properties defaultProps) {

		frame.getTextFieldModuleName().setText(defaultProps.getProperty("module.name"));
		frame.getTextFieldCategory().setText(defaultProps.getProperty("module.category"));
		frame.getTextFieldAuthor().setText(defaultProps.getProperty("module.author"));
		frame.getTextFieldModuleFolder().setText(defaultProps.getProperty("module.destination"));
		frame.getTextFieldParcelFile().setText(defaultProps.getProperty("input.filename.parcels"));
		frame.getTextFieldActionsFile().setText(defaultProps.getProperty("input.filename.actions"));
		frame.getTextFieldSpellsFile().setText(defaultProps.getProperty("input.filename.spells"));
		frame.getTextFieldEquipmentFile().setText(defaultProps.getProperty("input.filename.items"));
		frame.getChckbxEquipment().setSelected(false);
		frame.getChckbxSpells().setSelected(false);
		frame.getChckbxParcels().setSelected(false);
		frame.getChckbxActions().setSelected(false);
		ModuleGenerator.addLogEntry("Logging...");
		ModuleGenerator.addLogEntry("Defaults read from properties file.");
	}

	public static List<Power> powerListFromJson(String powerJson) {

		List<Power> retVal = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
//		TypeFactory typeFactory = objectMapper.getTypeFactory();	
		try {
			if ( StringUtils.isBlank(powerJson)) {
				throw new Exception("Spell data is empty");
			}
			Power[] powerArray = objectMapper.readValue(powerJson, Power[].class);
			retVal = Arrays.asList(powerArray);
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error in powerListFromJson: " + e.getMessage());

		}

		return retVal;
	}

	public static boolean validateDefaultProperties(Properties properties) {

		return true;
	}
}
