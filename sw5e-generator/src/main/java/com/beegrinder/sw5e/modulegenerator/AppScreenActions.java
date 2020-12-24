package com.beegrinder.sw5e.modulegenerator;

import java.awt.event.ActionEvent;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;


public class AppScreenActions {

	public static void actionBtnBuild(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnBuild");

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
	}

	public static void actionChkActionFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkActionFile");
	}

	public static void actionChkEquipementFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkEquipementFile");
		if(frame.getChckbxEquipment().isEnabled()) {
			String equipFileName = frame.getTextFieldEquipmentFile().getText();
			try {
				Path filePath = Path.of(equipFileName);
				String content = Files.readString(filePath,StandardCharsets.UTF_8);
				ModuleGenerator.equipmentList = AppHelper.equipmentListFromJson(content);
				frame.getChckbxEquipment().setText("Equipment (" + ModuleGenerator.equipmentList.size() + ")");
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
			String spellFileName = frame.getTextFieldSpellsFile().getText();
			try {
				Path filePath = Path.of(spellFileName);
				String content = Files.readString(filePath,StandardCharsets.UTF_8);
				ModuleGenerator.powerList = AppHelper.powerListFromJson(content);
				frame.getChckbxSpells().setText("Spells (" + ModuleGenerator.powerList.size() + ")");
			}
			catch (NoSuchFileException nsf) {
				ModuleGenerator.addLogEntry("File not found: " + nsf.getMessage());
			}
			catch (Exception ex) {
				ModuleGenerator.addLogEntry("Error reading spell file: " + ex.getMessage());
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
