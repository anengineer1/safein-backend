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
@Table(name = "hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "latitude")
	private double latitude;

	@Column(name = "longitude")
	private double longitude;

	@Column(name = "security_level")
	private String securityLevel;

	@Column(name = "energy_suficient")
	private boolean energySuficient;

	@ManyToOne
	@JoinColumn(name = "id_city")
	private City city;
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Room> rooms;

	/**
	 * @param id
	 * @param name
	 * @param phonenumber
	 * @param email
	 * @param address
	 * @param latitude
	 * @param longitude
	 * @param securityLevel
	 * @param energySuficient
	 * @param city
	 */
	public Hotel(int id, String name, String phonenumber, String email, String address, double latitude,
			double longitude, String securityLevel, boolean energySuficient, City city) {

		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.securityLevel = securityLevel;
		this.energySuficient = energySuficient;
		this.city = city;
	}

	public Hotel() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	 * @return the city
	 */
	public City getCity() {
		return city;
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
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public boolean isEnergySuficient() {
		return energySuficient;
	}

	public void setEnergySuficient(boolean energySuficient) {
		this.energySuficient = energySuficient;
	}

	public City getCities() {
		return city;
	}

	public void setCities(City city) {
		this.city = city;
	}
	
	

	/**
	 * @return the rooms
	 */
	@JsonIgnore
	public List<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", phonenumber=" + phonenumber + ", email=" + email + ", address="
				+ address + ", latitude=" + latitude + ", longitude=" + longitude + ", securityLevel=" + securityLevel
				+ ", energySuficient=" + energySuficient + ", city=" + city + "]";
	}

}
