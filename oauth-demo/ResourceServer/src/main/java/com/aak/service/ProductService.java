package com.aak.service;



import com.aak.entity.Product;

import java.util.List;

public interface ProductService {
    Product findByNameLike(String name);

    List<Product> findAll();

    Product findById(Integer id);
}
