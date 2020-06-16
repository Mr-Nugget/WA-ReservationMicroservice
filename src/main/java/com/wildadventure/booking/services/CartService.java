package com.wildadventure.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wildadventure.booking.dao.ICartDao;
import com.wildadventure.booking.models.Cart;

@Service
public class CartService implements ICartService {
	
	@Autowired
	private ICartDao cartDao;

	@Override
	public Cart getCartByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanCart(Long cartId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart addTrip(Long cartId, Long tripId, Integer nbPerson) {
		// TODO Auto-generated method stub
		return null;
	}

}
