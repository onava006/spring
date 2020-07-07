package com.onava006.model;

public class CodeProcessor {
	
	private String password = "Bushido";
	boolean success; 
	private String errorCode = "You Must Train Harder!" ;
	private static String jumpErrorCode = "Saltarse el camino del samurai también está mal. Tramposo";
	
	public CodeProcessor(String pass) {
		this.success = checkPassword(pass);		
	}	
	
	public CodeProcessor(boolean bool) {
		this.success = bool;
	}
	
	private boolean checkPassword(String pass) {
		if(pass.equals(password)) {
			success = true;
		}
		else {
			success = false;
		}
		return success; 	
	}
	
	public boolean getStatusPass() {
		return this.success;
	}
	public String getErrorcode() {
		return this.errorCode; 
	}
	static public String getJumpErrorCode() {
		return jumpErrorCode;
	}
}
