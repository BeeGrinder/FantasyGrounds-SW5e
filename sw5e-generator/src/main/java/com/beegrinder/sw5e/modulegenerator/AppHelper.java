package com.beegrinder.sw5e.modulegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Parcel;
import com.beegrinder.sw5e.objects.Power;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AppHelper {

	public static String getDeliminator() {
		String retVal = "/";
		if ( SystemUtils.IS_OS_WINDOWS ) {
			retVal = "\\";
		}
		return retVal;
	}
	
	public static List<Parcel> parcelListFromJson(String parcelJson) {

		List<Parcel> retVal = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
//		TypeFactory typeFactory = objectMapper.getTypeFactory();	
		try {
			if ( StringUtils.isBlank(parcelJson)) {
				throw new Exception("Parcel data is empty");
			}
			Parcel[] parcelArray = objectMapper.readValue(parcelJson, Parcel[].class);
			retVal = Arrays.asList(parcelArray);
		} catch (Exception e) {
			ModuleGenerator.addLogEntry("Error in parcelListFromJson: " + e.getMessage());
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

		frame.getTextFieldModuleFolder().setText(defaultProps.getProperty("module.destination"));
		frame.getTextFieldThumbnail().setText(defaultProps.getProperty("module.thumbnail"));
		frame.getTextFieldParcelFile().setText(defaultProps.getProperty("input.filename.parcels"));
		frame.getTextFieldSpellsFile().setText(defaultProps.getProperty("input.filename.spells"));
		frame.getTextFieldEquipmentFile().setText(defaultProps.getProperty("input.filename.items"));
		frame.getTextFieldPar5eFile().setText(defaultProps.getProperty("input.filename.par5eclient"));
		frame.getTextFieldDefinitionFile().setText(defaultProps.getProperty("input.filename.par5edefinition"));
		frame.getChckbxEquipment().setSelected(false);
		frame.getChckbxSpells().setSelected(false);
		frame.getChckbxParcels().setSelected(false);
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
