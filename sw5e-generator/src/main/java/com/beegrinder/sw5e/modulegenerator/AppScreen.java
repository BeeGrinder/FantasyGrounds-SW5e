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
	private JTextField textFieldModuleName;
	private JTextField textFieldCategory;
	private JTextField textFieldAuthor;
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
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblRuntimeNotes;
	private JLabel lblThumbnail;
	private JTextField textFieldThumbnail;
	private JButton btnThumbnail;

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
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 1.0, Double.MIN_VALUE };
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

		JLabel lblModuleFolder = new JLabel("Module Folder");
		GridBagConstraints gbc_lblModuleFolder = new GridBagConstraints();
		gbc_lblModuleFolder.anchor = GridBagConstraints.EAST;
		gbc_lblModuleFolder.insets = new Insets(0, 0, 5, 5);
		gbc_lblModuleFolder.gridx = 0;
		gbc_lblModuleFolder.gridy = 4;
		contentPane.add(lblModuleFolder, gbc_lblModuleFolder);

		textFieldModuleFolder = new JTextField();
		textFieldModuleFolder.setEditable(false);
		GridBagConstraints gbc_textFieldModuleFolder = new GridBagConstraints();
		gbc_textFieldModuleFolder.gridwidth = 11;
		gbc_textFieldModuleFolder.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldModuleFolder.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldModuleFolder.gridx = 1;
		gbc_textFieldModuleFolder.gridy = 4;
		contentPane.add(textFieldModuleFolder, gbc_textFieldModuleFolder);
		textFieldModuleFolder.setColumns(10);

		btnModuleFolder = new JButton("Select");
		btnModuleFolder.setEnabled(false);
		GridBagConstraints gbc_btnModuleFolder = new GridBagConstraints();
		gbc_btnModuleFolder.insets = new Insets(0, 0, 5, 0);
		gbc_btnModuleFolder.gridx = 12;
		gbc_btnModuleFolder.gridy = 4;
		contentPane.add(btnModuleFolder, gbc_btnModuleFolder);
		
		lblThumbnail = new JLabel("Thumbnail");
		GridBagConstraints gbc_lblThumbnail = new GridBagConstraints();
		gbc_lblThumbnail.anchor = GridBagConstraints.EAST;
		gbc_lblThumbnail.insets = new Insets(0, 0, 5, 5);
		gbc_lblThumbnail.gridx = 0;
		gbc_lblThumbnail.gridy = 5;
		contentPane.add(lblThumbnail, gbc_lblThumbnail);
		
		textFieldThumbnail = new JTextField();
		textFieldThumbnail.setEditable(false);
		GridBagConstraints gbc_textFieldThumbnail = new GridBagConstraints();
		gbc_textFieldThumbnail.gridwidth = 11;
		gbc_textFieldThumbnail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldThumbnail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldThumbnail.gridx = 1;
		gbc_textFieldThumbnail.gridy = 5;
		contentPane.add(textFieldThumbnail, gbc_textFieldThumbnail);
		textFieldThumbnail.setColumns(10);
		
		btnThumbnail = new JButton("Select");
		btnThumbnail.setEnabled(false);
		GridBagConstraints gbc_btnThumbnail = new GridBagConstraints();
		gbc_btnThumbnail.insets = new Insets(0, 0, 5, 0);
		gbc_btnThumbnail.gridx = 12;
		gbc_btnThumbnail.gridy = 5;
		contentPane.add(btnThumbnail, gbc_btnThumbnail);

		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.gridwidth = 13;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 6;
		contentPane.add(separator, gbc_separator);

		chckbxParcels = new JCheckBox("Parcel File");
		chckbxParcels.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_chckbxParcels = new GridBagConstraints();
		gbc_chckbxParcels.anchor = GridBagConstraints.EAST;
		gbc_chckbxParcels.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxParcels.gridx = 0;
		gbc_chckbxParcels.gridy = 7;
		contentPane.add(chckbxParcels, gbc_chckbxParcels);

		textFieldParcelFile = new JTextField();
		textFieldParcelFile.setEditable(false);
		GridBagConstraints gbc_textFieldParcelFile = new GridBagConstraints();
		gbc_textFieldParcelFile.gridwidth = 11;
		gbc_textFieldParcelFile.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldParcelFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldParcelFile.gridx = 1;
		gbc_textFieldParcelFile.gridy = 7;
		contentPane.add(textFieldParcelFile, gbc_textFieldParcelFile);
		textFieldParcelFile.setColumns(10);

		btnParcelFile = new JButton("Select");
		btnParcelFile.setEnabled(false);
		GridBagConstraints gbc_btnParcelFile = new GridBagConstraints();
		gbc_btnParcelFile.insets = new Insets(0, 0, 5, 0);
		gbc_btnParcelFile.gridx = 12;
		gbc_btnParcelFile.gridy = 7;
		contentPane.add(btnParcelFile, gbc_btnParcelFile);
		
				chckbxEquipment = new JCheckBox("Equipment File");
				GridBagConstraints gbc_chckbxEquipment = new GridBagConstraints();
				gbc_chckbxEquipment.anchor = GridBagConstraints.EAST;
				gbc_chckbxEquipment.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxEquipment.gridx = 0;
				gbc_chckbxEquipment.gridy = 8;
				contentPane.add(chckbxEquipment, gbc_chckbxEquipment);
				chckbxEquipment.addActionListener(this);
		
				textFieldEquipmentFile = new JTextField();
				textFieldEquipmentFile.setEditable(false);
				GridBagConstraints gbc_textFieldEquipmentFile = new GridBagConstraints();
				gbc_textFieldEquipmentFile.gridwidth = 11;
				gbc_textFieldEquipmentFile.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldEquipmentFile.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldEquipmentFile.gridx = 1;
				gbc_textFieldEquipmentFile.gridy = 8;
				contentPane.add(textFieldEquipmentFile, gbc_textFieldEquipmentFile);
				textFieldEquipmentFile.setColumns(10);
		
				btnEquipmentFile = new JButton("Select");
				btnEquipmentFile.setEnabled(false);
				GridBagConstraints gbc_btnEquipmentFile = new GridBagConstraints();
				gbc_btnEquipmentFile.insets = new Insets(0, 0, 5, 0);
				gbc_btnEquipmentFile.gridx = 12;
				gbc_btnEquipmentFile.gridy = 8;
				contentPane.add(btnEquipmentFile, gbc_btnEquipmentFile);
				btnEquipmentFile.addActionListener(this);
		
				chckbxSpells = new JCheckBox("Spells File");
				GridBagConstraints gbc_chckbxSpells = new GridBagConstraints();
				gbc_chckbxSpells.anchor = GridBagConstraints.EAST;
				gbc_chckbxSpells.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxSpells.gridx = 0;
				gbc_chckbxSpells.gridy = 9;
				contentPane.add(chckbxSpells, gbc_chckbxSpells);
				chckbxSpells.addActionListener(this);
		
				textFieldSpellsFile = new JTextField();
				textFieldSpellsFile.setEditable(false);
				GridBagConstraints gbc_textFieldSpellsFile = new GridBagConstraints();
				gbc_textFieldSpellsFile.gridwidth = 11;
				gbc_textFieldSpellsFile.insets = new Insets(0, 0, 5, 5);
				gbc_textFieldSpellsFile.fill = GridBagConstraints.HORIZONTAL;
				gbc_textFieldSpellsFile.gridx = 1;
				gbc_textFieldSpellsFile.gridy = 9;
				contentPane.add(textFieldSpellsFile, gbc_textFieldSpellsFile);
				textFieldSpellsFile.setColumns(10);
		
				btnSpellsFile = new JButton("Select");
				btnSpellsFile.setEnabled(false);
				GridBagConstraints gbc_btnSpellsFile = new GridBagConstraints();
				gbc_btnSpellsFile.insets = new Insets(0, 0, 5, 0);
				gbc_btnSpellsFile.gridx = 12;
				gbc_btnSpellsFile.gridy = 9;
				contentPane.add(btnSpellsFile, gbc_btnSpellsFile);
				btnSpellsFile.addActionListener(this);
		
		lblRuntimeNotes = new JLabel("DEV NOTE: File locations must be in property file");
		GridBagConstraints gbc_lblRuntimeNotes = new GridBagConstraints();
		gbc_lblRuntimeNotes.insets = new Insets(0, 0, 5, 5);
		gbc_lblRuntimeNotes.gridx = 1;
		gbc_lblRuntimeNotes.gridy = 10;
		contentPane.add(lblRuntimeNotes, gbc_lblRuntimeNotes);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator_1.gridwidth = 13;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 15;
		contentPane.add(separator_1, gbc_separator_1);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 13;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 16;
		contentPane.add(scrollPane, gbc_scrollPane);

		textAreaLogOutput = new JTextArea();
		scrollPane.setViewportView(textAreaLogOutput);

		// Add Listeners
		btnBuild.addActionListener(this);
		btnModuleFolder.addActionListener(this);
		btnParcelFile.addActionListener(this);
		chckbxAsDirectory.addActionListener(this);
		chckbxParcels.addActionListener(this);
		textFieldModuleName.addActionListener(this);
		textFieldCategory.addActionListener(this);
		textFieldAuthor.addActionListener(this);
		
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
		} else if (e.getSource().equals(textFieldModuleName)) {
			AppScreenActions.actionTxtModuleName(this, e);
		} else if (e.getSource().equals(textFieldCategory)) {
			AppScreenActions.actionTxtCategory(this, e);
		} else if (e.getSource().equals(textFieldAuthor)) {
			AppScreenActions.actionTxtAuthor(this, e);
		}

	}

	public JPanel getContentPane() {
		return contentPane;
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

	public JTextField getTextFieldThumbnail() {
		return textFieldThumbnail;
	}

	public JButton getBtnThumbnail() {
		return btnThumbnail;
	}

}
