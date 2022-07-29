package com.nlu.bookonlinebe.services;

import com.nlu.bookonlinebe.models.Order;
import com.nlu.bookonlinebe.models.ResponseObject;

public interface OrderService {
    public ResponseObject getAllOrders();
    public ResponseObject getOrder(long id);
    public ResponseObject updateOrder(long id, Order newOrder);
    public ResponseObject deleteOrder(long id);
    public ResponseObject createOrder(Order order);
}
