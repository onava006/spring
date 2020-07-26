package com.onava006.mvc.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onava006.mvc.repositories.*;

@Service
public class ApiService {
	@Autowired
	CountryRepository countryRepo;

	public List<String[]> getAllSlovenians(String language){
		return countryRepo.findCountriesNames(language);
	}
	public List<String[]> countCities(){
		return countryRepo.findNumberOfCities();
	}

	public List<String[]> findPopulatedCities(String country){
		return countryRepo.findPopulatedCities(country);
	}
	public List<String[]> findPopularLanguages(Double perc) {
		
		return countryRepo.findPopularLanguages(perc);
	}
	public List<String> findBigPopulatedCountries() {
		// TODO Auto-generated method stub
		return countryRepo.findBigCountries();
	}
	public List<String> findMonarchies(String goverment) {
		// TODO Auto-generated method stub
		return countryRepo.findMonarchies(goverment);
	}
	public List<String[]> findArgDistrict(String country, String district, Integer population) {
		return countryRepo.findArgiescity(country,district, population);
	}
	public List<String[]> orderCountriesByRegion() {
		return countryRepo.orderCountriesByRegion();
	}



}
