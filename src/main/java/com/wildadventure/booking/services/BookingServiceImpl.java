package com.wildadventure.booking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.booking.dao.IBookingDao;
import com.wildadventure.booking.models.Booking;


@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao bookingDao;
	
	@Override
	public List<Booking> getBookingsByUser(Long userId) {
		return bookingDao.findByUserId(userId);
	}

	@Override
	public Optional<Booking> getBookingById(Long id) {
		return bookingDao.findById(id);
	}

	@Override
	public Booking getBookingByTripAndUser(Long tripId, Long userId) {
		return bookingDao.findByTripIdAndUserId(tripId, userId);
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookingDao.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		return bookingDao.save(booking);
	}

	@Override
	public Integer getNumberOfClient(int tripId) {
		List<Booking> lb = bookingDao.findByTripId(new Long(tripId));
		Integer counter = 0;
		
		for(Booking b : lb) {
			counter += b.getNbPerson();
		}
		
		return counter;
	}

}
