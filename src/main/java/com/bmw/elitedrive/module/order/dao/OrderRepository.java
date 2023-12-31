package com.bmw.elitedrive.module.order.dao;

import com.bmw.elitedrive.module.order.model.OrderJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderJpa, Long> {
}
