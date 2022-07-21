package com.nlu.bookonlinebe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customer;
    private String address;
    private String phone;
    private Date createdDate;
    private String paymentStatus;
    private String status;
    private double shipPrice;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
    @Transient
    private double totalPrice;

    public Order(String customer, String address, String phone, Date createdDate, String paymentStatus, String status, double shipPrice) {
        this.customer = customer;
        this.address = address;
        this.phone = phone;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
        this.status = status;
        this.shipPrice = shipPrice;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for(OrderDetail orderDetail : orderDetailList){
            totalPrice+=orderDetail.getOrderDetailPrice();
        }
        totalPrice+=shipPrice;
        return totalPrice;
    }
}
