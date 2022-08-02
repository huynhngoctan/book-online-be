package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.*;
import com.nlu.bookonlinebe.services.OrderDetailService;
import com.nlu.bookonlinebe.services.OrderService;
import com.nlu.bookonlinebe.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders/details")
@CrossOrigin(origins = "**")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<ResponseObject> createOrderDetail(@RequestBody List<OrderDetailTransform> orderDetailTransformList){
        for (OrderDetailTransform orderD : orderDetailTransformList) {
            Order order = (Order) orderService.getOrder(orderD.getOrderID()).getData();
            Product product = (Product) productService.getProduct(orderD.getProductID()).getData();
            orderDetailService.createOrderDetail(new OrderDetail(order, product, orderD.getQuantity()));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("oke","",""));
    }
}
