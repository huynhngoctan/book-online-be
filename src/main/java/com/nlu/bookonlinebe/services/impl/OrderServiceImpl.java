package com.nlu.bookonlinebe.services.impl;

import com.nlu.bookonlinebe.models.Order;
import com.nlu.bookonlinebe.models.OrderDetail;
import com.nlu.bookonlinebe.models.Product;
import com.nlu.bookonlinebe.models.ResponseObject;
import com.nlu.bookonlinebe.repositories.OrderRepository;
import com.nlu.bookonlinebe.repositories.ProductRepository;
import com.nlu.bookonlinebe.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepo;
    @Autowired
    ProductRepository productRepo;

    @Override
    public ResponseObject getAllOrders() {
        List<Order> orderList = orderRepo.findAll();
        return new ResponseObject("success", "Get all order successfull", orderList);
    }

    @Override
    public ResponseObject getOrder(long id) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isPresent()) {
            return new ResponseObject("success", "Get order successfull", orderOptional.get());
        } else
            return new ResponseObject("failed", "Order does not exist", "");
    }

    @Override
    public ResponseObject updateOrder(long id, Order newOrder) {
        Optional<Order> orderOptional = orderRepo.findById(id);

        if (!orderOptional.isPresent())
            return new ResponseObject("failed", "Order does not exist", "");

        Order updatedOrder = orderOptional.map(order -> {
            order.setPaymentStatus(newOrder.getPaymentStatus());
            order.setStatus(newOrder.getStatus());
            return orderRepo.save(order);
        }).orElseGet(null);

        if (updatedOrder == null)
            return new ResponseObject("failed", "Update unsuccessfull", "");
        else{
            if(updatedOrder.getStatus().equals("Hoàn thành")){
                this.updateProductStock(updatedOrder);
            }
            return new ResponseObject("success", "Update successfull", updatedOrder);
        }
    }

    private void updateProductStock(Order order){
        for(OrderDetail orderDetail : order.getOrderDetailList()){
           Optional<Product> productOptional =  productRepo.findById(orderDetail.getProduct().getId());
           Product updatedProduct = productOptional.map(product -> {
               product.setStock(product.getStock() - orderDetail.getQuantity());
               return productRepo.save(product);
           }).orElseGet(null);
        }
    }

    @Override
    public ResponseObject deleteOrder(long id) {
        boolean isExist = orderRepo.existsById(id);
        if (isExist) {
            orderRepo.deleteById(id);
            return new ResponseObject("success", "Delete order successfull", "");
        } else {
            return new ResponseObject("failed", "Order's id does not exist", "");
        }

    }

    @Override
    @Transactional
    public ResponseObject createOrder(Order order) {
        Order newOrder = orderRepo.save(order);
        return new ResponseObject("success", "Get all order successfull", newOrder);
    }
}
