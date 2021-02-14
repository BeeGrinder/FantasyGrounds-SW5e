package com.beegrinder.sw5e.modulegenerator;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;

public class AppScreen extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldModuleFolder;
	private JTextField textFieldParcelFile;
	private JCheckBox chckbxSpells;
	private JCheckBox chckbxEquipment;
	private JCheckBox chckbxParcels;
	private JButton btnBuild;
	private JButton btnModuleFolder;
	private JButton btnParcelFile;
	private JTextField textFieldEquipmentFile;
	private JTextField textFieldSpellsFile;
	private JButton btnEquipmentFile;
	private JButton btnSpellsFile;
	private JScrollPane scrollPane;
	private JTextArea textAreaLogOutput;
	private JCheckBox chckbxAsDirectory;
	private JSeparator separator_1;
	private JLabel lblRuntimeNotes;
	private JLabel lblThumbnail;
	private JTextField textFieldThumbnail;
	private JButton btnThumbnail;
	private JLabel lblPar5eFile;
	private JTextField textFieldPar5eFile;
	private JButton btnPar5eFile;
	private JSeparator separator_2;
	private JLabel lblDefinitionFile;
	private JTextField textFieldDefinitionFile;
	private JButton btnDefinitionFile;
	private JLabel lblModuleName;

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
		setBounds(100, 100, 602, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
		lblModuleName = new JLabel("Module Name:");
		GridBagConstraints gbc_lblModuleName = new GridBagConstraints();
		gbc_lblModuleName.insets = new Insets(0, 0, 5, 5);
		gbc_lblModuleName.gridx = 1;
		gbc_lblModuleName.gridy = 0;
		contentPane.add(lblModuleName, gbc_lblModuleName);

		chckbxAsDirectory = new JCheckBox("As Folder");
		GridBagConstraints gbc_chckbxAsDirectory = new GridBagConstraints();
		gbc_chckbxAsDirectory.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAsDirectory.gridx = 9;
		gbc_chckbxAsDirectory.gridy = 1;
		contentPane.add(chckbxAsDirectory, gbc_chckbxAsDirectory);

		btnBuild = new JButton("Build");
		GridBagConstraints gbc_btnBuild = new GridBagConstraints();
		gbc_btnBuild.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuild.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
		gbc_btnBuild.gridx = 12;
		gbc_btnBuild.gridy = 1;
		contentPane.add(btnBuild, gbc_btnBuild);
		
		lblPar5eFile = new JLabel("Par5e Client File");
		GridBagConstraints gbc_lblPar5eFile = new GridBagConstraints();
		gbc_lblPar5eFile.anchor = GridBagConstraints.EAST;
		gbc_lblPar5eFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblPar5eFile.gridx = 0;
		gbc_lblPar5eFile.gridy = 2;
		contentPane.add(lblPar5eFile, gbc_lblPar5eFile);
		
		textFieldPar5eFile = new JTextField();
		textFieldPar5eFile.setEditable(false);
		textFieldPar5eFile.setColumns(10);
		GridBagConstraints gbc_textFieldPar5eFile = new GridBagConstraints();
		gbc_textFieldPar5eFile.gridwidth = 11;
		gbc_textFieldPar5eFile.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPar5eFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPar5eFile.gridx = 1;
		gbc_textFieldPar5eFile.gridy = 2;
		contentPane.add(textFieldPar5eFile, gbc_textFieldPar5eFile);
		
		btnPar5eFile = new JButton("Select");
		btnPar5eFile.setEnabled(false);
		GridBagConstraints gbc_btnPar5eFile = new GridBagConstraints();
		gbc_btnPar5eFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnPar5eFile.gridx = 12;
		gbc_btnPar5eFile.gridy = 2;
		contentPane.add(btnPar5eFile, gbc_btnPar5eFile);
		
		lblDefinitionFile = new JLabel("Par5e Definition File");
		GridBagConstraints gbc_lblDefinitionFile = new GridBagConstraints();
		gbc_lblDefinitionFile.anchor = GridBagConstraints.EAST;
		gbc_lblDefinitionFile.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefinitionFile.gridx = 0;
		gbc_lblDefinitionFile.gridy = 3;
		contentPane.add(lblDefinitionFile, gbc_lblDefinitionFile);
		
		textFieldDefinitionFile = new JTextField();
		textFieldDefinitionFile.setEditable(false);
		GridBagConstraints gbc_textFieldDefinitionFile = new GridBagConstraints();
		gbc_textFieldDefinitionFile.gridwidth = 11;
		gbc_textFieldDefinitionFile.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDefinitionFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDefinitionFile.gridx = 1;
		gbc_textFieldDefinitionFile.gridy = 3;
		contentPane.add(textFieldDefinitionFile, gbc_textFieldDefinitionFile);
		textFieldDefinitionFile.setColumns(10);
		
		btnDefinitionFile = new JButton("Select");
		btnDefinitionFile.setEnabled(false);
		GridBagConstraints gbc_btnDefinitionFile = new GridBagConstraints();
		gbc_btnDefinitionFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnDefinitionFile.gridx = 12;
		gbc_btnDefinitionFile.gridy = 3;
		contentPane.add(btnDefinitionFile, gbc_btnDefinitionFile);
		
		lblThumbnail = new JLabel("Thumbnail");
		GridBagConstraints gbc_lblThumbnail = new GridBagConstraints();
		gbc_lblThumbnail.anchor = GridBagConstraints.EAST;
		gbc_lblThumbnail.insets = new Insets(0, 0, 5, 5);
		gbc_lblThumbnail.gridx = 0;
		gbc_lblThumbnail.gridy = 4;
		contentPane.add(lblThumbnail, gbc_lblThumbnail);
		
		textFieldThumbnail = new JTextField();
		textFieldThumbnail.setEditable(false);
		GridBagConstraints gbc_textFieldThumbnail = new GridBagConstraints();
		gbc_textFieldThumbnail.gridwidth = 11;
		gbc_textFieldThumbnail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldThumbnail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldThumbnail.gridx = 1;
		gbc_textFieldThumbnail.gridy = 4;
		contentPane.add(textFieldThumbnail, gbc_textFieldThumbnail);
		textFieldThumbnail.setColumns(10);
																		
																		btnThumbnail = new JButton("Select");
																		btnThumbnail.setEnabled(false);
																		GridBagConstraints gbc_btnThumbnail = new GridBagConstraints();
																		gbc_btnThumbnail.insets = new Insets(0, 0, 5, 0);
																		gbc_btnThumbnail.gridx = 12;
																		gbc_btnThumbnail.gridy = 4;
																		contentPane.add(btnThumbnail, gbc_btnThumbnail);
																
																		JLabel lblModuleFolder = new JLabel("Module Destination Folder");
																		GridBagConstraints gbc_lblModuleFolder = new GridBagConstraints();
																		gbc_lblModuleFolder.anchor = GridBagConstraints.EAST;
																		gbc_lblModuleFolder.insets = new Insets(0, 0, 5, 5);
																		gbc_lblModuleFolder.gridx = 0;
																		gbc_lblModuleFolder.gridy = 6;
																		contentPane.add(lblModuleFolder, gbc_lblModuleFolder);
																
																		textFieldModuleFolder = new JTextField();
																		textFieldModuleFolder.setEditable(false);
																		GridBagConstraints gbc_textFieldModuleFolder = new GridBagConstraints();
																		gbc_textFieldModuleFolder.gridwidth = 11;
																		gbc_textFieldModuleFolder.insets = new Insets(0, 0, 5, 5);
																		gbc_textFieldModuleFolder.fill = GridBagConstraints.HORIZONTAL;
																		gbc_textFieldModuleFolder.gridx = 1;
																		gbc_textFieldModuleFolder.gridy = 6;
																		contentPane.add(textFieldModuleFolder, gbc_textFieldModuleFolder);
																		textFieldModuleFolder.setColumns(10);
																
																		btnModuleFolder = new JButton("Select");
																		btnModuleFolder.setEnabled(false);
																		GridBagConstraints gbc_btnModuleFolder = new GridBagConstraints();
																		gbc_btnModuleFolder.insets = new Insets(0, 0, 5, 0);
																		gbc_btnModuleFolder.gridx = 12;
																		gbc_btnModuleFolder.gridy = 6;
																		contentPane.add(btnModuleFolder, gbc_btnModuleFolder);
																		btnModuleFolder.addActionListener(this);
																
																separator_2 = new JSeparator();
																separator_2.setForeground(Color.GRAY);
																GridBagConstraints gbc_separator_2 = new GridBagConstraints();
																gbc_separator_2.fill = GridBagConstraints.HORIZONTAL;
																gbc_separator_2.gridwidth = 13;
																gbc_separator_2.insets = new Insets(0, 0, 5, 5);
																gbc_separator_2.gridx = 0;
																gbc_separator_2.gridy = 8;
																contentPane.add(separator_2, gbc_separator_2);
								
										chckbxEquipment = new JCheckBox("Equipment File");
										GridBagConstraints gbc_chckbxEquipment = new GridBagConstraints();
										gbc_chckbxEquipment.anchor = GridBagConstraints.EAST;
										gbc_chckbxEquipment.insets = new Insets(0, 0, 5, 5);
										gbc_chckbxEquipment.gridx = 0;
										gbc_chckbxEquipment.gridy = 10;
										contentPane.add(chckbxEquipment, gbc_chckbxEquipment);
										chckbxEquipment.addActionListener(this);
						
								textFieldEquipmentFile = new JTextField();
								textFieldEquipmentFile.setEditable(false);
								GridBagConstraints gbc_textFieldEquipmentFile = new GridBagConstraints();
								gbc_textFieldEquipmentFile.gridwidth = 11;
								gbc_textFieldEquipmentFile.insets = new Insets(0, 0, 5, 5);
								gbc_textFieldEquipmentFile.fill = GridBagConstraints.HORIZONTAL;
								gbc_textFieldEquipmentFile.gridx = 1;
								gbc_textFieldEquipmentFile.gridy = 10;
								contentPane.add(textFieldEquipmentFile, gbc_textFieldEquipmentFile);
								textFieldEquipmentFile.setColumns(10);
				
						btnEquipmentFile = new JButton("Select");
						btnEquipmentFile.setEnabled(false);
						GridBagConstraints gbc_btnEquipmentFile = new GridBagConstraints();
						gbc_btnEquipmentFile.insets = new Insets(0, 0, 5, 0);
						gbc_btnEquipmentFile.gridx = 12;
						gbc_btnEquipmentFile.gridy = 10;
						contentPane.add(btnEquipmentFile, gbc_btnEquipmentFile);
						btnEquipmentFile.addActionListener(this);
				
				
																		
																				chckbxParcels = new JCheckBox("Parcel File");
																				chckbxParcels.setHorizontalAlignment(SwingConstants.RIGHT);
																				GridBagConstraints gbc_chckbxParcels = new GridBagConstraints();
																				gbc_chckbxParcels.anchor = GridBagConstraints.EAST;
																				gbc_chckbxParcels.insets = new Insets(0, 0, 5, 5);
																				gbc_chckbxParcels.gridx = 0;
																				gbc_chckbxParcels.gridy = 11;
																				contentPane.add(chckbxParcels, gbc_chckbxParcels);
																				chckbxParcels.addActionListener(this);
				
						textFieldParcelFile = new JTextField();
						textFieldParcelFile.setEditable(false);
						GridBagConstraints gbc_textFieldParcelFile = new GridBagConstraints();
						gbc_textFieldParcelFile.gridwidth = 11;
						gbc_textFieldParcelFile.insets = new Insets(0, 0, 5, 5);
						gbc_textFieldParcelFile.fill = GridBagConstraints.HORIZONTAL;
						gbc_textFieldParcelFile.gridx = 1;
						gbc_textFieldParcelFile.gridy = 11;
						contentPane.add(textFieldParcelFile, gbc_textFieldParcelFile);
						textFieldParcelFile.setColumns(10);
				
						btnParcelFile = new JButton("Select");
						btnParcelFile.setEnabled(false);
						GridBagConstraints gbc_btnParcelFile = new GridBagConstraints();
						gbc_btnParcelFile.insets = new Insets(0, 0, 5, 0);
						gbc_btnParcelFile.gridx = 12;
						gbc_btnParcelFile.gridy = 11;
						contentPane.add(btnParcelFile, gbc_btnParcelFile);
						btnParcelFile.addActionListener(this);
		
				chckbxSpells = new JCheckBox("Spells File");
				GridBagConstraints gbc_chckbxSpells = new GridBagConstraints();
				gbc_chckbxSpells.anchor = GridBagConstraints.EAST;
				gbc_chckbxSpells.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxSpells.gridx = 0;
				gbc_chckbxSpells.gridy = 12;
				contentPane.add(chckbxSpells, gbc_chckbxSpells);
				chckbxSpells.addActionListener(this);
		
				textFieldSpellsFile = new JTextField();
				textFieldSpellsFile.setEditable(false);
				GridBagConstraints gbc_textFieldSpellsFile = new GridBagConstraints();
				gbc_textFieldSpellsFile.gridwidth = 11;
				gbc_textFieldSpellsFile.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldSpellsFile.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldSpellsFile.gridx = 1;
				gbc_textFieldSpellsFile.gridy = 12;
				contentPane.add(textFieldSpellsFile, gbc_textFieldSpellsFile);
				textFieldSpellsFile.setColumns(10);
		
				btnSpellsFile = new JButton("Select");
				btnSpellsFile.setEnabled(false);
				GridBagConstraints gbc_btnSpellsFile = new GridBagConstraints();
				gbc_btnSpellsFile.insets = new Insets(0, 0, 5, 0);
				gbc_btnSpellsFile.gridx = 12;
				gbc_btnSpellsFile.gridy = 12;
				contentPane.add(btnSpellsFile, gbc_btnSpellsFile);
				btnSpellsFile.addActionListener(this);
		
		lblRuntimeNotes = new JLabel("DEV NOTE: File locations must be in property file");
		GridBagConstraints gbc_lblRuntimeNotes = new GridBagConstraints();
		gbc_lblRuntimeNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblRuntimeNotes.gridx = 1;
		gbc_lblRuntimeNotes.gridy = 13;
		contentPane.add(lblRuntimeNotes, gbc_lblRuntimeNotes);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 13;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 16;
		contentPane.add(separator_1, gbc_separator_1);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 13;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 17;
		contentPane.add(scrollPane, gbc_scrollPane);

		textAreaLogOutput = new JTextArea();
		scrollPane.setViewportView(textAreaLogOutput);

		// Add Listeners
		btnBuild.addActionListener(this);
		chckbxAsDirectory.addActionListener(this);
		
	}

	/*
	 * For each action call method in AppScreenAction() class
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnBuild)) {
			AppScreenActions.actionBtnBuild(this, e);
		} else if (e.getSource().equals(btnModuleFolder)) {
			AppScreenActions.actionBtnModuleFolder(this, e);
		} else if (e.getSource().equals(btnParcelFile)) {
			AppScreenActions.actionBtnParcelFile(this, e);
		} else if (e.getSource().equals(btnEquipmentFile)) {
			AppScreenActions.actionBtnEquipmentFile(this, e);
		} else if (e.getSource().equals(btnSpellsFile)) {
			AppScreenActions.actionBtnSpellFile(this, e);
		} else if (e.getSource().equals(chckbxAsDirectory)) {
			AppScreenActions.actionChkAsDirectory(this, e);
		} else if (e.getSource().equals(chckbxParcels)) {
			AppScreenActions.actionChkParcelFile(this, e);
		} else if (e.getSource().equals(chckbxEquipment)) {
			AppScreenActions.actionChkEquipementFile(this, e);
		} else if (e.getSource().equals(chckbxSpells)) {
			AppScreenActions.actionChkSpellFile(this, e);
		} else if (e.getSource().equals(chckbxAsDirectory)) {
			AppScreenActions.actionChkAsDirectory(this, e);
		} 

	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextFieldModuleFolder() {
		return textFieldModuleFolder;
	}

	public JTextField getTextFieldPar5eFile() {
		return textFieldPar5eFile ;
	}
	
	public JTextField getTextFieldParcelFile() {
		return textFieldParcelFile;
	}

	public JTextField getTextFieldDefinitionFile() {
		return textFieldDefinitionFile;
	}
	
	public JCheckBox getChckbxSpells() {
		return chckbxSpells;
	}

	public JCheckBox getChckbxEquipment() {
		return chckbxEquipment;
	}

	public JCheckBox getChckbxParcels() {
		return chckbxParcels;
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

	public JTextField getTextFieldEquipmentFile() {
		return textFieldEquipmentFile;
	}

	public JTextField getTextFieldSpellsFile() {
		return textFieldSpellsFile;
	}

	public JButton getBtnEquipmentFile() {
		return btnEquipmentFile;
	}

	public JButton getBtnSpellsFile() {
		return btnSpellsFile;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTextArea getTextAreaLogOutput() {
		return textAreaLogOutput;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JCheckBox getChckbxAsDirectory() {
		return chckbxAsDirectory;
	}

	public JLabel getLblRuntimeNotes() {
		return lblRuntimeNotes;
	}

	public JLabel getLblThumbnail() {
		return lblThumbnail;
	}

	public JLabel getLblModuleName() {
		return lblModuleName;
	}
	
	public JTextField getTextFieldThumbnail() {
		return textFieldThumbnail;
	}

	public JButton getBtnThumbnail() {
		return btnThumbnail;
	}

}
