package com.colak.springtutorial.repository;

import com.colak.springtutorial.jpa.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findAll() {
        List<Customer> list = customerRepository.findAll();
        assertThat(list).isEmpty();
    }
}
