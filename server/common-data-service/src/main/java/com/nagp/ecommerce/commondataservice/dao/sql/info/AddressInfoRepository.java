package com.nagp.ecommerce.commondataservice.dao.sql.info;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagp.ecommerce.commondataservice.entity.sql.info.AddressInfo;

public interface AddressInfoRepository extends JpaRepository<AddressInfo, Integer> {

}
