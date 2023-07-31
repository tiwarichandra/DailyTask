package com.tiwari.springreadwritedemo.controller;


import com.tiwari.springreadwritedemo.entities.Product;
import com.tiwari.springreadwritedemo.entities.request.CreateProductModel;
import com.tiwari.springreadwritedemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public List<Product> productList(){

       return productService.getAll();
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody CreateProductModel model){

         productService.create(model);
    }
}
