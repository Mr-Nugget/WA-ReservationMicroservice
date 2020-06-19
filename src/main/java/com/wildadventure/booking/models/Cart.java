package com.wildadventure.booking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Model cart associated to a user to store reservation process of a trip
 * @author Titouan
 *
 */
@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	@Column(name="CART_ID")
	private Long id;
	@Column(name="NB_PERSON")
	private Integer nbPerson;
	@Column(name="TRIP_ID")
	private Long tripId;
	@Column(name="USER_ID", unique=true)
	private Long userId;
	@Column(name="TOTAL_PRICE")
	private Long totalPrice;
	
	public Cart() {
		
	}
	
	public Cart(Long id, Integer nbPerson, Long idTrip, Long idUser, Long totalPrice) {
		super();
		this.id = id;
		this.nbPerson = nbPerson;
		this.tripId = idTrip;
		this.userId = idUser;
		this.totalPrice = totalPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNbPerson() {
		return nbPerson;
	}
	public void setNbPerson(Integer nbPerson) {
		this.nbPerson = nbPerson;
	}
	public Long getIdTrip() {
		return tripId;
	}
	public void setIdTrip(Long idTrip) {
		this.tripId = idTrip;
	}
	public Long getIdUser() {
		return userId;
	}
	public void setIdUser(Long idUser) {
		this.userId = idUser;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", nbPerson=" + nbPerson + ", idTrip=" + tripId + ", idUser=" + userId
				+ ", totalPrice=" + totalPrice + "]";
	}
}
