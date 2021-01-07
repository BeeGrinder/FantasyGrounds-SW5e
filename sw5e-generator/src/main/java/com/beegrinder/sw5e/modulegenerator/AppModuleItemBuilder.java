package com.beegrinder.sw5e.modulegenerator;

import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.beegrinder.sw5e.objects.Equipment;

public class AppModuleItemBuilder {

	public static final String COST_SUFFIX = " cr";
	
	public static Element buildItemElement(Document doc) throws ParserConfigurationException {

		Element itemElement = doc.createElement("item");
		if ( ( ModuleGenerator.equipmentList != null ) && ( ! ModuleGenerator.equipmentList.isEmpty() ) ) {
			for( int i = 0; i < ModuleGenerator.equipmentList.size(); i++ ) {
				Equipment e =  ModuleGenerator.equipmentList.get(i);
				Element idElement = doc.createElement("id-" + (i+1));
				/*
				 * now, parse equipment object
				 */
				//** ac
				Element acElement = doc.createElement("ac");
				acElement.setAttribute("type", "number");
				if( e.getAc() == null ) {
					acElement.setTextContent("0");;
				} else {
					acElement.setTextContent(e.getAc());
				}
				idElement.appendChild(acElement);
				//** bonus
				Element bonusElement = doc.createElement("bonus");
				bonusElement.setAttribute("type", "number");
				bonusElement.setTextContent("0");
				idElement.appendChild(bonusElement);
				//**cost
				Element costElement = doc.createElement("cost");
				costElement.setAttribute("type", "string");
				costElement.setTextContent(e.getCost()+COST_SUFFIX);
				idElement.appendChild(costElement);
				//**name
				Element nameElement = doc.createElement("name");
				nameElement.setAttribute("type", "string");
				nameElement.setTextContent(e.getName());
				idElement.appendChild(nameElement);
				
				/*
				 * Done parsing equipment object. Add this id-xxxx to the <item> element
				 */
				itemElement.appendChild(idElement);
			}
		}
		return itemElement;
	}
	
}
