/**
 * 
 */
package com.safein.backend.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author Alejandro Jiménez Álvarez
 *
 */
@RestController
@RequestMapping("/api")
public class Customers {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column (name = "name")
private String name;

@Column (name = "Phonenumber")
private String Phonenumber;

@Column (name = "email")
private String email;

@Column (name = "press_media")
private String press_media;

@Column (name = "doc_identifier")
private String doc_identifier;

@Column (name = "num_identifier")
private String num_identifier;

@ManyToOne
@JoinColumn(name="country_id")
private Country countries;

@ManyToOne
@JoinColumn(name = "booking_id")
private Booking booking;

public Customers(int id, String name, String phonenumber, String email, String press_media, String doc_identifier,
		String num_identifier) {
	super();
	this.id = id;
	this.name = name;
	Phonenumber = phonenumber;
	this.email = email;
	this.press_media = press_media;
	this.doc_identifier = doc_identifier;
	this.num_identifier = num_identifier;
	
}
public Customers(){}
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
public String getPress_media() {
	return press_media;
}
public void setPress_media(String press_media) {
	this.press_media = press_media;
}
public String getDoc_identifier() {
	return doc_identifier;
}
public void setDoc_identifier(String doc_identifier) {
	this.doc_identifier = doc_identifier;
}
public String getNum_identifier() {
	return num_identifier;
}
public void setNum_identifier(String num_identifier) {
	this.num_identifier = num_identifier;
}

@Override
public String toString() {
	return "Client [id=" + id + ", name=" + name + ", Phonenumber=" + Phonenumber + ", email=" + email
			+ ", press_media=" + press_media + ", doc_identifier=" + doc_identifier + ", num_identifier="
			+ num_identifier + "]";
}


}
