package com.nagp.ecommerce.commondataservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import com.nagp.ecommerce.commondataservice.dto.BrandsAndApparelsDTO;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HomeTabsDataResponse implements Serializable {

    private BrandsAndApparelsDTO men;
    private BrandsAndApparelsDTO women;
}