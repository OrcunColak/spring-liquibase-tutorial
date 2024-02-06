package com.colak.springliquibasetutorial.repository;

import com.colak.springliquibasetutorial.jpa.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void findAll() {
        List<Order> list = orderRepository.findAll();
        assertThat(list).isEmpty();
    }
}
