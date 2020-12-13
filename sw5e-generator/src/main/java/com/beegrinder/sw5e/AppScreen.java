package com.beegrinder.sw5e;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class AppScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldModuleName;
	private JTextField textFieldCategory;
	private JTextField textFieldAuthor;
	private JTextField textFieldModuleFolder;
	private JTextField textFieldParcelFile;
	private JTextField textFieldActionsFile;
	private JCheckBox chckbxSpells;
	private JCheckBox chckbxEquipment;
	private JCheckBox chckbxAddParcels;
	private JCheckBox chckbxAddActions;
	private JTextArea textAreaLogOutput;
	private JButton btnBuild;
	private JButton btnModuleFolder;
	private JButton btnParcelFile;
	private JButton btnActionsFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppScreen frame = new AppScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppScreen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\sw5e-dev\\eclipse\\sw5e-generator\\sw5e-icon.png"));
		setTitle("SW5e Module Generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblModuleName = new JLabel("Module Name");
		GridBagConstraints gbc_lblModuleName = new GridBagConstraints();
		gbc_lblModuleName.anchor = GridBagConstraints.EAST;
		gbc_lblModuleName.insets = new Insets(0, 0, 5, 5);
		gbc_lblModuleName.gridx = 0;
		gbc_lblModuleName.gridy = 1;
		contentPane.add(lblModuleName, gbc_lblModuleName);
		
		textFieldModuleName = new JTextField();
		GridBagConstraints gbc_textFieldModuleName = new GridBagConstraints();
		gbc_textFieldModuleName.gridwidth = 7;
		gbc_textFieldModuleName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldModuleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldModuleName.gridx = 1;
		gbc_textFieldModuleName.gridy = 1;
		contentPane.add(textFieldModuleName, gbc_textFieldModuleName);
		textFieldModuleName.setColumns(10);
		
		btnBuild = new JButton("Build");
		GridBagConstraints gbc_btnBuild = new GridBagConstraints();
		gbc_btnBuild.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuild.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
		gbc_btnBuild.gridx = 12;
		gbc_btnBuild.gridy = 1;
		contentPane.add(btnBuild, gbc_btnBuild);
		
		JLabel lblCategory = new JLabel("Category");
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.anchor = GridBagConstraints.EAST;
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 2;
		contentPane.add(lblCategory, gbc_lblCategory);
		
		textFieldCategory = new JTextField();
		GridBagConstraints gbc_textFieldCategory = new GridBagConstraints();
		gbc_textFieldCategory.gridwidth = 7;
		gbc_textFieldCategory.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCategory.gridx = 1;
		gbc_textFieldCategory.gridy = 2;
		contentPane.add(textFieldCategory, gbc_textFieldCategory);
		textFieldCategory.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.anchor = GridBagConstraints.EAST;
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 3;
		contentPane.add(lblAuthor, gbc_lblAuthor);
		
		textFieldAuthor = new JTextField();
		GridBagConstraints gbc_textFieldAuthor = new GridBagConstraints();
		gbc_textFieldAuthor.gridwidth = 7;
		gbc_textFieldAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAuthor.gridx = 1;
		gbc_textFieldAuthor.gridy = 3;
		contentPane.add(textFieldAuthor, gbc_textFieldAuthor);
		textFieldAuthor.setColumns(10);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 13;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 4;
		contentPane.add(separator, gbc_separator);
		
		JLabel lblModuleFolder = new JLabel("Module Folder");
		GridBagConstraints gbc_lblModuleFolder = new GridBagConstraints();
		gbc_lblModuleFolder.anchor = GridBagConstraints.EAST;
		gbc_lblModuleFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblModuleFolder.gridx = 0;
		gbc_lblModuleFolder.gridy = 5;
		contentPane.add(lblModuleFolder, gbc_lblModuleFolder);
		
		textFieldModuleFolder = new JTextField();
		GridBagConstraints gbc_textFieldModuleFolder = new GridBagConstraints();
		gbc_textFieldModuleFolder.gridwidth = 11;
		gbc_textFieldModuleFolder.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldModuleFolder.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldModuleFolder.gridx = 1;
		gbc_textFieldModuleFolder.gridy = 5;
		contentPane.add(textFieldModuleFolder, gbc_textFieldModuleFolder);
		textFieldModuleFolder.setColumns(10);
		
		btnModuleFolder = new JButton("Select");
		GridBagConstraints gbc_btnModuleFolder = new GridBagConstraints();
		gbc_btnModuleFolder.insets = new Insets(0, 0, 5, 0);
		gbc_btnModuleFolder.gridx = 12;
		gbc_btnModuleFolder.gridy = 5;
		contentPane.add(btnModuleFolder, gbc_btnModuleFolder);
		
		JLabel lblParcelFile = new JLabel("ParcelFile");
		GridBagConstraints gbc_lblParcelFile = new GridBagConstraints();
		gbc_lblParcelFile.anchor = GridBagConstraints.EAST;
		gbc_lblParcelFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblParcelFile.gridx = 0;
		gbc_lblParcelFile.gridy = 6;
		contentPane.add(lblParcelFile, gbc_lblParcelFile);
		
		textFieldParcelFile = new JTextField();
		GridBagConstraints gbc_textFieldParcelFile = new GridBagConstraints();
		gbc_textFieldParcelFile.gridwidth = 11;
		gbc_textFieldParcelFile.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldParcelFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldParcelFile.gridx = 1;
		gbc_textFieldParcelFile.gridy = 6;
		contentPane.add(textFieldParcelFile, gbc_textFieldParcelFile);
		textFieldParcelFile.setColumns(10);
		
		btnParcelFile = new JButton("Select");
		GridBagConstraints gbc_btnParcelFile = new GridBagConstraints();
		gbc_btnParcelFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnParcelFile.gridx = 12;
		gbc_btnParcelFile.gridy = 6;
		contentPane.add(btnParcelFile, gbc_btnParcelFile);
		
		JLabel lblActionsFile = new JLabel("Actions File");
		GridBagConstraints gbc_lblActionsFile = new GridBagConstraints();
		gbc_lblActionsFile.anchor = GridBagConstraints.EAST;
		gbc_lblActionsFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblActionsFile.gridx = 0;
		gbc_lblActionsFile.gridy = 7;
		contentPane.add(lblActionsFile, gbc_lblActionsFile);
		
		textFieldActionsFile = new JTextField();
		GridBagConstraints gbc_textFieldActionsFile = new GridBagConstraints();
		gbc_textFieldActionsFile.gridwidth = 11;
		gbc_textFieldActionsFile.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldActionsFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldActionsFile.gridx = 1;
		gbc_textFieldActionsFile.gridy = 7;
		contentPane.add(textFieldActionsFile, gbc_textFieldActionsFile);
		textFieldActionsFile.setColumns(10);
		
		btnActionsFile = new JButton("Select");
		GridBagConstraints gbc_btnActionsFile = new GridBagConstraints();
		gbc_btnActionsFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnActionsFile.gridx = 12;
		gbc_btnActionsFile.gridy = 7;
		contentPane.add(btnActionsFile, gbc_btnActionsFile);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridwidth = 13;
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 8;
		contentPane.add(separator_1, gbc_separator_1);
		
		JLabel lblSelectContent = new JLabel("Select Content");
		GridBagConstraints gbc_lblSelectContent = new GridBagConstraints();
		gbc_lblSelectContent.anchor = GridBagConstraints.WEST;
		gbc_lblSelectContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectContent.gridx = 0;
		gbc_lblSelectContent.gridy = 9;
		contentPane.add(lblSelectContent, gbc_lblSelectContent);
		
		chckbxEquipment = new JCheckBox("Equipment");
		GridBagConstraints gbc_chckbxEquipment = new GridBagConstraints();
		gbc_chckbxEquipment.anchor = GridBagConstraints.WEST;
		gbc_chckbxEquipment.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxEquipment.gridx = 1;
		gbc_chckbxEquipment.gridy = 9;
		contentPane.add(chckbxEquipment, gbc_chckbxEquipment);
		
		chckbxAddParcels = new JCheckBox("Parcels");
		GridBagConstraints gbc_chckbxAddParcels = new GridBagConstraints();
		gbc_chckbxAddParcels.anchor = GridBagConstraints.WEST;
		gbc_chckbxAddParcels.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAddParcels.gridx = 2;
		gbc_chckbxAddParcels.gridy = 9;
		contentPane.add(chckbxAddParcels, gbc_chckbxAddParcels);
		
		chckbxSpells = new JCheckBox("Spells");
		GridBagConstraints gbc_chckbxSpells = new GridBagConstraints();
		gbc_chckbxSpells.anchor = GridBagConstraints.WEST;
		gbc_chckbxSpells.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxSpells.gridx = 1;
		gbc_chckbxSpells.gridy = 10;
		contentPane.add(chckbxSpells, gbc_chckbxSpells);
		
		chckbxAddActions = new JCheckBox("Actions");
		GridBagConstraints gbc_chckbxAddActions = new GridBagConstraints();
		gbc_chckbxAddActions.anchor = GridBagConstraints.WEST;
		gbc_chckbxAddActions.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAddActions.gridx = 2;
		gbc_chckbxAddActions.gridy = 10;
		contentPane.add(chckbxAddActions, gbc_chckbxAddActions);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridwidth = 13;
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 11;
		contentPane.add(separator_2, gbc_separator_2);
		
		JLabel lblLogOutput = new JLabel("Log Output");
		GridBagConstraints gbc_lblLogOutput = new GridBagConstraints();
		gbc_lblLogOutput.anchor = GridBagConstraints.WEST;
		gbc_lblLogOutput.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogOutput.gridx = 0;
		gbc_lblLogOutput.gridy = 12;
		contentPane.add(lblLogOutput, gbc_lblLogOutput);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 13;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 13;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textAreaLogOutput = new JTextArea();
		scrollPane.setViewportView(textAreaLogOutput);
	}

	public JTextField getTextFieldModuleName() {
		return textFieldModuleName;
	}
	public JTextField getTextFieldCategory() {
		return textFieldCategory;
	}
	public JTextField getTextFieldAuthor() {
		return textFieldAuthor;
	}
	public JTextField getTextFieldModuleFolder() {
		return textFieldModuleFolder;
	}
	public JTextField getTextFieldParcelFile() {
		return textFieldParcelFile;
	}
	public JTextField getTextFieldActionsFile() {
		return textFieldActionsFile;
	}
	public JCheckBox getChckbxSpells() {
		return chckbxSpells;
	}
	public JCheckBox getChckbxEquipment() {
		return chckbxEquipment;
	}
	public JCheckBox getChckbxAddParcels() {
		return chckbxAddParcels;
	}
	public JCheckBox getChckbxAddActions() {
		return chckbxAddActions;
	}
	public JTextArea getTextAreaLogOutput() {
		return textAreaLogOutput;
	}
	public JButton getBtnBuild() {
		return btnBuild;
	}
	public JButton getBtnModuleFolder() {
		return btnModuleFolder;
	}
	public JButton getBtnParcelFile() {
		return btnParcelFile;
	}
	public JButton getBtnActionsFile() {
		return btnActionsFile;
	}
}
