package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
