package com.onava006.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.onava006.mvc.models.Country;

public interface CountryRepository extends CrudRepository<Country,Long>{
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.language l WHERE l.language = ?1")
	public List<String[]> findCountriesNames(String language);
	
	@Query("SELECT country.name, COUNT(city.name) FROM Country country JOIN country.city city GROUP BY country.name ORDER BY COUNT(city.name) DESC")
	public List<String[]> findNumberOfCities();
	
	@Query("SELECT city.name, city.population FROM Country country JOIN country.city city WHERE city.population >= 500000 "
			+ "AND country.name = ?1  ORDER BY city.population DESC")
	public  List<String[]> findPopulatedCities(String country);
	
	@Query("SELECT country.name, lang.language FROM Country country JOIN country.language lang  WHERE lang.percentage >= ?1")
	public List<String[]> findPopularLanguages(Double percentage);
	
	@Query("SELECT country.name FROM Country country WHERE country.population >= 500000 AND country.surface_area >= 501")
	public List<String> findBigCountries();
	
	@Query("SELECT country.name FROM Country country WHERE country.government_form = ?1 AND country.life_expectancy >= 75 AND country.surface_area >= 200")
	public List<String> findMonarchies(String gov);
	
	@Query("SELECT country.name, city.name, city.district, city.population FROM Country country JOIN country.city city WHERE country.name=?1 AND city.district =?2 AND city.population >= ?3")
	public List<String[]> findArgiescity(String country, String district, Integer population);
	
	@Query("SELECT country.region, COUNT(country.name) FROM Country country GROUP BY country.region ORDER BY COUNT(country.name) DESC")
	public List<String[]> orderCountriesByRegion();
	
}
