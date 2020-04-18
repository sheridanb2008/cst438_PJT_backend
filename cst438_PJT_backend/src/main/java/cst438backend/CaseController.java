package cst438backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Date;

@RestController
public class CaseController {
	
	CaseController() {
		System.out.println("Help!");
	}
	
	@Autowired 
	CovidStatsRepository statsRepository;
	
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
	
	@GetMapping("/covid/bydate/usstate/{state}")
    public ResponseEntity<CovidStats> getUSStateTotals(@PathVariable("state") String usState, 
                                                       @RequestParam(required = false,defaultValue = "") String theDate) {
        
        if(theDate.length() == 0) {
            // Search for the most recent.
            theDate = caseRepository.getLastUpdateDate();
        }
        
        CovidStats covidStats = statsRepository.getUSStateTotals(usState,theDate);
		if (covidStats == null) {
            CovidStats emptyStats = new CovidStats();

            emptyStats.lastUpdated = Date.valueOf(theDate);
            return new ResponseEntity<CovidStats>(emptyStats, HttpStatus.OK);
		}
		return new ResponseEntity<CovidStats>(covidStats, HttpStatus.OK);	
    }
    
    @GetMapping("/covid/daterange/usstate/{state}")
    public ResponseEntity<List<CovidStats>> getUStateTotalsInRange(@PathVariable("state") String usState, 
                                                       @RequestParam(required = true) String startDate,
                                                       @RequestParam(required = true) String endDate) {

        List<CovidStats> covidStats = statsRepository.getStateInRange(usState,startDate,endDate);
		
		return new ResponseEntity<List<CovidStats>>(covidStats, HttpStatus.OK);	
	}

	
	@GetMapping("/covid/bydate/country/{country}")
    public ResponseEntity<CovidStats> getConfirmed(@PathVariable("country") String country,
                                               @RequestParam(required = false,defaultValue = "") String theDate) {
        if(theDate.length() == 0) {
            // Search for the most recent.
            theDate = caseRepository.getLastUpdateDate();
        }
        
        CovidStats covidStats = statsRepository.getCountryTotals(country,theDate);
        if (covidStats == null) {
            CovidStats emptyStats = new CovidStats();

            emptyStats.lastUpdated = Date.valueOf(theDate);
            return new ResponseEntity<CovidStats>(emptyStats, HttpStatus.OK);
        }
        return new ResponseEntity<CovidStats>(covidStats, HttpStatus.OK);		
    }
    
    @GetMapping("/covid/daterange/country/{country}")
    public ResponseEntity<List<CovidStats>> getCountryTotalsInRange(@PathVariable("country") String country, 
                                                       @RequestParam(required = true) String startDate,
                                                       @RequestParam(required = true) String endDate) {

        List<CovidStats> covidStats = statsRepository.getCountryInRange(country,startDate,endDate);
		
		return new ResponseEntity<List<CovidStats>>(covidStats, HttpStatus.OK);	
	}
	
	@GetMapping("/covid/cases/lastupdate")
	public ResponseEntity<String> getLastUpdate() {
		String lastUpdate = caseRepository.getLastUpdateDate();
		String msg  = "{\"LastUpdate\": \""+ lastUpdate + 
	               "\"}" ;
		return new ResponseEntity<String>(msg, HttpStatus.OK);		
    }
    
    @GetMapping("/covid/countrylist")
    public ResponseEntity<List<String>> getCountryList() {

        List<String> countries = statsRepository.getUniqueCountries();
		
		return new ResponseEntity<List<String>>(countries, HttpStatus.OK);	
    }
    
    @GetMapping("/covid/usstatelist")
    public ResponseEntity<List<String>> getUSStateList() {

        List<String> states = statsRepository.getUniqueUSStates();
		
		return new ResponseEntity<List<String>>(states, HttpStatus.OK);	
	}
	
	
}