package com.beegrinder.sw5e.modulegenerator;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.SwingConstants;

import com.beegrinder.sw5e.objects.Action;
import com.beegrinder.sw5e.objects.Equipment;
import com.beegrinder.sw5e.objects.Parcel;
import com.beegrinder.sw5e.objects.Power;

public class ModuleGenerator {

	static Properties defaultProps = new Properties();
	static AppScreen frame = null;
	static AppScreenActions actions;
	static List<Equipment> equipmentList = new ArrayList<>();
	static List<Power> powerList = new ArrayList<>();
	static List<Parcel> parcelList = new ArrayList<>();
	static List<Action> actionList = new ArrayList<>();

	public static void loadDefaultProperties() throws IOException {

		List<Equipment> equipmentList;
		FileInputStream in = new FileInputStream(AppConstants.DEFAULT_PROPERTIES_FILENAME);
		defaultProps.load(in);
		in.close();

	}

	public static void main(String[] args) {
		// load properties
		try {
			loadDefaultProperties();
			if (!AppHelper.validateDefaultProperties(defaultProps)) {
				throw new IOException("Invalid defaultProperties file data found.");
			}
		} catch (Exception e) {
			System.out.println("Unable to load default properties. " + e.getMessage());
			System.exit(1);
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					frame = new AppScreen();

					AppHelper.populateDefaultsToScreen(frame, defaultProps); // sloppy reference call

					// TODO: the list refreshes should be triggered by a button.
					frame.getChckbxSpells().setText("Spells (" + powerList.size() + ")");
					frame.getChckbxEquipment().setText("Equipment (" + equipmentList.size() + ")");
					frame.getChckbxActions().setText("Actions (" + actionList.size() + ")");
					frame.getChckbxParcels().setText("Parcels (" + parcelList.size() + ")");
					// fix checkboxes
					frame.getChckbxParcels().setHorizontalTextPosition(SwingConstants.LEFT);
					frame.getChckbxEquipment().setHorizontalTextPosition(SwingConstants.LEFT);
					frame.getChckbxActions().setHorizontalTextPosition(SwingConstants.LEFT);
					frame.getChckbxSpells().setHorizontalTextPosition(SwingConstants.LEFT);
					// end of screen updates

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
