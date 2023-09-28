package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping
    public String testController(){
        return "Product Controller works";
    }

    @PostMapping
    public String testControllerBody(@RequestBody String name){
        return "Product Controller works, " + name + "!";
    }
    @GetMapping(value = "/testMethod")
    public String testControllerMethod(){
        return "Product controller method works!";
    }

    @PostMapping(value = "/get")
    public ProductDTO queryProduct (@RequestBody ProductDTO product){
        return this.productService.queryProduct(product);

    }

}
