package com.manifest.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.manifest.server.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> { }


