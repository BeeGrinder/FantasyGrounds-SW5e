package com.beegrinder.sw5e.modulegenerator;


import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Power;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.*;

import org.apache.commons.lang3.StringUtils;


public class AppHelper {




	public static boolean validateDefaultProperties( Properties properties ) {

		return true;
	}




	public static boolean stringEmptyOrNull( String string ) {

		boolean retVal = false;
		if ( StringUtils.isBlank( string ) ) {
			retVal = true;
		}

		return retVal;
	}




	public static String stringGetter( String string ) {

		String retVal = new String();
		if ( StringUtils.isNotBlank( string ) ) {
			retVal = string;
		}

		return retVal;
	}




	public static void populateDefaultsToScreen(
	  AppScreen frame,
	  Properties defaultProps
	) {

		frame.getTextFieldModuleName().setText( defaultProps.getProperty( "module.name" ) );
		frame.getTextFieldCategory().setText( defaultProps.getProperty( "module.category" ) );
		frame.getTextFieldAuthor().setText( defaultProps.getProperty( "module.author" ) );
		frame.getTextFieldModuleFolder().setText( defaultProps.getProperty( "module.destination" ) );
		frame.getTextFieldParcelFile().setText( defaultProps.getProperty( "input.filename.parcels" ) );
		frame.getTextFieldActionsFile().setText( defaultProps.getProperty( "input.filename.actions" ) );
		frame.getTextFieldSpellsFile().setText( defaultProps.getProperty( "input.filename.spells" ) );
		frame.getTextFieldEquipmentFile().setText( defaultProps.getProperty( "input.filename.items" ) );
		frame.getChckbxEquipment().setSelected( true );
		frame.getChckbxSpells().setSelected( false );
		frame.getChckbxParcels().setSelected( false );
		frame.getChckbxActions().setSelected( false );
		frame.getTextAreaLogOutput().setText( "Logging" );
	}




	public static String getEquipmentUrl( Properties defaultProps ) {

		String retVal = new String();

		String urlString = defaultProps.getProperty( "sw5e.api.url" ) + "/" + defaultProps.getProperty(
		  "sw5e.api.equipment" );
		if ( StringUtils.isNotBlank( urlString ) ) {
			retVal = urlString;
		}

		return retVal;
	}


	public static String getPowerUrl( Properties defaultProps ) {

		String retVal = new String();

		String urlString = defaultProps.getProperty( "sw5e.api.url" ) + "/" + defaultProps.getProperty(
		  "sw5e.api.spells" );
		if ( StringUtils.isNotBlank( urlString ) ) {
			retVal = urlString;
		}

		return retVal;
	}

	public static List< Equipment > refreshEquipmentList( String equipmentUrl ) {

		List< Equipment > retVal = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		try {
			String payloadString = AppWebHelper.getRestData( equipmentUrl );
			Equipment[] equipArray = objectMapper.readValue( payloadString,Equipment[].class );
			retVal = Arrays.asList( equipArray );
		} catch ( JsonProcessingException e ) {
			 e.printStackTrace();
			// Logger.error( ${CLASS_NAME}.class, "Message" );

		}


		return retVal;
	}

	public static List< Power > refreshPowerList( String powerUrl ) {

		List< Power > retVal = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		TypeFactory typeFactory = objectMapper.getTypeFactory();
		try {
			String payloadString = AppWebHelper.getRestData( powerUrl );
			Power[] powerArray = objectMapper.readValue( payloadString,Power[].class );
			retVal = Arrays.asList( powerArray );
		} catch ( JsonProcessingException e ) {
			e.printStackTrace();
			// Logger.error( ${CLASS_NAME}.class, "Message" );

		}


		return retVal;
	}

}

