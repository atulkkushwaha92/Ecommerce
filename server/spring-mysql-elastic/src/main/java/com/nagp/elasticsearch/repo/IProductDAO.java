package com.nagp.elasticsearch.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.nagp.elasticsearch.model.Product;

@Repository
public interface IProductDAO extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
}
