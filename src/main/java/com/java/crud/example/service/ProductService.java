package com.java.crud.example.service;
import com.java.crud.example.entity.Product;
import com.java.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProduct(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProduct() {
        return repository.findAll();
    }

    public Product getProductBYId(int id) {
        return (Product) repository.findAllById(Collections.singleton(id));
    }

    public Product getProductBYName(String name) {
        return repository.findByName(name);
    }
    public String deleteProduct(int id) {
        repository.deleteAllById(Collections.singleton(id));
        return "product removed || " + id;
    }
    public Product updateProduct(Product product){
        Product existingProduct= (Product) repository.findAllById(Collections.singleton(product.getId()));
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}