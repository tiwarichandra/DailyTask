package com.tiwari.springreadwritedemo.service;

import com.tiwari.springreadwritedemo.entities.Product;
import com.tiwari.springreadwritedemo.entities.request.CreateProductModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    void create(CreateProductModel model);

    @Transactional(readOnly = true)
    List<Product> getAll();
}
