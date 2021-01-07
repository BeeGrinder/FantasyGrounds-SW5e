package com.beegrinder.sw5e.objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")

@XmlAccessorType(XmlAccessType.FIELD)

public class Definition {

	@XmlAttribute(name = "version")
	@XmlID
	private String version = "3.3";
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String author; 

	@XmlElement
	private String ruleset;

	public Definition(String name, String author, String ruleset) {
		super();
		this.name = name;
		this.author = author;
		this.ruleset = ruleset;
	}
	
}
