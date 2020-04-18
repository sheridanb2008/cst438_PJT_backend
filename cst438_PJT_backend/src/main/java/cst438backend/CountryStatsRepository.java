package cst438backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CountryStatsRepository extends JpaRepository<CountryStats,Long> {	

	@Query(value = "select 1 as ID, sum(Active) as Active,sum(Confirmed) as Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update,Country_Region from cases where Last_Update=(select max(Last_Update) from cases where Country_Region = ?1) AND Country_Region = ?1 GROUP BY Last_Update", nativeQuery = true)
	CountryStats getCountryTotals(String country);
	
	@Query(value = "select 1 as ID, sum(Active) as Active,sum(Confirmed) as Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update,Country_Region,Province_State from cases where Last_Update=(select max(Last_Update) from cases where Province_State = ?1) AND Province_State = ?1 GROUP BY Last_Update,Country_Region,Province_State", nativeQuery = true)
	CountryStats getUSStateTotals(String state);
}
