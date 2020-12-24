package com.beegrinder.sw5e.modulegenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppModuleBuild {
	public static void buildModule(AppScreen frame) throws Exception {
		// check that the module parent directory exists
		if ( ! validateModuleDirectory(frame.getTextFieldModuleFolder().getText())) {
			throw new Exception("Error. Module directory not found.");
		}
		
		if( frame.getChckbxAsDirectory().isSelected() ) {
			// "As Directory" removes a .mod file if present and puts files in module directory
			removeModFileIfExists(frame.getTextFieldModuleFolder().getText(), frame.getTextFieldModuleName().getText());
			createModWorkDirectory(frame.getTextFieldModuleFolder().getText(), frame.getTextFieldModuleName().getText());
			
		} else {
			// not "As Directory" so we will create a .mod file and remove a directory if present.
		}
	}
	
	private static void createModWorkDirectory(String modDir, String modName ) throws Exception {
		Path path = Path.of(modDir+"\\"+modName);
		if ( Files.exists( path )  && Files.isDirectory( path ) ) {
			ModuleGenerator.addLogEntry("Found module build directory " + modName);
		} else {
			ModuleGenerator.addLogEntry("Creating mod work directory: " + modName);
			try {
				Files.createDirectory(path);
			} catch (Exception e) {
				throw new Exception("Unable to create mod work directory: "+path.toString());
			}
		}
	}
	
	private static void removeModFileIfExists(String modDir, String modName ) {
		Path path = Path.of(modDir+"\\"+modName+".mod");
		if ( Files.exists(path) ) {
			try {
				ModuleGenerator.addLogEntry("Removing file "+path.toString());
				Files.delete(path);
			} catch (IOException e) {
				ModuleGenerator.addLogEntry("Error.  Unable to remove .mod file. "+ e.getMessage());
			}
		}
	}
	
	private static boolean validateModuleDirectory(String folderName ) {
		boolean retVal = false;
		Path path = Path.of(folderName);
		if ( Files.exists( path )  && Files.isDirectory( path ) ) {
			retVal = true;
	}
		
		
		return retVal;
	}
	
}
