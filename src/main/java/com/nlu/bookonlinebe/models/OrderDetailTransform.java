package com.nlu.bookonlinebe.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderDetailTransform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long orderID;
    private long productID;
    private int quantity;

    public OrderDetailTransform(long orderID, long productID, int quantity){
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }
}
