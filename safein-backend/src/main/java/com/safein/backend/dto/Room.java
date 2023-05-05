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
	private Long numPeople;

	@Column(name = "room_code")
	private String code;

	@Column(name = "price_per_night")
	private double pricePerNight;

	@Column(name = "internet_type")
	private String internetType;

	@Column(name = "is_smoker")
	private boolean isSmoker;

	@Column(name = "has_terrace")
	private boolean hasTerrace;

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
	public Room(Long id, Long numPeople, String code, double price_per_night, String internet_type, Boolean is_smoker,
			Boolean has_terrace, List<Handle> handles, Hotel hotel) {
		super();
		this.id = id;
		this.numPeople = numPeople;
		this.code = code;
		this.pricePerNight = price_per_night;
		this.internetType = internet_type;
		this.isSmoker = is_smoker;
		this.hasTerrace = has_terrace;
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
	public Long getNumPeople() {
		return numPeople;
	}

	/**
	 * @param num_people the num_people to set
	 */
	public void setNumPeople(Long numPeople) {
		this.numPeople = numPeople;
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
	 * @return the pricePerNight
	 */
	public double getPricePerNight() {
		return pricePerNight;
	}

	/**
	 * @param pricePerNight the pricePerNight to set
	 */
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	/**
	 * @return the internetType
	 */
	public String getInternetType() {
		return internetType;
	}

	/**
	 * @param internetType the internetType to set
	 */
	public void setInternetType(String internetType) {
		this.internetType = internetType;
	}

	/**
	 * @return the isSmoker
	 */
	public boolean isSmoker() {
		return isSmoker;
	}

	/**
	 * @param isSmoker the isSmoker to set
	 */
	public void setSmoker(boolean isSmoker) {
		this.isSmoker = isSmoker;
	}

	/**
	 * @return the hasTerrace
	 */
	public boolean isHasTerrace() {
		return hasTerrace;
	}

	/**
	 * @param hasTerrace the hasTerrace to set
	 */
	public void setHasTerrace(boolean hasTerrace) {
		this.hasTerrace = hasTerrace;
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
		return "Room [id=" + id + ", num_people=" + numPeople + ", code=" + code + ", price_per_night="
				+ hasTerrace + ", handles=" + handles + ", hotel=" + hotel + "]";
	}

}