package com.nagp.elasticsearch.service;

import java.util.List;

import com.nagp.elasticsearch.model.dto.ProductDTO;

public interface IProductService {
    ProductDTO save(ProductDTO productDTO);
    ProductDTO findById(Integer id);
    List<ProductDTO> findAll();
}
