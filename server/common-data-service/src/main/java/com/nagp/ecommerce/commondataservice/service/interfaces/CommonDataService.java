package com.nagp.ecommerce.commondataservice.service.interfaces;

import com.nagp.ecommerce.commondataservice.dto.ProductInfoDTO;
import com.nagp.ecommerce.commondataservice.entity.sql.info.ProductInfo;
import com.nagp.ecommerce.commondataservice.model.FilterAttributesResponse;
import com.nagp.ecommerce.commondataservice.model.HomeTabsDataResponse;
import com.nagp.ecommerce.commondataservice.model.MainScreenResponse;
import com.nagp.ecommerce.commondataservice.model.SearchSuggestionResponse;

import java.util.HashMap;
import java.util.List;

public interface CommonDataService {

    MainScreenResponse getHomeScreenData(String apiName);

    FilterAttributesResponse getFilterAttributesByProducts(String queryParams);

    ProductInfoDTO getProductsByCategories(String queryParams);

    HashMap<Integer, ProductInfo> getProductsById(String queryParams);

    HomeTabsDataResponse getBrandsAndApparelsByGender(String apiName);

    SearchSuggestionResponse getSearchSuggestionList();
}

