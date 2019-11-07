package com.experience.tmall.service;
 
import java.util.List;

import com.experience.tmall.pojo.User;

public interface IUserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);

    User get(String name, String password);
}
