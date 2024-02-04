package com.nagp.ecommerce.commondataservice.entity.sql.info;

import com.fasterxml.jackson.annotation.*;
import com.nagp.ecommerce.commondataservice.entity.sql.categories.ApparelCategory;
import com.nagp.ecommerce.commondataservice.entity.sql.categories.GenderCategory;
import com.nagp.ecommerce.commondataservice.entity.sql.categories.PriceRangeCategory;
import com.nagp.ecommerce.commondataservice.entity.sql.categories.ProductBrandCategory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(indexes = {@Index(columnList = "gender_id, apparel_id, brand_id, price")})
public class ProductInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sellerId;

    private String name;
    
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date modificationDate;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private ProductBrandCategory productBrandCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    @JsonIgnore
    private GenderCategory genderCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apparel_id")
    @JsonIgnore
    private ApparelCategory apparelCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    @JsonIgnore
    private PriceRangeCategory priceRangeCategory;

    private double price;

    private int availableQuantity;

    private float ratings;

    private boolean verificationStatus;

    private String imageLocalPath;

    @OneToMany(mappedBy = "orderInfo")
    @JsonIgnore
    private List<OrderInfo> orders;

    private String imageURL;
    
    private String productDescription;

    public ProductInfo(int sellerId, String name, Date modificationDate, ProductBrandCategory productBrandCategory,
                       GenderCategory genderCategory, ApparelCategory apparelCategory,
                       PriceRangeCategory priceRangeCategory,
                       double price, int availableQuantity,  float ratings,
                       boolean verificationStatus, String imageLocalPath, String imageURL,String productDescription) {
        this.sellerId = sellerId;
        this.name = name;
        this.modificationDate = modificationDate;
        this.productBrandCategory = productBrandCategory;
        this.genderCategory = genderCategory;
        this.apparelCategory = apparelCategory;
        this.priceRangeCategory = priceRangeCategory;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.ratings = ratings;
        this.verificationStatus = verificationStatus;
        this.imageLocalPath = imageLocalPath;
        this.imageURL = imageURL;
        this.productDescription = productDescription;
    }
}
