package com.example.ecommerce;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketController 
{
	private final BasketRepository repository;

	BasketController(BasketRepository repository) {
	    this.repository = repository;
	  }
	@PostMapping("/basket")
	Basket addToBasket(@RequestBody Basket newBasket) {
		System.out.println("Post for new basket:" + newBasket.getName() + ":" + newBasket.getPrice());
		
	    return repository.save(newBasket);
	  }

}
