package com.wildadventure.booking.services;

import java.util.Optional;

import com.wildadventure.booking.models.Cart;

public interface ICartService {

	public Cart getCartByUser(Long userId);
	
	public Cart addCart(Cart cart);
	
	public Optional<Cart> getCartById(Long id);
	
	public void cleanCart(Long cartId);
	
	public Cart addTrip(Long cartId, Long tripId, Integer nbPerson);
	
	public Cart updateCart(Cart cart);
	
	public Boolean cartExists(Long cartId);
}
