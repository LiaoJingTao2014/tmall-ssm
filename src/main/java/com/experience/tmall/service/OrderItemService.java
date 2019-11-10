package com.experience.tmall.service;

import java.util.List;

import com.experience.tmall.pojo.Order;
import com.experience.tmall.pojo.OrderItem;

public interface OrderItemService {
    void add(OrderItem oi);

    void delete(int id);

    void update(OrderItem oi);

    OrderItem get(int id);

    List<OrderItem> list();

    void fill(List<Order> os);

    void fill(Order o);

    int getSaleCount(int pid);

    List<OrderItem> listByUser(int uid);
}
