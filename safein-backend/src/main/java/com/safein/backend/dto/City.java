/**
 * 
 */
package com.safein.backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.geo.Point;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
@Entity
@Table(name = "Cities")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "id_country")
	private Country country;

	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Hotel> hotels;

	/**
	 * Default constructor
	 *
	 */
	public City() {
	}

	/**
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param name
	 * @param country
	 * @param hotels
	 */
	public City(long id, double latitude, double longitude, String name, Country country, List<Hotel> hotels) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.country = country;
		this.hotels = hotels;
	}

	/**
	 * Gets the internal id
	 * 
	 * @return the id (long)
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the name of the city
	 * 
	 * @return name (String)
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the city
	 * 
	 * @param name (String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the country
	 * 
	 * @return country (Country)
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Sets the country
	 * 
	 * @param country (Country)
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	@JsonIgnore
	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name
				+ ", country=" + country + ", hotels=" + hotels + "]";
	}

}
