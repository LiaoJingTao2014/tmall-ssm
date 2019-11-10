package com.experience.tmall.service;

import java.util.List;

import com.experience.tmall.pojo.User;

public interface UserService {
    void add(User u);

    void delete(int id);

    void update(User u);

    User get(int id);

    List<User> list();

    boolean isExist(String name);

    User get(String name, String password);
}
