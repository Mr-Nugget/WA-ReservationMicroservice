package com.wildadventure.booking.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="trip-microservice", url="localhost:9090")
public interface ITripProxy {
	
	@GetMapping(value="/Dates/byId/{id}")
	public ResponseEntity<Object> getTripInstanceForBooking(@PathVariable int id);
}
