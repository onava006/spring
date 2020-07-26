package com.example.model;

import java.io.Serializable;

public class CountStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer count; 
	
	public CountStatus() {
		resetCounter();
	}
	
	public CountStatus(Integer previousStatus) {
		this.count = previousStatus;
	}
	
	public void resetCounter() {
		this.count = 0;
	}
	
	public void increaseCounter() {
		this.count++;
	}
	public void increaseCounter(Integer twice) {
		this.count += twice;
	}
	
	public Integer getCount() {
		return this.count;
	}

}
