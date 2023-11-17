package com.bmw.elitedrive.module.order.dao;

import com.bmw.elitedrive.module.order.model.OrderExtrasJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderExtrasRepository extends JpaRepository<OrderExtrasJpa, Long> {
    List<OrderExtrasJpa> findByOrderId(Long orderId);
}
