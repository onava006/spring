package com.onava006.learning.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Languages")
public class Language implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	public Long getId() {
		return id;
	}
	public Language() {}
	public Language(@Size(min = 2, max = 20) String name, @Size(min = 2, max = 20) String creator,
			@Size(min = 2, max = 20) String currentVersion) {
		this.name = name;
		this.creator = creator;
		this.currentVersion = currentVersion;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Size(min= 1, max = 20)
	private String name;
	@Size(min= 2, max = 20)
	private String creator;
	
	@Size(min= 2, max = 20)
	private String currentVersion;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date updatedAt;
	
	 @PrePersist
	 private void onCreate() {
		 this.createdAt = new Date();
	 }
	 @PreUpdate
	 private void onUpdate() {
		 this.updatedAt = new Date();
	 }
	 
}























