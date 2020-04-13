package cst438backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {
	
	CaseController() {
		System.out.println("Help!");
	}
	
	@Autowired
	CaseRepository caseRepository;
	
	@Autowired
	CountryStatsRepository countryStatsRepository;

	@GetMapping("/covid/cases/{state}")
	public ResponseEntity<List<Case>> get(@PathVariable("state") String state) {
		//Case case = caseRepository.findByState(state);
		List<Case> theCases = caseRepository.findAllByState(state);
		if (theCases == null) {
			return new ResponseEntity<List<Case> >( HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Case> >(theCases, HttpStatus.OK);		
	}
	
	@GetMapping("/covid/latest/{country}")
	public ResponseEntity<CountryStats> getCountryTotals(@PathVariable("country") String country) {
		CountryStats countryStats = countryStatsRepository.getCountryTotals(country);
		if (countryStats == null) {
			return new ResponseEntity<CountryStats>( HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CountryStats>(countryStats, HttpStatus.OK);	
	}
	
	@GetMapping("/covid/cases/confirmed/{country}")
	public ResponseEntity<String> getConfirmed(@PathVariable("country") String country) {
		//Case case = caseRepository.findByState(state);
		Long confirmedTotal = caseRepository.findConfirmedByCountry(country);
		String msg  = "{\"Confirmed\": \""+ confirmedTotal + 
	               "\"}" ;
		return new ResponseEntity<String>(msg, HttpStatus.OK);		
	}
	
	
}