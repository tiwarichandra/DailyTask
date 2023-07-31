package com.tiwari.springreadwritedemo.service;


import com.tiwari.springreadwritedemo.entities.Product;
import com.tiwari.springreadwritedemo.entities.request.CreateProductModel;
import com.tiwari.springreadwritedemo.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void create(CreateProductModel model) {
        Product productToBeSaved = new Product();
        productToBeSaved.setName(model.getName());
        productRepository.save(productToBeSaved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }
}
