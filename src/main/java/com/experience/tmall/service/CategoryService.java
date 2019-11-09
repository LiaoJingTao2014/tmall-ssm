package com.experience.tmall.service;

import java.util.List;

import com.experience.tmall.pojo.Category;

public interface CategoryService {

    List<Category> list();

    void add(Category category);

    void delete(int id);

    Category get(int id);

    void update(Category category);
}
