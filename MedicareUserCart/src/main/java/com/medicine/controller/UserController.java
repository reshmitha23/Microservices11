package com.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.domain.Cart;
import com.medicine.proxy.IUserService;

@RestController
@Scope("request")

public class UserController {
	@Autowired
	
	private IUserService userservice;
	
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(code = HttpStatus.OK)
	public String dummymethod() {
		return "working";
	}

	@PostMapping("/addToCart")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cart addToCart(Cart medicine) {
		return userservice.addToCart(medicine);

	}

	@PutMapping("/updateCart")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Cart updateCart(Cart medicine) {
		return userservice.updateCart(medicine);

	}
    
	@GetMapping("/getCart")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Cart> getAllItems() {
		System.out.println("hiee");
		System.out.println(userservice);
		return userservice.getAllItems();
	}

	@DeleteMapping("/delete{cId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteItemById(@PathVariable("cid") Integer cId) {

		userservice.deleteItemById(cId);

	}

}
