package com.nagp.ecommerce.commondataservice.dao.sql.info;

import com.nagp.ecommerce.commondataservice.dto.SearchSuggestionForThreeAttrDTO;
import com.nagp.ecommerce.commondataservice.dto.SearchSuggestionForTwoAttrDTO;
import com.nagp.ecommerce.commondataservice.entity.sql.info.ProductInfo;
import com.nagp.ecommerce.commondataservice.model.FilterAttributesResponse;
import com.nagp.ecommerce.commondataservice.model.HomeTabsDataResponse;

import org.javatuples.Pair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, Integer> {

    Pair<Long, List<ProductInfo>> getProductsByCategories(HashMap<String, String> conditionMap);

    List<ProductInfo> getProductsById(String[] productIds);

    FilterAttributesResponse getFilterAttributesByProducts(HashMap<String, String> conditionMap);

    HomeTabsDataResponse getBrandsAndApparelsByGender();

    List<SearchSuggestionForThreeAttrDTO> getGenderApparelBrandByIdAndName();

    List<SearchSuggestionForTwoAttrDTO> getGenderAndApparelByIdAndName();

    List<SearchSuggestionForTwoAttrDTO> getGenderAndBrandByIdAndName();

    List<SearchSuggestionForTwoAttrDTO> getApparelAndBrandByIdAndName();

    @Query(value = "SELECT DISTINCT p.name FROM ProductInfo p")
    List<String> getProductByName();
}
