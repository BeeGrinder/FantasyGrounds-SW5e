package com.beegrinder.sw5e.modulegenerator;

import java.awt.event.ActionEvent;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;


public class AppScreenActions {

	public static void actionBtnBuild(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnBuild");
		try {
			AppModuleBuild.buildModule(frame);
		} catch (Exception ex) {
			ModuleGenerator.addLogEntry("Error! "+ ex.getMessage());
		}
	}

	public static void actionBtnModuleFolder(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnModuleFolder");
	}

	public static void actionBtnParcelFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnParcelFile");
	}

	public static void actionBtnActionFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnActionFile");
	}

	public static void actionBtnEquipmentFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnEquipmentFile");
	}

	public static void actionBtnSpellFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnSpellFile");
	}

	public static void actionChkAsDirectory(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkAsDirectory");
	}

	public static void actionChkParcelFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkParcelFile");
		if(frame.getChckbxParcels().isEnabled()) {
			String parcelFileName = frame.getTextFieldParcelFile().getText();
			try {
				Path filePath = Path.of(parcelFileName);
				String content = Files.readString(filePath,StandardCharsets.UTF_8).replaceAll("\\r\\n", "");
				ModuleGenerator.parcelList = AppHelper.parcelListFromJson(content);
				frame.getChckbxParcels().setText("Parcel (" + ModuleGenerator.parcelList.size() + ")");
				
			}
			catch (NoSuchFileException nsf) {
				ModuleGenerator.addLogEntry("File not found: " + nsf.getMessage());
			}
			catch (Exception ex) {
				ModuleGenerator.addLogEntry("Error reading equipment file: " + ex.getMessage());
			}
		}
	}

	public static void actionChkActionFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkActionFile");
	}

	public static void actionChkEquipementFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkEquipementFile");
		if(frame.getChckbxEquipment().isEnabled()) {
			String equipFileName = frame.getTextFieldEquipmentFile().getText();
			try {
				//open database if not already open
				if( ModuleGenerator.conn == null ) {
					String spellFileName = frame.getTextFieldSpellsFile().getText();
					AppPowerDb.connect(spellFileName);
				}
				Path filePath = Path.of(equipFileName);
				String content = Files.readString(filePath,StandardCharsets.UTF_8).replaceAll("\\r\\n", "");
				ModuleGenerator.equipmentList = AppHelper.equipmentListFromJson(content);
				frame.getChckbxEquipment().setText("Equipment (" + ModuleGenerator.equipmentList.size() + ")");
				frame.getChckbxParcels().setEnabled(true);
			}
			catch (NoSuchFileException nsf) {
				ModuleGenerator.addLogEntry("File not found: " + nsf.getMessage());
			}
			catch (Exception ex) {
				ModuleGenerator.addLogEntry("Error reading equipment file: " + ex.getMessage());
			}
		}
	}

	public static void actionChkSpellFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkSpellFile");
		if(frame.getChckbxSpells().isEnabled()) {
			try {
				//open database if not already open
				if( ModuleGenerator.conn == null ) {
					String spellFileName = frame.getTextFieldSpellsFile().getText();
					AppPowerDb.connect(spellFileName);
				}
				Integer count=AppPowerDb.getSpellCount();
				if( count != null ) {
					frame.getChckbxSpells().setText("Spells (" + count + ")");	
					AppPowerDb.populateSpellList();
				} else {
					ModuleGenerator.addLogEntry("Error getting spell count.");
				}
			}
			catch (Exception ex) {
				ModuleGenerator.addLogEntry("Error reading spell database: " + ex.getMessage());
			}
		}

	}

	public static void actionTxtModuleName(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionTxtModuleName");
	}

	public static void actionTxtCategory(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionTxtCategory");
	}

	public static void actionTxtAuthor(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionTxtAuthor");
	}
}
