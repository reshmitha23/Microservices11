package com.medicine.fallback;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.medicine.domain.Cart;
import com.medicine.proxy.IUserService;

@Component
public class CartFallback implements IUserService{
	
	@Override
	public Cart addToCart(Cart medicine) {
		
		return new Cart();
	}

	@Override
	public Cart updateCart(Cart medicine) {
		return medicine;
		
	}

	@Override
	public List<Cart> getAllItems() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Cart());
	}

	@Override
	public void deleteItemById(Integer cId) {
		// TODO Auto-generated method stub
		System.out.println("Cannot delete the item with id"+cId);
	}

	@Override
	public String dummymethod() {
		// TODO Auto-generated method stub
		return "fallback";
	}

}
