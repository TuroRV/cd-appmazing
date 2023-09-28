package com.campusdual.appmazing.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public String testController(){
        return "Product Controller works";
    }

    @PostMapping
    public String testControllerBody(@RequestBody String name){
        return "Product Controller works, " + name + "!";
    }

}
