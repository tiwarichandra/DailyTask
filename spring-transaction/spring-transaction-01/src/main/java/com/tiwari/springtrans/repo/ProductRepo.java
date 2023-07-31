package com.tiwari.springtrans.repo;


import com.tiwari.springtrans.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional // by default use required which use same connection to all data store
//    @Transactional(propagation = Propagation.REQUIRES_NEW) // it suspend old transaction and looking for new connection
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveProduct(Product product) {

        String sql = "INSERT INTO PRODUCT VALUES (?, ?)";

        Object[] args = {product.getId(), product.getName()};

        jdbcTemplate.update(sql, args);
        System.out.println("Product saved...");
    }
}
