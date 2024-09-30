package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
