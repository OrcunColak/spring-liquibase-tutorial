package com.colak.springliquibasetutorial.repository;

import com.colak.springliquibasetutorial.jpa.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
