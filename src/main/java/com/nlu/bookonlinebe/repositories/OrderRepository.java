package com.nlu.bookonlinebe.repositories;

import com.nlu.bookonlinebe.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findFirstByOrderByIdDesc();
}
