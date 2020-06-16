package com.wildadventure.booking.services;

import com.wildadventure.booking.models.Cart;

public interface ICartService {

	public Cart getCartByUser(Long userId);
	
	public Cart addCart(Cart cart);
	
	public Cart getCatById(Long id);
	
	public void cleanCart(Long cartId);
	
	public Cart addTrip(Long cartId, Long tripId, Integer nbPerson);
}
