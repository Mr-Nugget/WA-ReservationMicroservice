package com.wildadventure.booking.services;

import java.util.List;
import java.util.Optional;

import com.wildadventure.booking.models.Booking;
import com.wildadventure.booking.models.UserBookingsResponse;

public interface IBookingService {

	public List<UserBookingsResponse> getBookingsByUser(Long userId);
	
	public Optional<Booking> getBookingById(Long id);
	
	public Booking getBookingByTripAndUser(Long tripId, Long userId);
	
	public Booking addBooking(Booking booking);
	
	public Booking updateBooking(Booking booking);

	public Integer getNumberOfClient(int tripId);
}
