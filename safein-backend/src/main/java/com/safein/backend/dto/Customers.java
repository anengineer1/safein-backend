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
import jakarta.persistence.UniqueConstraint;

/**
 * @author Elena, Alejandro, Francisco
 *
 */
@Entity
@Table(name = "customers", uniqueConstraints = {
		@UniqueConstraint(name = "unique_combination", columnNames = { "doc_identificator", "num_identificator" }) })
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;

	@Column(name = "Phonenumber")
	private String Phonenumber;

	@Column(name = "email")
	private String email;

	@Column(name = "press_media")
	private String pressMedia;

	@Column(name = "doc_identificator")
	private String docIdentifier;

	@Column(name = "num_identificator")
	private String numIdentifier;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@OneToMany(mappedBy = "customers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Booking> booking;

	public Customers(int id, String name, String phonenumber, String email, String press_media, String doc_identifier,
			String num_identifier) {
		super();
		this.id = id;
		this.name = name;
		Phonenumber = phonenumber;
		this.email = email;
		this.pressMedia = press_media;
		this.docIdentifier = doc_identifier;
		this.numIdentifier = num_identifier;

	}

	public Customers() {
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

	/**
	 * @return the pressMedia
	 */
	public String getPressMedia() {
		return pressMedia;
	}

	/**
	 * @param pressMedia the pressMedia to set
	 */
	public void setPressMedia(String pressMedia) {
		this.pressMedia = pressMedia;
	}

	/**
	 * @return the docIdentifier
	 */
	public String getDocIdentifier() {
		return docIdentifier;
	}

	/**
	 * @param docIdentifier the docIdentifier to set
	 */
	public void setDocIdentifier(String docIdentifier) {
		this.docIdentifier = docIdentifier;
	}

	/**
	 * @return the numIdentifier
	 */
	public String getNumIdentifier() {
		return numIdentifier;
	}

	/**
	 * @param numIdentifier the numIdentifier to set
	 */
	public void setNumIdentifier(String numIdentifier) {
		this.numIdentifier = numIdentifier;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}

	/**
	 * @return the booking
	 */
	@JsonIgnore
	public List<Booking> getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", Phonenumber=" + Phonenumber + ", email=" + email
				+ ", press_media=" + pressMedia + ", doc_identifier=" + docIdentifier + ", num_identifier="
				+ numIdentifier + "]";
	}

}
