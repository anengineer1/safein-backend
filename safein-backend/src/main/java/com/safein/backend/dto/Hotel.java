/**
 * 
 */
package com.safein.backend.dto;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Alejandro Jiménez Álvarez
 *
 */
@Entity
@Table(name="hotels")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name="name")
	private String name;
	@Column(name="Phonenumber")
	private String Phonenumber;
	@Column(name="email")
	private  String email;
	@Column(name = "address")
	private String address;
	@Column(name= "location")
	private String location;
	@Column (name="securityLevel")
	private String securityLevel;
	@Column (name="energy_suficient")
	private boolean energy_suficient;
	@OneToMany
	@JoinColumn(name = "cities")
	private List<City> cities;
	
	public Hotel(int id, String name, String phonenumber, String email, String address, String location, String securityLevel, boolean energy_suficient, List<City> cities) {
		super();
		this.id = id;
		this.name = name;
		Phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.location = location;
		this.securityLevel = securityLevel;
		this.energy_suficient = energy_suficient;
		this.cities = cities;
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
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}
	public boolean isEnergy_suficient() {
		return energy_suficient;
	}
	public void setEnergy_suficient(boolean energy_suficient) {
		this.energy_suficient = energy_suficient;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", Phonenumber=" + Phonenumber + ", email=" + email + ", address="
				+ address + ", location=" + location + ", securityLevel=" + securityLevel + ", energy_suficient="
				+ energy_suficient + "]";
	}

	
	
}
