package com.wildadventure.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildadventure.booking.models.Cart;

/**
 * DB access to Cart model store into DB
 * @author Titouan
 *
 */
@Repository
public interface ICartDao extends JpaRepository<Cart, Long>{
	
	public Cart findByUserId(Long userId);
	
	public Boolean existsByUserId(Long userId);
	
}
