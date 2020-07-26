package com.example.model;

import java.io.Serializable;

public class Ninja implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer gold; 
	String place;
	
	public Ninja() {}
	public Ninja(Integer gold) {
		this.gold = gold;
	}
	
	public Ninja(Integer gold, String place) {
		super();
		this.gold = gold;
		this.place = place;
	}
	public Integer getGold() {
		return gold;
	}
	public void setGold(Integer gold) {
		this.gold = gold;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	} 
	

}
