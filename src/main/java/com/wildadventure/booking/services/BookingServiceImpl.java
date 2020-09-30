package com.wildadventure.booking.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.booking.dao.IBookingDao;
import com.wildadventure.booking.models.Booking;
import com.wildadventure.booking.models.UserBookingsResponse;
import com.wildadventure.booking.proxies.ITripProxy;


@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingDao bookingDao;
	
	@Autowired
	private ITripProxy tripProxy;
	
	@Override
	@Transactional
	public List<UserBookingsResponse> getBookingsByUser(Long userId) {
		List<Booking> bookings = bookingDao.findByUserId(userId);
		List<UserBookingsResponse> response = new ArrayList<UserBookingsResponse>();
		
		for(Booking b : bookings) {
			response.add(new UserBookingsResponse(b, tripProxy.getTripInstanceForBooking(b.getTripId().intValue())));
		}
		return response;
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
