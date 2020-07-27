package com.nava006.Model;


import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="boocs")
public class Books implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Size(min = 5, max = 200)
    private String title;
    @Size(min = 5, max = 200)
    private String description;
    @Size(min = 3, max = 40)
    private String language;
    @Min(100)
    private Integer pages;
    // Esto no permitirá que el campo createdAt sea modificado después de su creación.
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Books() {
    }
    
    public Books(String title, String description, String language, int pages) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.pages = pages;
    }
    public Books(Long id, String title, String description, String language, int pages) {
    	this.id = id;
    	this.title = title;
        this.description = description;
        this.language = language;
        this.pages = pages;
    }
    
    @PrePersist
    private void onCreate() {
    	this.createdAt = new Date();
    }
	@PreUpdate
	private void onUpdate(){
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
