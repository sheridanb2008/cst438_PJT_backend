package cst438backend;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="cases")
//@Access(value=AccessType.FIELD)

public class CountryStats {

	

	public CountryStats() {
		super();
	}

	public CountryStats(long id, int active, int confirmed, int recovered, int deaths, String country,
			Date lastUpdated) {
		super();
		this.id = id;
		this.active = active;
		this.confirmed = confirmed;
		this.recovered = recovered;
		this.deaths = deaths;
		this.country = country;
		this.lastUpdated = lastUpdated;
	}

	@Id
//	@GeneratedValue
	@Column(name="ID")
	private long id;
	
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
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	

	
}
