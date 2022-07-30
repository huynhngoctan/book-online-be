package com.nlu.bookonlinebe.services;

import com.nlu.bookonlinebe.models.OrderDetail;
import com.nlu.bookonlinebe.models.ResponseObject;

public interface OrderDetailService {
    public ResponseObject createOrderDetail(OrderDetail orderDetail);
}
