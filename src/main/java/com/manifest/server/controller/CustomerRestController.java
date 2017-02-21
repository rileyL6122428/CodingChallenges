package com.manifest.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manifest.server.model.Customer;
import com.manifest.server.repository.CustomerRepository;

@RestController
public class CustomerRestController {

	private final CustomerRepository customerRepo;
	
	@Autowired
	CustomerRestController(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	
	@GetMapping(produces = "application/json", path="/testing")
	public Object testAction() {
		return this.customerRepo.findAll();
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json", path="/testPost")
	public Object testPost(@RequestBody Customer customer) {
		return this.customerRepo.save(customer);
	}
}
