package com.wildadventure.booking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.booking.models.Booking;

@Repository
public interface IBookingDao extends JpaRepository<Booking, Long>{
	
	public List<Booking> findByUserId(Long userId);
	
	public Booking findByTripIdAndUserId(Long tripId, Long userId);
	
	public List<Booking> findByTripId(Long tripId);

}
