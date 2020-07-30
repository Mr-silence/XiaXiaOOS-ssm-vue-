package com.teskinfly.service;

import com.teskinfly.domain.Orders;

import java.util.Date;
import java.util.List;

public interface IOrderService {
    List<Orders> findAll(int total, int pageNum);

    void addOrder(Orders order);

    Orders findById(Integer oId);

    void changeStatus(String status);

    List<Orders> findByUId(Integer uId);

    void delOrders(Integer oId);

    List<Orders> findByDate(Date beginDate, Date endDate);
}
