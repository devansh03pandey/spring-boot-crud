package com.java.crud.example.controller;

import com.java.crud.example.entity.Product;
import com.java.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;
@PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    @PostMapping("/addproduct")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProduct(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProduct();
    }
    @GetMapping("/products{id}")
    public Product findProductById(@PathVariable int id) {

    return service.getProductBYId(id);
    }
    @GetMapping("/products{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductBYName(name);
    }
@PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {

    return service.updateProduct(product);
    }
    @DeleteMapping("/delete{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }



}
