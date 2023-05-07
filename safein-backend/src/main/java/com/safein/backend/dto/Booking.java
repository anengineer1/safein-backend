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

	@Column(name = "amount")
	private double amount;

	@Column(name = "num_people")
	private int numPeople;

	@Column(name = "is_payed")
	private boolean isPayed;

	@Column(name = "is_pending_pay")
	private boolean isPendingPay;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@ManyToOne
	@JoinColumn(name = "suser_id")
	private Suser suser;

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
	 * @param customers    (Customer)
	 * @param suser         (Suser)
	 * @param handles
	 */
	public Booking(double amount, int numPeople, boolean isPayed, boolean isPendingPay, Customers customers, Suser suser,
			List<Handle> handles) {
		this.amount = amount;
		this.numPeople = numPeople;
		this.isPayed = isPayed;
		this.isPendingPay = isPendingPay;
		this.customers = customers;
		this.suser = suser;
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
	 * Sets the customers
	 * 
	 * @param customers (Customers)
	 */
	public void setCustomers(Customers customers) {
		this.customers = customers;
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
	 * Get customers
	 * 
	 * @return Customers
	 */
	public Customers getCustomers() {
		return customers;
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
	 * @return the suser
	 */
	public Suser getSuser() {
		return suser;
	}

	/**
	 * @param suser the suser to set
	 */
	public void setSuser(Suser suser) {
		this.suser = suser;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Booking [amount=" + amount + ", customers=" + customers + ", handles=" + handles + ", id=" + id
				+ ", isPayed=" + isPayed + ", isPendingPay=" + isPendingPay + ", numPeople=" + numPeople + ", user="
				+ suser + "]";
	}

}
