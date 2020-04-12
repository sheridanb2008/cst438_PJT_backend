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
	
}
