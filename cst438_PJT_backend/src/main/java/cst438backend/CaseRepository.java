package cst438backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CaseRepository extends JpaRepository<Case,Long> {	
	
	@Query(value="SELECT t FROM Case t WHERE t.state = ?1")
	List<Case> findAllByState(String state);
	
	@Query(value="SELECT t FROM Case t WHERE t.country = ?1")
	List<Case> findAllByCountry(String country);
	
	@Query(value = "SELECT SUM(confirmed) FROM cases WHERE Country_Region=?1", nativeQuery = true)
	Long findConfirmedByCountry(String country);

	@Query(value = "select 1 as ID, sum(Active) as Active,sum(Confirmed) as Confirmed,sum(Deaths) as Deaths,sum(Recovered) as Recovered,Last_Update,Country_Region from cases where Last_Update=(select max(Last_Update) from cases where Country_Region = ?1) AND Country_Region = ?1 GROUP BY Last_Update", nativeQuery = true)
	CountryStats getCountryTotals(String country);

	@Query(value = "select max(Last_Update) from cases", nativeQuery = true)
	String getLastUpdateDate();
}
