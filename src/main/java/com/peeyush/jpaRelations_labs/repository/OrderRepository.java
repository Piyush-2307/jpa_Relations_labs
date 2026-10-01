package com.peeyush.jpaRelations_labs.repository;

import com.peeyush.jpaRelations_labs.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
