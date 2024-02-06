package com.nagp.elasticsearch.mapper;

import com.nagp.elasticsearch.model.ApparelCategory;
import com.nagp.elasticsearch.model.GenderCategory;
import com.nagp.elasticsearch.model.PriceRangeCategory;
import com.nagp.elasticsearch.model.Product;
import com.nagp.elasticsearch.model.ProductBrandCategory;
import com.nagp.elasticsearch.model.ProductModel;
import com.nagp.elasticsearch.model.dto.ProductDTO;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

	public ProductDTO toProductDTO(Product product) {
		return new ProductDTO(product.getId(), product.getSellerId(), product.getName(),product.getModificationDate(),
	    			product.getProductBrandCategory(),product.getGenderCategory(), product.getApparelCategory(),
	    			product.getPriceRangeCategory(),product.getPrice(),product.getAvailableQuantity(),product.getRatings(),
	    			product.isVerificationStatus(), product.getImageLocalPath(), product.getImageURL(),product.getProductDescription());
		 
	}

    public List<ProductDTO> toProductDtos(List<Product> products){
    	List<ProductDTO> productdto= products.stream().map((product)-> new ProductDTO(product.getId(), product.getSellerId(), product.getName(),product.getModificationDate(),
    			product.getProductBrandCategory(),product.getGenderCategory(), product.getApparelCategory(),
    			product.getPriceRangeCategory(),product.getPrice(),product.getAvailableQuantity(),product.getRatings(),
    			product.isVerificationStatus(), product.getImageLocalPath(), product.getImageURL(),product.getProductDescription())
    	).collect(Collectors.toList());
		return productdto;
    }

    public Product toProduct(ProductDTO productDTO) {
		return null;
    	
    }

    public List<Product> toProducts(List<ProductDTO> ProductDTOS){
		return null;
    	
    }

    public ProductModel toProductModel(Product product) {
    	return new ProductModel(product.getId(), product.getSellerId(), product.getName(),product.getModificationDate(),
    			product.getProductBrandCategory(),product.getGenderCategory(), product.getApparelCategory(),
    			product.getPriceRangeCategory(),product.getPrice(),product.getAvailableQuantity(),product.getRatings(),
    			product.isVerificationStatus(), product.getImageLocalPath(), product.getImageURL(),product.getProductDescription());
    	
    }
}
