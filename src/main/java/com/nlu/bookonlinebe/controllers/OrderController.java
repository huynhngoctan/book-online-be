package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllOrders() {
        ResponseObject result = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
