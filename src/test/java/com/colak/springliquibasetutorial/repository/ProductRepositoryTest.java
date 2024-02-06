package com.colak.springliquibasetutorial.repository;

import com.colak.springliquibasetutorial.jpa.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findAll() {
        List<Product> list = productRepository.findAll();
        assertThat(list).isEmpty();
    }
}
