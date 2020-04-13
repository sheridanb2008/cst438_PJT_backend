package cst438backend;
import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="cases")
@Access(value=AccessType.FIELD)
public class Case {
	
	@Id
	@GeneratedValue
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
	@Column(name="Province_State")
	String state;
	@Column(name="Admin2")
	String admin2;
	@Column(name="Last_Update")
	Date lastUpdated;
	@Column(name="FIPS")
	String fips;
	@Column(name="Combined_Key")
	String combinedKey;	
	@Column(name="lat")
	float latitude;
	@Column(name="lon")
	float longitude;
	
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

	public String getState() {
		return state;
	}

	public String getAdmin2() {
		return admin2;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getFips() {
		return fips;
	}

	public String getCombinedKey() {
		return combinedKey;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	/*
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

	public void setState(String state) {
		this.state = state;
	}

	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setFips(String fips) {
		this.fips = fips;
	}

	public void setCombinedKey(String combinedKey) {
		this.combinedKey = combinedKey;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
*/

}