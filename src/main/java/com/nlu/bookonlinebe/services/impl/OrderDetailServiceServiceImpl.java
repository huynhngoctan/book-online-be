package com.nlu.bookonlinebe.services.impl;

import com.nlu.bookonlinebe.models.OrderDetail;
import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.repositories.OrderDetailRepository;
import com.nlu.bookonlinebe.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderDetailServiceServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public ResponseObject createOrderDetail(OrderDetail orderDetail) {
        orderDetailRepository.save(orderDetail);
        return new ResponseObject("success", "create successfull", orderDetail);
    }
}
