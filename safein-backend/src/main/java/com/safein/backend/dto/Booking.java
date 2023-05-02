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
 * @author Elena, Alejandro Francisco
 *
 */
@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "import")
	private double amount;

	@Column(name = "num_people")
	private int numPeople;

	@Column(name = "is_payed")
	private boolean isPayed;

	@Column(name = "is_pending_pay")
	private boolean isPendingPay;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Handle> handles;

	/**
	 * Default constructor
	 *
	 */
	public Booking() {
	}

	/**
	 * Constructor with parameters
	 * 
	 * @param amount       (double)
	 * @param numPeople    (int)
	 * @param isPayed      (boolean)
	 * @param isPendingPay (boolean)
	 * @param client       (Customer)
	 * @param user         (User)
	 * @param handles
	 */
	public Booking(double amount, int numPeople, boolean isPayed, boolean isPendingPay, Client client, User user,
			List<Handle> handles) {
		this.amount = amount;
		this.numPeople = numPeople;
		this.isPayed = isPayed;
		this.isPendingPay = isPendingPay;
		this.client = client;
		this.user = user;
		this.handles = handles;
	}

	/**
	 * Sets the internal autoincremental Id
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Sets the amount of money the booking costs
	 * 
	 * @param amount
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Sets the numbre of people in the booking
	 * 
	 * @param numPeople
	 */
	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}

	/**
	 * Set if it is payed or not
	 * 
	 * @param isPayed
	 */
	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}

	/**
	 * Set if the payment is pending
	 * 
	 * @param isPendingPay
	 */
	public void setPendingPay(boolean isPendingPay) {
		this.isPendingPay = isPendingPay;
	}

	/**
	 * Sets the client
	 * 
	 * @param client (Client)
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Sets the user
	 * 
	 * @param user (User)
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Set Handles
	 * 
	 * @param handles (List<Handle>)
	 */
	public void setHandles(List<Handle> handles) {
		this.handles = handles;
	}

	/**
	 * Get the inernal id
	 * 
	 * @return long
	 */
	public long getId() {
		return id;
	}

	/**
	 * Returns the ammount needed for the booking
	 * 
	 * @return double
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * Returns the number of people
	 * 
	 * @return int
	 */
	public int getNumPeople() {
		return numPeople;
	}

	/**
	 * Returns if the customer has paid
	 * 
	 * @return boolean
	 */
	public boolean isPayed() {
		return isPayed;
	}

	/**
	 * Returns if the customer needs the to do the payment
	 * 
	 * @return boolean
	 */
	public boolean isPendingPay() {
		return isPendingPay;
	}

	/**
	 * Get client
	 * 
	 * @return Client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Get he user
	 * 
	 * @return (User)
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Get handles
	 * 
	 * @return
	 */
	@JsonIgnore
	public List<Handle> getHandles() {
		return handles;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Booking [amount=" + amount + ", client=" + client + ", handles=" + handles + ", id=" + id
				+ ", isPayed=" + isPayed + ", isPendingPay=" + isPendingPay + ", numPeople=" + numPeople + ", user="
				+ user + "]";
	}

}
