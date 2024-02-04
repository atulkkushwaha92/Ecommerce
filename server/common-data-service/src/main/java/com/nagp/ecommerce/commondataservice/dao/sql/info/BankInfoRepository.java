package com.nagp.ecommerce.commondataservice.dao.sql.info;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagp.ecommerce.commondataservice.entity.sql.info.BankInfo;

public interface BankInfoRepository extends JpaRepository<BankInfo, Integer> {

}
