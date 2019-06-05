package com.aak.controller;



import com.aak.entity.Product;
import com.aak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ahmed on 30.5.18.
 */

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> products() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/search/")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public Product findByName(@RequestParam("name") String name) {
        return productService.findByNameLike("%" + name + "%");
    }
    @GetMapping("/products")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public List<Product> findAll() {
        return productService.findAll();
    }
}
