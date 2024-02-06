package com.colak.springliquibasetutorial.repository;

import com.colak.springliquibasetutorial.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
