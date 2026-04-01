package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproducts")
    public Product add(@RequestBody Product p) {
        return service.add(p);
    }

    @GetMapping("getAllProducts")
    public List<Product> getAll() {
        return service.getAll();
    }
    @GetMapping("/getProductById/{pid}")
    public Product getById(@PathVariable Long pid) {
        return service.getProductById(pid);
    }

    @DeleteMapping("/deleteProductById/{pid}")
    public String delete(@PathVariable Long pid) {
        return service.deleteProduct(pid);
    }
}