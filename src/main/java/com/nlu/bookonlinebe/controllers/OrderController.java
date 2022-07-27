package com.nlu.bookonlinebe.controllers;

import com.nlu.bookonlinebe.models.Order;
import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getOrder(@PathVariable("id") long id) {
        ResponseObject result = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateOrder(
            @PathVariable("id") long id, @RequestBody Order order
    ) {
        ResponseObject result = orderService.updateOrder(id, order);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteOrder(@PathVariable("id") long id) {
        ResponseObject result = orderService.deleteOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
