package com.wildadventure.booking.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Model booking to store a booking of a user
 * @author Titouan
 *
 */

@Entity
public class Booking {

	@Id
	@GeneratedValue
	@Column(name="BOOKING_ID")
	private Long id;
	@Column(name="NB_PERSON")
	private Integer nbPerson;
	@Column(name="DATE")
	private Date date;
	@Column(name="STATUS")
	private Integer status;
	@Column(name="PAYED")
	private Boolean payed;
	@Column(name="USER_ID")
	private Long userId;
	// Id of the trip instance not the description of it
	@Column(name="TRIP_ID")
	private Long tripId;
	
	public Booking() {
		
	}
	
	public Booking(Long id, Integer nbPerson, Date date, Integer status, Boolean payed, Long idUser, Long idTrip) {
		super();
		this.id = id;
		this.nbPerson = nbPerson;
		this.date = date;
		this.status = status;
		this.payed = payed;
		this.userId = idUser;
		this.tripId = idTrip;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Boolean getPayed() {
		return payed;
	}
	public void setPayed(Boolean payed) {
		this.payed = payed;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long idUser) {
		this.userId = idUser;
	}
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long idTrip) {
		this.tripId = idTrip;
	}
	
	@Override
	public String toString() {
		return "Booking [id=" + id + ", nbPerson=" + nbPerson + ", date=" + date + ", status=" + status + ", payed="
				+ payed + ", idUser=" + userId + ", idTrip=" + tripId + "]";
	}
	
}
