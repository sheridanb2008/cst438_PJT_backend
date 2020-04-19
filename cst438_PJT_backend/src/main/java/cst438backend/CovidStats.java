package cst438backend;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cases")
@Access(value=AccessType.FIELD)
public class CovidStats {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="Active")
	int active = 0;
	@Column(name="Confirmed")
	int confirmed = 0;
	@Column(name="Deaths")
	int deaths = 0;
	public long getId() {
		return id;
	}
	
	public CovidStats(long id, int active, int confirmed, int deaths, int recovered, Date lastUpdated) {
		this.id = id;
		this.active = active;
		this.confirmed = confirmed;
		this.recovered = recovered;
		this.deaths = deaths;
		this.lastUpdated = lastUpdated;
		
	}


	public CovidStats() {
		// TODO Auto-generated constructor stub
	}

	public int getActive() {
		return active;
	}


	public int getConfirmed() {
		return confirmed;
	}


	public int getDeaths() {
		return deaths;
	}


	public int getRecovered() {
		return recovered;
	}


	public Date getLastUpdated() {
		return lastUpdated;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setActive(int active) {
		this.active = active;
	}


	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}


	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}


	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}


	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


	@Column(name="Recovered")
	int recovered = 0;

	
	@Column(name="Last_Update")
	Date lastUpdated;
		
}
