package com.tiwari.springtrans.service;


import com.tiwari.springtrans.entities.Product;
import com.tiwari.springtrans.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;


    /*
    * spring transaction only rollback
    * work on unchecked exception
    * */
    @Transactional(propagation = Propagation.REQUIRES_NEW) // transaction start
    public void saveProductInfo() {
//        try {

//        System.out.println("method started");
            for (int i = 1; i <= 10; i++) {
                Product product = new Product();
                product.setId(i);
                product.setName("Test Product " + i);
                productRepo.saveProduct(product);

//                if (i == 7) {
//                    throw new RuntimeException("some error occurred...");
//                }
            }
//        System.out.println("method end");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
    } // commit
}

//Aspect {

    // start your transaction

    // call your method

    // commit transaction

    // close

//}
