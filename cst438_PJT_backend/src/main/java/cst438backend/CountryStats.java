package cst438backend;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="cases")
@Access(value=AccessType.FIELD)

public class CountryStats {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	public long getId() {
		return id;
	}

	public int getActive() {
		return active;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public int getRecovered() {
		return recovered;
	}

	public int getDeaths() {
		return deaths;
	}

	public String getCountry() {
		return country;
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

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name="Active")
	int active = 0;
	@Column(name="Confirmed")
	int confirmed = 0;
	@Column(name="Recovered")
	int recovered = 0;
	@Column(name="Deaths")
	int deaths = 0;
	@Column(name="Country_Region")
	String country;

	@Column(name="Last_Update")
	Date lastUpdated;

	
	
}
