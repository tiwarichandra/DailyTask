package com.tiwari.springreadwritedemo.repo;

import com.tiwari.springreadwritedemo.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
