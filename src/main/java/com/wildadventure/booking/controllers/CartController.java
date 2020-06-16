package com.wildadventure.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventure.booking.exception.CartNotFoundException;
import com.wildadventure.booking.models.Cart;
import com.wildadventure.booking.services.ICartService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/Cart")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@GetMapping("/byUser/{id}")
	public ResponseEntity<Cart> getCartByUser(@RequestParam int id) throws CartNotFoundException {
		Cart cart = cartService.getCartByUser(new Long(id));
		if(cart != null) {
			return ResponseEntity.ok(cart);
		}else {
			throw new CartNotFoundException("Cannot find cart with userId : " + id);
		}
	}

}
