package com.spring_security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security.dto.Product;
import com.spring_security.service.ProductService;

@RestController
@RequestMapping("/products")
public class HomeController {
	
	@Autowired ProductService service;

	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome to Products</h1>");
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllProducts() {
		return service.getAllMessages();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getAllProducts(@PathVariable("id") int productId) {
		return service.getProduct(productId);
	}
	
}
