package com.experience.tmall.service;

import java.util.List;

import com.experience.tmall.pojo.Review;

public interface ReviewService {

    void add(Review r);

    void delete(int id);

    void update(Review r);

    Review get(int id);

    List<Review> list(int pid);

    int getCount(int pid);
}