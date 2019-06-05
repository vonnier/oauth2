package com.aak.service.impl;


import com.aak.dao.ProductMapper;
import com.aak.entity.Product;
import com.aak.entity.ProductExample;
import com.aak.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product findByNameLike(String name){
        ProductExample example = new ProductExample();
        example.createCriteria().andNameEqualTo(name);
        List<Product> list = productMapper.selectByExample(example);
        if (list == null || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Product> findAll(){
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);

    }

    @Override
    public Product findById(Integer id){
        ProductExample example = new ProductExample();
        example.createCriteria().andIdEqualTo(id);
        List<Product> list = productMapper.selectByExample(example);
        if (list == null || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }
}
