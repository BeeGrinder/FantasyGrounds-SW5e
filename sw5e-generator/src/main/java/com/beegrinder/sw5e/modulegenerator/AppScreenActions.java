package com.beegrinder.sw5e.modulegenerator;

import java.awt.event.ActionEvent;

public class AppScreenActions {

	public static void actionBtnBuild(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionBtnBuild");
		System.out.println("Action List Size: " + ModuleGenerator.actionList.size());
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
	}

	public static void actionChkSpellFile(AppScreen frame, ActionEvent e) {
		System.out.println("Action: actionChkSpellFile");
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
