package com.nlu.bookonlinebe.services.impl;

import com.nlu.bookonlinebe.models.Order;
import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.repositories.OrderRepository;
import com.nlu.bookonlinebe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;
    @Override
    public ResponseObject getAllOrders() {
        List<Order> orderList = orderRepo.findAll();
        return new ResponseObject("success","Get all order successfull",orderList);
    }
}
