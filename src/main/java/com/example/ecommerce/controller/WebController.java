package com.example.ecommerce.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	 @RequestMapping(value="/view", produces = {
		        MediaType.TEXT_HTML_VALUE},
		        method = RequestMethod.GET)
		public String viewProducts () {
			System.out.println("product-listing");
		    return "product-listing.html";
		}

}
