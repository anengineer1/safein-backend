/**
 * 
 */
package com.safein.backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.safein.backend.utilities.CountrySituation;

import org.springframework.data.geo.Point;

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
	private long id;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "location")
	private Point location;

	@Column(name = "situation")
	private CountrySituation situation;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Client> clients;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<City> cities;

	/**
	 * Default constructor
	 *
	 */
	public Country() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param country_code
	 * @param country_name
	 * @param location
	 * @param situation
	 * @param clients
	 * @param cities
	 */
	public Country(String country_code, String country_name, Point location, CountrySituation situation,
			List<Client> clients, List<City> cities) {
		this.countryCode = country_code;
		this.countryName = country_name;
		this.location = location;
		this.situation = situation;
		this.clients = clients;
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
	 * Sets the location
	 * 
	 * @param location (Point (org.springframework.data.geo.Point)) (latitude,
	 *                 longitude)
	 */
	public void setLocation(Point location) {
		this.location = location;
	}

	/**
	 * Sets the status: On conflict, high crime, political instability
	 * 
	 * @param situation (enum CountrySituation)
	 */
	public void setSituation(CountrySituation situation) {
		this.situation = situation;
	}

	/**
	 * Sets the references to the join many to one
	 * 
	 * @param clients (List<Clients>)
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
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
	 * |
	 * Gets the internal Id
	 * 
	 * @return id (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * |
	 * Gets the country code
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
	 * Gets the location
	 * 
	 * @return location (Point) (Latitude, Longitude)
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Gets the country situation
	 * 
	 * @return situation (enum CountrySituation)
	 */
	public CountrySituation getSituation() {
		return situation;
	}

	@JsonIgnore
	public List<Client> getClients() {
		return clients;
	}

	@JsonIgnore
	public List<City> getCities() {
		return cities;
	}

	@Override
	public String toString() {
		return "Country [cities=" + cities + ", clients=" + clients + ", countryCode=" + countryCode + ", countryName="
				+ countryName + ", id=" + id + ", location=" + location + ", situation=" + situation + "]";
	}

}
