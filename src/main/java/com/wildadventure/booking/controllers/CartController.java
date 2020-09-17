package com.wildadventure.booking.controllers;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildadventure.booking.exceptions.CartNotFoundException;
import com.wildadventure.booking.models.Cart;
import com.wildadventure.booking.services.ICartService;

@RestController
@RequestMapping("/Cart")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	private static Logger log = Logger.getLogger(CartController.class);
	
	@GetMapping("/byUser/{id}")
	public ResponseEntity<Cart> getCartByUser(@PathVariable int id) throws CartNotFoundException {
		Cart cart = cartService.getCartByUser(new Long(id));
		if(cart != null) {
			return ResponseEntity.ok(cart);
		}else {
			throw new CartNotFoundException("Cannot find cart with userId : " + id);
		}
	}
	
	/**
	 * Create a cart associated to a user. If the cart already exists, update the cart.
	 * @param cart
	 * @return
	 * @throws CartNotFoundException
	 */
	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws CartNotFoundException{
		// Checking if the cart has already been created
		Cart existingCart = cartService.getCartByUser(cart.getIdUser());
		
		if(existingCart != null) {
			existingCart.setIdTrip(cart.getIdTrip());
			existingCart.setNbPerson(cart.getNbPerson());
			existingCart.setTotalPrice(cart.getTotalPrice());
			
			Cart cartUpdated = cartService.updateCart(existingCart);
			if(cartUpdated != null) return ResponseEntity.ok(cartUpdated);
			
		}else {
			Cart cartCreated = cartService.addCart(cart);
			if(cartCreated != null) return ResponseEntity.ok(cartCreated);
		}
		
		return ResponseEntity.status(400).build();
	}
	
	/**
	 * Delete a cart by its ID
	 * @param id
	 * @return
	 * @throws CartNotFoundException
	 */
	@GetMapping("/clean/{id}")
	public ResponseEntity<Void> cleanCart(@PathVariable int id) throws CartNotFoundException{
		Optional<Cart> option = cartService.getCartById(new Long(id));
		if(option.isPresent()) {
			cartService.cleanCart(option.get().getId());
			return ResponseEntity.ok().build();
		}
		else {
			throw new CartNotFoundException("Cannot clean cart who do not exists");
		}
			
	}
}
