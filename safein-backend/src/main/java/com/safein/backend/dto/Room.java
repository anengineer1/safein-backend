/**
 * 
 */
package com.safein.backend.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "rooms")
public class Room {

	// ----------------- Atributes -----------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "num_people")
	private Long num_people;

	@Column(name = "code")
	private String code;

	@Column(name = "price_per_night")
	private double price_per_night;

	@Column(name = "internet_type")
	private String internet_type;

	@Column(name = "is_smoker")
	private String is_smoker;

	@Column(name = "has_terrace")
	private String has_terrace;

	@OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Handle> handles;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	// ----------------- Constructors -----------------
	/**
	 * Default Constructor
	 */
	public Room() {

	}

	/**
	 * Constructor with parameters
	 * 
	 * @param id
	 * @param num_people
	 * @param code
	 * @param price_per_night
	 * @param nternet_type
	 * @param is_smoker
	 * @param has_terrace
	 * @param handles
	 * @param hotel
	 */
	public Room(Long id, Long num_people, String code, double price_per_night, String internet_type, String is_smoker,
			String has_terrace, List<Handle> handles, Hotel hotel) {
		super();
		this.id = id;
		this.num_people = num_people;
		this.code = code;
		this.price_per_night = price_per_night;
		this.internet_type = internet_type;
		this.is_smoker = is_smoker;
		this.has_terrace = has_terrace;
		this.handles = handles;
		this.hotel = hotel;
	}

	// ----------------- Getters + Setters -----------------
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the num_people
	 */
	public Long getNum_people() {
		return num_people;
	}

	/**
	 * @param num_people the num_people to set
	 */
	public void setNum_people(Long num_people) {
		this.num_people = num_people;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the price_per_night
	 */
	public double getPrice_per_night() {
		return price_per_night;
	}

	/**
	 * @param price_per_night the price_per_night to set
	 */
	public void setPrice_per_night(double price_per_night) {
		this.price_per_night = price_per_night;
	}

	/**
	 * @return the nternet_type
	 */
	public String getInternet_type() {
		return internet_type;
	}

	/**
	 * @param nternet_type the nternet_type to set
	 */
	public void setInternet_type(String Internet_type) {
		this.internet_type = Internet_type;
	}

	/**
	 * @return the is_smoker
	 */
	public String getIs_smoker() {
		return is_smoker;
	}

	/**
	 * @param is_smoker the is_smoker to set
	 */
	public void setIs_smoker(String is_smoker) {
		this.is_smoker = is_smoker;
	}

	/**
	 * @return the has_terrace
	 */
	public String getHas_terrace() {
		return has_terrace;
	}

	/**
	 * @param has_terrace the has_terrace to set
	 */
	public void setHas_terrace(String has_terrace) {
		this.has_terrace = has_terrace;
	}

	/**
	 * @return the handles
	 */
	@JsonIgnore
	public List<Handle> getHandles() {
		return handles;
	}

	/**
	 * @param handles the handles to set
	 */
	public void setHandles(List<Handle> handles) {
		this.handles = handles;
	}

	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}

	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	// ----------------- Methods -----------------
	@Override
	public String toString() {
		return "Room [id=" + id + ", num_people=" + num_people + ", code=" + code + ", price_per_night="
				+ has_terrace + ", handles=" + handles + ", hotel=" + hotel + "]";
	}

}