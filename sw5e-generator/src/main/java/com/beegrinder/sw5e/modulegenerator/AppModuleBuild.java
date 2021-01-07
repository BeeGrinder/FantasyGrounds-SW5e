package com.beegrinder.sw5e.modulegenerator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AppModuleBuild {

	public static void buildModule(AppScreen frame) throws Exception {
		Path modulePath = null;
		// check that the module parent directory exists
		if (!validateModuleDirectory(frame.getTextFieldModuleFolder().getText())) {
			throw new Exception("Error. Module directory not found.");
		}

		if (frame.getChckbxAsDirectory().isSelected()) {
			// Prepare for directory based module
			try {
			removeModFileIfExists(frame.getTextFieldModuleFolder().getText(), frame.getTextFieldModuleName().getText());
			modulePath = createModWorkDirectory(frame.getTextFieldModuleFolder().getText(),
					frame.getTextFieldModuleName().getText());
			} catch ( Exception e ) {
				ModuleGenerator.addLogEntry("Error preparing to deploy module as directory. "+ e.getMessage() );
			}
			// copy thumbnail
			try {
			Files.copy(Path.of(frame.getTextFieldThumbnail().getText()),
					Path.of(modulePath.toString() + ModuleGenerator.delim + "thumbnail.png"), StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error copying thumbnail to module. "+ e.getMessage() );
			}
			// Create definition.xml
			try {
				createDefinitionFile(modulePath, frame);
			} catch (Exception e ) {
				ModuleGenerator.addLogEntry("Error creating definition.xml file. "+ e.getMessage() );
			}
			// TODO: create client.xml
			try {
				createMainModule(modulePath, frame);
			} catch (Exception e) {
				ModuleGenerator.addLogEntry("Error creating main module file. "+ e.getMessage() );
			}
			
		} else {
			// not "As Directory" so we will create a .mod file and remove a directory if
			// present.
		}
	}

	private static void createMainModule(Path modulePath, AppScreen frame) throws ParserConfigurationException, TransformerException {
		//create root
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		Element rootElement = doc.createElement("root");	
		doc.appendChild(rootElement);
		rootElement.setAttribute("version", AppConstants.DEFINITION_MIN_VERSION);
		rootElement.setAttribute("dataversion", dateFormat.format(new Date()));
		// now add sections
		if( frame.getChckbxEquipment().isSelected() ) {
			//create <item> element
			try {
			Element itemElement = AppModuleItemBuilder.buildItemElement(doc);
			rootElement.appendChild(itemElement);
			} catch (Exception e ) {
				ModuleGenerator.addLogEntry("Error.  Unable to create <item> element. " + e.getMessage());
			}
		}
		
		
		//finish and write xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(modulePath.toString() + ModuleGenerator.delim + "client.xml"));
		transformer.transform(source, result);
		
	}
	
	
	private static void createDefinitionFile(Path modulePath, AppScreen frame)
			throws TransformerException, ParserConfigurationException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		// root element
		Element rootElement = doc.createElement("root");
		doc.appendChild(rootElement);
		rootElement.setAttribute("version", AppConstants.DEFINITION_MIN_VERSION);
		rootElement.setAttribute("dataversion", dateFormat.format(new Date()));
		Element nameElement = doc.createElement("name");
		nameElement.setTextContent(frame.getTextFieldModuleName().getText());
		rootElement.appendChild(nameElement);
		Element categoryElement = doc.createElement("ruleset");
		categoryElement.setTextContent(frame.getTextFieldCategory().getText());
		rootElement.appendChild(categoryElement);
		Element authorElement = doc.createElement("author");
		authorElement.setTextContent(frame.getTextFieldAuthor().getText());
		rootElement.appendChild(authorElement);
		Element rulesetElement = doc.createElement("ruleset");
		rulesetElement.setTextContent(AppConstants.DEFINITION_RULESET);
		rootElement.appendChild(rulesetElement);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(modulePath.toString() + ModuleGenerator.delim + "definition.xml"));
		transformer.transform(source, result);
	}

	private static Path createModWorkDirectory(String modDir, String modName) throws Exception {
		Path path = Path.of(modDir + ModuleGenerator.delim + modName);
		if (Files.exists(path) && Files.isDirectory(path)) {
			ModuleGenerator.addLogEntry("Found module build directory " + modName);
		} else {
			ModuleGenerator.addLogEntry("Creating mod work directory: " + modName);
			try {
				path = Files.createDirectory(path);
			} catch (Exception e) {
				throw new Exception("Unable to create mod work directory: " + path.toString());
			}
		}
		return path;
	}

	private static void removeModFileIfExists(String modDir, String modName) {
		Path path = Path.of(modDir + ModuleGenerator.delim + modName + ".mod");
		if (Files.exists(path)) {
			try {
				ModuleGenerator.addLogEntry("Removing file " + path.toString());
				Files.delete(path);
			} catch (IOException e) {
				ModuleGenerator.addLogEntry("Error.  Unable to remove .mod file. " + e.getMessage());
			}
		}
	}

	private static boolean validateModuleDirectory(String folderName) {
		boolean retVal = false;
		Path path = Path.of(folderName);
		if (Files.exists(path) && Files.isDirectory(path)) {
			retVal = true;
		}

		return retVal;
	}

}
