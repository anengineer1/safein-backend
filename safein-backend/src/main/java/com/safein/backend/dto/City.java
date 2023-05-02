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

	@Column(name = "location")
	private Point location;

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
	 * |
	 * Constructor with parameters
	 * 
	 * @param id
	 * @param location
	 * @param name
	 * @param id_country
	 */
	public City(long id, Point location, String name, Country id_country) {
		this.id = id;
		this.location = location;
		this.name = name;
		this.country = id_country;
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
	 * Gets the location
	 * 
	 * @return location (Point) (Latitude, Longitude)
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * Sets the location of the city
	 * 
	 * @param location (Point) (Latitude, Longitude)
	 */

	public void setLocation(Point location) {
		this.location = location;
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

	/**
	 * New toString
	 *
	 */
	@Override
	public String toString() {
		return "City [id=" + id + ", id_country=" + country + ", location=" + location + ", name=" + name + "]";
	}

}
