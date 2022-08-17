package edu.school21.repositories;

import models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import repositories.ProductsRepository;
import repositories.ProductsRepositoryJdbcImpl;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductsRepositoryJdbcImplTest {
    private DataSource ds;
    private Connection connection;
    private ProductsRepository productsRepository;
    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
        new Product(0L, "Apple iPhone 11", 49990),
        new Product(1L, "Apple MacBook Air M1", 112400),
        new Product(2L, "Apple AirPods Pro", 14999),
        new Product(3L, "Apple iPad Pro", 88250),
        new Product(4L, "Apple MHK23RU", 109999)
    );

    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1L, "Apple MacBook Air M1", 112400);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(2L, "Apple AirPods Pro", 14999);
    final Product EXPECTED_SAVED_PRODUCT = new Product(5L, "HUAWEI P30 Pro", 30920);

    @BeforeEach
    public void init() {
        ds = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql").addScript("data.sql").build();
        productsRepository = new ProductsRepositoryJdbcImpl(ds);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, productsRepository.findById(1L).get());
    }

    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(EXPECTED_SAVED_PRODUCT, productsRepository.findById(5L).get());
    }

    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(EXPECTED_UPDATED_PRODUCT, productsRepository.findById(2L).get());
    }

    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(1l);
        Assertions.assertThrows(RuntimeException.class, () -> productsRepository.findById(1L));
    }


}
