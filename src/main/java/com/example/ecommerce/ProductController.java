package com.example.ecommerce;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	 private final ProductRepository repository;

	 ProductController(ProductRepository repository) {
	    this.repository = repository;
	  }
	
	 @RequestMapping(value="/", produces = {
		        MediaType.TEXT_HTML_VALUE},
		        method = RequestMethod.GET)
		public String index () {
			//System.out.println("product-listing");
		    return "/view";
		}
	

	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		return repository.findAll();
		  
	}
	@GetMapping("/products/{id}")	
	public Product getProduct(@PathVariable Integer id) {	
		System.out.println("find one - " + id);
		return repository.findOne(id);
		  
	}
	@PostMapping("/products")
	Product newProduct(@RequestBody Product newProduct) {
		System.out.println("Post for new product:" + newProduct.getName() + ":" + newProduct.getPrice());
		
	    return repository.save(newProduct);
	  }
	
	@PutMapping("/products/{id}")
	Product updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {

		Product product = repository.findOne(id);
		product.setName(newProduct.getName());
		product.setPrice(newProduct.getPrice());
		return repository.save(product);	    
	  }

	  @DeleteMapping("/products/{id}")
	  void deleteProduct(@PathVariable Integer id) {
	    repository.delete(id);
	  }
	  
	  
	 
}


 

