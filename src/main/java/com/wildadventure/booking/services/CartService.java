package com.wildadventure.booking.services;

import java.util.Optional;

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
		return cartDao.findByUserId(userId);
	}

	@Override
	public Cart addCart(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public Optional<Cart> getCartById(Long id) {
		return cartDao.findById(id);
	}

	@Override
	public void cleanCart(Long cartId) {
		cartDao.deleteById(cartId);

	}

	@Override
	public Cart addTrip(Long cartId, Long tripId, Integer nbPerson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart updateCart(Cart cart) {
		return cartDao.save(cart);
	}

	@Override
	public Boolean cartExists(Long userId) {
		return cartDao.existsByUserId(userId);
	}

}
