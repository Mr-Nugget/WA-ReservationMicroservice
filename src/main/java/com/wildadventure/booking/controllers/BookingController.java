package com.wildadventure.booking.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventure.booking.exceptions.BookingAlreadyExistsException;
import com.wildadventure.booking.exceptions.BookingNotFoundException;
import com.wildadventure.booking.exceptions.BookingStatusErrorException;
import com.wildadventure.booking.models.Booking;
import com.wildadventure.booking.models.UpdatePaymentRequest;
import com.wildadventure.booking.models.UserBookingsResponse;
import com.wildadventure.booking.proxies.ITripProxy;
import com.wildadventure.booking.services.IBookingService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Booking")
public class BookingController {
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private ITripProxy tripProxy;
	
	private static Logger log = Logger.getLogger(BookingController.class);
	
	/**
	 * Return the list of booking associated to a user
	 * @param id
	 * @return
	 * @throws BookingNotFoundException
	 */
	@GetMapping("/byUser/{id}")
	public ResponseEntity<List<UserBookingsResponse>> getBookingsByUser(@PathVariable int id) throws BookingNotFoundException {
		List<Booking> bookings = bookingService.getBookingsByUser(new Long(id));
		List<UserBookingsResponse> response = new ArrayList<UserBookingsResponse>();
		for(Booking b : bookings) {
			response.add(new UserBookingsResponse(b, tripProxy.getTripInstanceForBooking(b.getTripId().intValue())));
		}
		if(bookings != null && bookings.size() > 0 && !response.isEmpty()) {
			return ResponseEntity.ok(response);
		}else {
			throw new BookingNotFoundException("Cannot find booking with userId : " + id);
		}
	}
	
	/**
	 * Add a new booking into DB
	 * @param booking
	 * @return the new booking
	 * @throws BookingAlreadyExistsException
	 */
	@PostMapping("/add")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws BookingAlreadyExistsException {
		// Checking if the cart has already been created
		Booking existingBooking = bookingService.getBookingByTripAndUser(booking.getTripId(), booking.getUserId());
		
		if(existingBooking != null) {
			throw new BookingAlreadyExistsException("This booking you want to add already exists.");
		}else {
			Booking bookingCreated = bookingService.addBooking(booking);
			if(bookingCreated != null) {
				return ResponseEntity.ok(bookingCreated);
			}else {
				return ResponseEntity.status(400).build();
			}
		}
	}
	
	/**
	 * Update boolean payed in booking object
	 * @param request
	 * @return
	 * @throws BookingNotFoundException 
	 */
	@PostMapping("/updatePayment")
	public Booking updateBookingPayment(@RequestBody UpdatePaymentRequest request) throws BookingNotFoundException{
		if(request != null) {
			Optional<Booking> option = bookingService.getBookingById(request.getId());
			if(option.isPresent()) {
				Booking oldBooking = option.get();
				oldBooking.setPayed(request.isPaid());
				Booking newBooking = bookingService.updateBooking(oldBooking);
				if(newBooking != null) {
					return newBooking;
				}else {
					return null;
				}
			}else {
				throw new BookingNotFoundException("Cannot find booking with id : " + request.getId());
			}
		}else {
			return null;
		}
	}
	
	/**
	 * Update booking status after the user comment the trip associated
	 * @param id
	 * @return
	 * @throws BookingNotFoundException
	 * @throws BookingStatusErrorException
	 */
	@GetMapping("/updateStatus/{id}")
	public ResponseEntity<Void> updateBookingStatus(@PathVariable int id) throws BookingNotFoundException, BookingStatusErrorException{
		Optional<Booking> optBooking = bookingService.getBookingById(new Long(id));
		if(optBooking.isPresent()) {
			Booking booking = optBooking.get();
			Integer status = booking.getStatus();
			if(status == 3){
				// Update status to closed. User cannot comment anymore.
				booking.setStatus(4);
				bookingService.updateBooking(booking);
				return ResponseEntity.ok().build();
				
			}else {
				throw new BookingStatusErrorException();
			}
		}else {
			throw new BookingNotFoundException("Error during updating booking status.");
		}
	}
	
	/**
	 * Get the number of person associated to a tripId
	 * @param tripId
	 * @return
	 */
	@GetMapping("/nbOfClient/{tripId}")
	public ResponseEntity<Integer> getBookingNumber(@PathVariable int tripId) {
		Integer clientCounter = bookingService.getNumberOfClient(tripId);
		
		return ResponseEntity.ok(clientCounter);
	}
}
