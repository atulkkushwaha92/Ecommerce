package com.nagp.ecommerce.commondataservice.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

import com.nagp.ecommerce.commondataservice.entity.sql.info.ProductInfo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductInfoDTO implements Serializable {

    private Long totalCount;
    private List<ProductInfo> products;
}