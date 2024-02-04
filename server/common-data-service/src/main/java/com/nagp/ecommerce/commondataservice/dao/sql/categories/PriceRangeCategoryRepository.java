package com.nagp.ecommerce.commondataservice.dao.sql.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagp.ecommerce.commondataservice.entity.sql.categories.PriceRangeCategory;

import java.util.List;

public interface PriceRangeCategoryRepository extends JpaRepository<PriceRangeCategory, Integer> {

    @Query(value = "SELECT p FROM PriceRangeCategory p")
    List<PriceRangeCategory> getAllData();

    PriceRangeCategory findByType(String type);
}
