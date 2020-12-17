package com.beegrinder.sw5e.modulegenerator;


import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Power;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.node.ArrayNode;


public class ModuleGenerator {




	static Properties defaultProps = new Properties();
	static AppScreen frame = null;
	static List< Equipment > equipmentList = new ArrayList<>();
	static List< Power > powerList = new ArrayList<>();




	public static void loadDefaultProperties() throws IOException {

		List< Equipment > equipmentList;
		FileInputStream in = new FileInputStream( AppConstants.DEFAULT_PROPERTIES_FILENAME );
		defaultProps.load( in );
		in.close();

	}




	public static void main( String[] args ) {
		// load properties
		try {
			loadDefaultProperties();
			if ( ! AppHelper.validateDefaultProperties( defaultProps ) ) {
				throw new IOException( "Invalid defaultProperties file data found." );
			}
		} catch ( Exception e ) {
			System.out.println( "Unable to load default properties. " + e.getMessage() );
			System.exit( 1 );
		}

		EventQueue.invokeLater( new Runnable() {

			public void run() {

				try {
					frame = new AppScreen();

					AppHelper.populateDefaultsToScreen( frame, defaultProps );  //sloppy reference call

					//TODO: the list refreshes should be triggered by a button.
					//TODO: the sw5e raw data should be from a file rather than rest request for tracking changes.
					equipmentList=AppHelper.refreshEquipmentList( AppHelper.getEquipmentUrl( defaultProps ) );
					frame.getChckbxEquipment().setText( "Equipment ("+equipmentList.size()+")" );
					powerList=AppHelper.refreshPowerList( AppHelper.getPowerUrl( defaultProps ) );
					frame.getChckbxSpells().setText( "Spells (" + powerList.size() + ")");
					// end of screen updates

					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

}
