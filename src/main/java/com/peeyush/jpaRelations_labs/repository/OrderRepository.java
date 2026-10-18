package com.peeyush.jpaRelations_labs.repository;

import com.peeyush.jpaRelations_labs.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("""
SELECT o
FROM Order o
JOIN FETCH o.user
""")
    Page<Order> findOrdersWithUser(Pageable pageable);
}
