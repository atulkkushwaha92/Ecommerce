package com.nagp.elasticsearch.service.impl;

import com.nagp.elasticsearch.mapper.ProductMapper;
import com.nagp.elasticsearch.model.Product;
import com.nagp.elasticsearch.model.dto.ProductDTO;
import com.nagp.elasticsearch.repo.IProductDAO;
import com.nagp.elasticsearch.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductDAO productDAO;
    private ProductMapper productMapper = new ProductMapper();

    @Autowired
    public ProductService(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = this.productDAO.save(this.productMapper.toProduct(productDTO));
        return productMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO findById(Integer id) {
        return this.productMapper.toProductDTO(this.productDAO.findById(id).orElse(null));
    }

    @Override
    public List<ProductDTO> findAll() {
        return this.productMapper.toProductDtos(this.productDAO.findAll());
    }
}
