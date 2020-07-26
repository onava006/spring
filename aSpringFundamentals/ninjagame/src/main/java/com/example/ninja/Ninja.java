package com.example.ninja;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Ninja implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer gold = 0; 
	Integer toSet;
	String place;
	ArrayList<String> registry = new ArrayList<String>();	
	HashMap<String,Integer[]> locationPatterns = new HashMap<String,Integer[]>();	
	
	public Ninja() {}
	public Ninja(Integer gold) {
		this.gold = gold;
		
	}	
	public Integer getGold() {
		return gold;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	} 
	public void setGold(String place) {
		Integer goldToAdd;
		setPlacesRatio();
		
		if(place.equals("casino")){
			goldToAdd = casinoMechanics(place);
		} else {
			goldToAdd = otherMechanics(place);
		}
			
		addDateToList(adDate(place));
		this.gold =  this.gold + goldToAdd;
	}
	
	private void setPlacesRatio() {
		
		String place1 = "farm";
		Integer[] farmPattern = new Integer[] {10,20,1};	
		String place2 = "cave";
		Integer[] cavePattern = new Integer[] {5,10,1};	
		String place3 = "house";
		Integer[] housePattern =  new Integer[] {2,5,1};	
		String place4 = "casino";
		Integer[] casinoPattern = new Integer[] {0,50,0};
		String place5 = "place";
		Integer[] test = new Integer[] {25,50,1};
		
		this.locationPatterns.put(place1, farmPattern);
		this.locationPatterns.put(place2, cavePattern);
		this.locationPatterns.put(place3, housePattern);
		this.locationPatterns.put(place4, casinoPattern);
		
		this.locationPatterns.put(place5, test);
	}
	
	private Integer casinoMechanics(String place){
	
		Integer[] ranges = locationPatterns.get(place);	
		Random r = new Random();
		toSet = r.nextInt((ranges[1] - ranges[0]) + 1) +ranges[0];
		
		if(Math.abs((toSet - ranges[0]))* 0.5 > Math.abs(toSet - ranges[1])) {
			ranges[2] = 1;
		} else {
			ranges[2] = -1;
		}
		
		return toSet * ranges[2];
	}
	private Integer otherMechanics(String place) {
		
		Integer[] ranges = locationPatterns.get(place);		
		Random r = new Random();
		toSet = r.nextInt((ranges[1] - ranges[0]) + 1) +ranges[0];		
		return toSet * ranges[2];
		}
	
	private void addDateToList(String e) {
		registry.add(e);
	}
	
	public ArrayList<String> getRegistry(){
		return this.registry;
	}
	
	private String adDate(String place) {
		StringBuffer sb = new StringBuffer();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm:ss a");  
		LocalDateTime now = LocalDateTime.now(); 
		int lastparameter = locationPatterns.get(place)[2];
		
		sb.append("you entered a ");
		sb.append(place + " and ");
		if(lastparameter < 0) {
			sb.append("lost ");
		} else {
			sb.append("earned ");
		}
		sb.append(this.getToSet() + " gold ");
		sb.append(dtf.format(now));
		sb.append(" ");
		
		String today = sb.toString();
		return today;  
	}
	
	public void setRegistry(ArrayList<String> previousList) {
		for(String event : previousList) {
			registry.add(event);
		}
		
	
	}	
	public int getToSet() {
		return this.toSet;
	}

}
