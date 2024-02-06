package com.nagp.elasticsearch.repo.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nagp.elasticsearch.model.ProductModel;

public interface IProductESRepo extends ElasticsearchRepository<ProductModel, Long> {
}
