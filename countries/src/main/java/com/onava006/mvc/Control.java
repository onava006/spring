package com.onava006.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.onava006.mvc.models.services.*;

@Controller
public class Control {

	@Autowired
	ApiService serviceApi;
	
	@Autowired
	CountryService countryService;
	@Autowired
	CityService cityservice;
	@Autowired
	LanguageService languageService;

	@RequestMapping("/")
	public String gettingSomething(Model model) {
		
		List<String[]> slovs = serviceApi.getAllSlovenians("slovene");
		model.addAttribute("queryone", slovs);
		
		List<String[]> cityCountr = serviceApi.countCities();
		model.addAttribute("querytwo", cityCountr);
		
		List<String[]> populatedCities = serviceApi.findPopulatedCities("Mexico");
		model.addAttribute("querythree", populatedCities);
		
		List<String[]> popularLangs = serviceApi.findPopularLanguages(89.0);
		model.addAttribute("queryfour", popularLangs);
		
		List<String> bigCountries = serviceApi.findBigPopulatedCountries();
		model.addAttribute("queryfive", bigCountries);
		
		List<String> monarchies = serviceApi.findMonarchies("Constitutional Monarchy");
		model.addAttribute("querysix", monarchies);
		
		List<String[]> argCapital = serviceApi.findArgDistrict("Argentina", "Distrito Federal", 500000);
		model.addAttribute("queryseven", argCapital);
		
		List<String[]> regionsCountries = serviceApi.orderCountriesByRegion();
		model.addAttribute("queryocho", regionsCountries);
		return "index.jsp";		
		
	}
	
	


}
