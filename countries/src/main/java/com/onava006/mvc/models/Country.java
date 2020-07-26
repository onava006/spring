package com.onava006.mvc.models;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String code;
	String name;
	Continents continent;
	String region;
	Double surface_area;
	Short indep_year;
	Integer population;
	Double life_expectancy;
	Double gnp;
	Double gnp_old;
	String local_name;
	String government_form;
	String head_of_state;
	Integer capital;
	String code2;
	@OneToMany(targetEntity=Language.class, mappedBy="country", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Language> language;
	@OneToMany(targetEntity=City.class, mappedBy="country", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	public List<City> city;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Continents getContinent() {
		return continent;
	}
	public void setContinent(Continents continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Double getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(Double surface_area) {
		this.surface_area = surface_area;
	}
	public Short getIndep_year() {
		return indep_year;
	}
	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Double getLife_expectancy() {
		return life_expectancy;
	}
	public void setLife_expectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	public Double getGnp() {
		return gnp;
	}
	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}
	public Double getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(Double gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getGoverment_form() {
		return government_form;
	}
	public void setGoverment_form(String goverment_form) {
		this.government_form = goverment_form;
	}
	public String getHead_of_state() {
		return head_of_state;
	}
	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public List<Language> getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language.add(language);
	}
	public List<City> getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city.add(city);
	}
	public Long getId() {
		return id;
	}
	public Country() {}
}
