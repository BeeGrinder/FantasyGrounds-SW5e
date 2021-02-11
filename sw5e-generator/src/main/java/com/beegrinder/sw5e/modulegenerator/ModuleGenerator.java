package com.beegrinder.sw5e.modulegenerator;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.SwingConstants;

import com.beegrinder.sw5e.objects.Action;
import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Parcel;
import com.beegrinder.sw5e.objects.Spell;

public class ModuleGenerator {

	static Properties defaultProps = new Properties();
	static AppScreen frame = null;
	static AppScreenActions actions;
	static List<Equipment> equipmentList = new ArrayList<>();
	static List<Spell> spellList=new ArrayList<>();
	static List<Parcel> parcelList = new ArrayList<>();
	static List<Action> actionList = new ArrayList<>();
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static String delim;
	static List<String> ALLOWED_CONTENT_CODES = new ArrayList<>(Arrays.asList("PHB"));
	static Connection conn=null;
	
	public static void loadDefaultProperties() throws IOException {

		FileInputStream in = new FileInputStream(AppConstants.DEFAULT_PROPERTIES_FILENAME);
		defaultProps.load(in);
		in.close();

	}

	public static void main(String[] args) {
		// load properties
		try {
			delim = AppHelper.getDeliminator();
			loadDefaultProperties();
			if (!AppHelper.validateDefaultProperties(defaultProps)) {
				throw new IOException("Invalid defaultProperties file data found.");
			}
		} catch (Exception e) {
			addLogEntry("Unable to load default properties. " + e.getMessage());
			System.exit(1);
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					frame = new AppScreen();

					AppHelper.populateDefaultsToScreen(frame, defaultProps); // sloppy reference call

					// TODO: remove disabled after developed
					// ***** DEV SETTINGS *****
					frame.getChckbxParcels().setEnabled(false);
					//frame.getChckbxSpells().setEnabled(false);
					frame.getChckbxAsDirectory().setSelected(true);
					frame.getChckbxAsDirectory().setEnabled(false);
					// ***** END DEV SETTINGS *****
					
					// TODO: the list refreshes should be triggered by a button.
					frame.getChckbxSpells().setText("Spells (" + spellList.size() + ")");
					frame.getChckbxEquipment().setText("Equipment (" + equipmentList.size() + ")");
					frame.getChckbxParcels().setText("Parcels (" + parcelList.size() + ")");
					// fix checkboxes
					frame.getChckbxParcels().setHorizontalTextPosition(SwingConstants.LEFT);
					frame.getChckbxEquipment().setHorizontalTextPosition(SwingConstants.LEFT);
					frame.getChckbxSpells().setHorizontalTextPosition(SwingConstants.LEFT);
					// end of screen updates

					frame.setVisible(true);
				} catch (Exception e) {
					addLogEntry("Error in main. " + e.getMessage());
				}
			}
		});
	}

	public static void addLogEntry(String message) {
		frame.getTextAreaLogOutput().append("\n" + dateFormat.format(new Date()) + ": " + message);
		frame.getTextAreaLogOutput().update(frame.getTextAreaLogOutput().getGraphics());

	}

}
