package cst438backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CovidStatsRepository extends JpaRepository<CovidStats,Long> {	
	
	@Query(value = "select 1 as id, sum(Active) as Active,sum(Confirmed) as Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update from cases where Last_Update=(select max(Last_Update) from cases where Province_State = ?1) AND Province_State = ?1 GROUP BY Last_Update", nativeQuery = true)
	CovidStats getUSStateTotals(String state);
	
	@Query(value = "select max(Last_Update) from cases", nativeQuery = true)
	String getLastUpdateDate();
}
