package com.tiwari.springtrans;

import com.tiwari.springtrans.config.ProductConfig;
import com.tiwari.springtrans.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringTransaction01Application {

    public static void main(String[] args) {
//        SpringApplication.run(SpringTransaction01Application.class, args);

        ConfigurableApplicationContext configurableApplicationContext = new AnnotationConfigApplicationContext(ProductConfig.class);
        configurableApplicationContext.registerShutdownHook();
        ProductService productService = configurableApplicationContext.getBean("productService", ProductService.class);
        productService.saveProductInfo();
        configurableApplicationContext.close();
    }

}
