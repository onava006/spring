package com.nava006.Model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name="datos")
public class Datos {
	
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
    
    public Datos() {
    }
    
    public Datos(String title, String description, String language, int pages) {
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

}
