package com.experience.tmall.service;

import java.util.List;

import com.experience.tmall.pojo.Order;
import com.experience.tmall.pojo.OrderItem;

public interface OrderService {
    String waitPay = "waitPay";
    String waitDelivery = "waitDelivery";
    String waitConfirm = "waitConfirm";
    String waitReview = "waitReview";
    String finish = "finish";
    String delete = "delete";

    void add(Order o);

    float add(Order o, List<OrderItem> ois);

    void delete(int id);

    void update(Order o);

    Order get(int id);

    List<Order> list();

    List<Order> list(int uid, String excludedStatus);
}
