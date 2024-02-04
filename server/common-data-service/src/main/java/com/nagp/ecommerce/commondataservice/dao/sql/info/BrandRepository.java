package com.nagp.ecommerce.commondataservice.dao.sql.info;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagp.ecommerce.commondataservice.entity.sql.categories.ProductBrandCategory;

public interface BrandRepository extends JpaRepository<ProductBrandCategory, Integer> {


	 @Query(value = "SELECT DISTINCT b FROM ProductBrandCategory b")
	 List<ProductBrandCategory> getAllData();
}
