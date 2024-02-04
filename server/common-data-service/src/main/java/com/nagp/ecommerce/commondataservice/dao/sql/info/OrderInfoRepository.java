package com.nagp.ecommerce.commondataservice.dao.sql.info;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagp.ecommerce.commondataservice.entity.sql.info.OrderInfo;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Integer> {
}
