package com.medicine.proxy;

import java.util.List;




import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.medicine.domain.Cart;
import com.medicine.fallback.CartFallback;

@FeignClient(name="userservice",fallback=CartFallback.class)
public interface IUserService {
	
	@GetMapping(value="/",produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code=HttpStatus.OK)
	public String dummymethod();
	
	@PostMapping(value="/cart",produces= {MediaType.APPLICATION_JSON_VALUE} , consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code=HttpStatus.CREATED)
	public Cart addToCart(Cart medicine);
	
	@PutMapping(value="/cart",produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public Cart updateCart(Cart medicine);
	
	
	@GetMapping(value="/cart",produces= {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code=HttpStatus.OK)
	public List<Cart> getAllItems();
	
	@DeleteMapping(value="/cart/{id}",produces= {MediaType.APPLICATION_JSON_VALUE ,})
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteItemById(@PathVariable("cId") Integer cId);
}
