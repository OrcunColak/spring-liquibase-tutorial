package com.colak.springliquibasetutorial.repository;

import com.colak.springliquibasetutorial.jpa.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
