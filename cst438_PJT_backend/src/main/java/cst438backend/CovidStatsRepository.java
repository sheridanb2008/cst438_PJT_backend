package cst438backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CovidStatsRepository extends JpaRepository<CovidStats,Long> {	
	
    @Query(value = "select min(id) as id, sum(Active) as Active,sum(Confirmed) as " +
    "Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update from " + 
    "cases where Last_Update =?2 AND " + 
    "Province_State = ?1 GROUP BY Last_Update", nativeQuery = true)
    CovidStats getUSStateTotals(String state, String theDate);

    @Query(value = "select min(id) as id, sum(Active) as Active,sum(Confirmed) as " +
    "Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update from " + 
    "cases where Last_Update >= ?2 AND Last_Update <= ?3 AND " + 
    "Province_State = ?1 GROUP BY Last_Update", nativeQuery = true)
	List<CovidStats> getStateInRange(String state, String startDate, String endDate);
    
    @Query(value = "select min(id) as id, sum(Active) as Active,sum(Confirmed) as " +
    "Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update from " + 
    "cases where Last_Update =?2 AND " + 
    "Country_Region = ?1 GROUP BY Last_Update", nativeQuery = true)
    CovidStats getCountryTotals(String country, String theDate);
    
    @Query(value = "select min(id) as id, sum(Active) as Active,sum(Confirmed) as " +
    "Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update from " + 
    "cases where Last_Update >= ?2 AND Last_Update <= ?3 AND " + 
    "Country_Region = ?1 GROUP BY Last_Update", nativeQuery = true)
	List<CovidStats> getCountryInRange(String country, String startDate, String endDate);
	
	@Query(value = "select max(Last_Update) from cases", nativeQuery = true)
	String getLastUpdateDate();
}
