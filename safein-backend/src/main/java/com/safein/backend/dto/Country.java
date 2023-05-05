/**
 * 
 */
package com.safein.backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safein.backend.utilities.CountrySituation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "country_code", unique = true)
	private String countryCode;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "situation")
	private String situation;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Customers> customers;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<City> cities;

	/**
	 * Default constructor
	 *
	 */
	public Country() {
	}

	/**
	 * @param id
	 * @param countryCode
	 * @param countryName
	 * @param latitude
	 * @param longidude
	 * @param situation
	 * @param customers
	 * @param cities
	 */
	public Country(long id, String countryCode, String countryName, double latitude, double longidude,
			String situation, List<Customers> customers, List<City> cities) {
		super();
		this.id = id;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.latitude = latitude;
		this.longitude = longidude;
		this.situation = situation;
		this.customers = customers;
		this.cities = cities;
	}

	/**
	 * Sets the id
	 * 
	 * @param id (long)
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Sets the country code
	 * 
	 * @param country_code (String of 2 char) (ISO 3166-1 alpha-2)
	 */
	public void setCountryCode(String country_code) {
		this.countryCode = country_code;
	}

	/**
	 * Sets the county name
	 * 
	 * @param country_name (String)
	 */
	public void setCountryName(String country_name) {
		this.countryName = country_name;
	}

	/**
	 * Sets the status: On conflict, high crime, political instability
	 * 
	 * @param situation (enum CountrySituation)
	 */
	public void setSituation(String situation) {
		this.situation = situation;
	}

	/**
	 * Sets the references to the join many to one
	 * 
	 * @param customers (List<Customerss>)
	 */
	public void setCustomerss(List<Customers> customers) {
		this.customers = customers;
	}

	/**
	 * Sets the references to the join many to one
	 * 
	 * @param cities (List<City>)
	 */
	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	/**
	 * | Gets the internal Id
	 * 
	 * @return id (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * | Gets the country code
	 * 
	 * @return countryCode (String of 2 char) (ISO 3166-1 alpha-2)
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Gets the country name
	 * 
	 * @return countryName (String)
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Gets the country situation
	 * 
	 * @return situation (enum CountrySituation)
	 */
	public String getSituation() {
		return situation;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longidude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longidude the longidude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}

	@JsonIgnore
	public List<Customers> getCustomers() {
		return customers;
	}

	@JsonIgnore
	public List<City> getCities() {
		return cities;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName + ", latitude="
				+ latitude + ", longitude=" + longitude + ", situation=" + situation + ", customers=" + customers
				+ ", cities=" + cities + "]";
	}

}
