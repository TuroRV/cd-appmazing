package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
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
    @GetMapping(value = "/getAll")
    public List<ProductDTO> queryAllProducts(){
        return this.productService.queryAllProducts();
    }
    @PostMapping(value = "/add")
    public int insertProduct(@RequestBody ProductDTO product){
        return this.productService.insertProduct(product);

    }
    @PutMapping(value = "/update")
    public int updateProduct (@RequestBody ProductDTO product){
        return this.productService.updateProduct(product);
    }
    @DeleteMapping(value = "/delete")
    public int deleteProduct (@RequestBody ProductDTO product){
        return this.productService.deleteProduct(product);
    }

    @PutMapping(value = "/buy5")
    public int buyProduct (@RequestBody ProductDTO productDTO){
        int quantity = 5;
        return this.productService.buyProduct(productDTO, quantity);
    }

    @PutMapping(value = "/buy")
    public int buyProduct (@RequestBody Map <String, Integer> body){
        ProductDTO productDTO = new ProductDTO();
        int quantity = body.get("quantity");
        productDTO.setId(body.get("id"));
        return this.productService.buyProduct(productDTO, quantity);
    }
    @PutMapping(value = "/buyandshowprice")
    public BigDecimal buyProductAndShowPrice (@RequestBody ProductDTO productDTO){
        int quantity = 5;
        this.productService.buyProduct(productDTO,quantity);
        return this.productService.calculateTotalPrice(productDTO, quantity);
    }

}
