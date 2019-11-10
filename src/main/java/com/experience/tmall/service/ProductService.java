package com.experience.tmall.service;

import java.util.List;

import com.experience.tmall.pojo.Product;

public interface ProductService {
    void add(Product p);

    void delete(int id);

    void update(Product p);

    Product get(int id);

    List<Product> list(int cid);

    void setFirstProductImage(Product p);
}
