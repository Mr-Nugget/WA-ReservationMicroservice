package com.wildadventure.booking.models;

/**
 * Object to return to return to get bookings by user
 * @author Titouan
 *
 */
public class UserBookingsResponse {

	private Booking booking;
	private Object trip;
	
	public UserBookingsResponse() {
		
	}
	
	
	
	public UserBookingsResponse(Booking booking, Object trip) {
		super();
		this.booking = booking;
		this.trip = trip;
	}



	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Object getTrip() {
		return trip;
	}
	public void setTrip(Object trip) {
		this.trip = trip;
	}
	
	
}
