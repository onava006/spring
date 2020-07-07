package com.example.language;

import java.io.Serializable;

public class Formularium implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String name; 
	String location; 
	String Language; 
	String comment = "";
	boolean javaFan;

	public Formularium() {}

	public Formularium(String name, String location, String language, String comment) {
		super();
		this.name = checkName(name);
		this.location = location;
		this.Language = language;
		this.comment =  checkComment(comment);
		this.javaFan = javaFanCheck(language);
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getLanguage() {
		return Language;
	}
	public String getComment() {
		return comment;
	}

	private boolean javaFanCheck(String language) {
		if (language.equalsIgnoreCase("java")) {
			return true;
		} else {
			return false; 
		}
	}

	private String checkComment(String comment) {
		if(comment.isBlank()) {
			comment = "5mentarios";
			return comment;			
		} else {
			return comment;
		}
	}

	private String checkName(String name) {
		if(name.isBlank()) {
			name = "no especificado";
			return name;			
		} else {
			return name;
		}
	}

}
