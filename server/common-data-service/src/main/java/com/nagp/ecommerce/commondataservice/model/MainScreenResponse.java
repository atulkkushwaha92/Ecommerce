package com.nagp.ecommerce.commondataservice.model;

import com.nagp.ecommerce.commondataservice.dto.ApparelImagesDTO;
import com.nagp.ecommerce.commondataservice.dto.BrandImagesDTO;
import com.nagp.ecommerce.commondataservice.entity.sql.images.CarouselImages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MainScreenResponse implements Serializable {

    private List<ApparelImagesDTO> apparels;
    private List<CarouselImages> carousels;

    public MainScreenResponse(List<ApparelImagesDTO> apparels,
                              List<CarouselImages> carousels) {
        this.apparels = apparels;
        this.carousels = carousels;
    }
}
