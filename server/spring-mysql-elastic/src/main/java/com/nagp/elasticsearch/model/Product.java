package com.nagp.elasticsearch.model;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Table(name="product_info")
public class Product {
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public ProductBrandCategory getProductBrandCategory() {
		return productBrandCategory;
	}

	public void setProductBrandCategory(ProductBrandCategory productBrandCategory) {
		this.productBrandCategory = productBrandCategory;
	}

	public GenderCategory getGenderCategory() {
		return genderCategory;
	}

	public void setGenderCategory(GenderCategory genderCategory) {
		this.genderCategory = genderCategory;
	}

	public ApparelCategory getApparelCategory() {
		return apparelCategory;
	}

	public void setApparelCategory(ApparelCategory apparelCategory) {
		this.apparelCategory = apparelCategory;
	}

	public PriceRangeCategory getPriceRangeCategory() {
		return priceRangeCategory;
	}

	public void setPriceRangeCategory(PriceRangeCategory priceRangeCategory) {
		this.priceRangeCategory = priceRangeCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public boolean isVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getImageLocalPath() {
		return imageLocalPath;
	}

	public void setImageLocalPath(String imageLocalPath) {
		this.imageLocalPath = imageLocalPath;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

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

    @ManyToOne
    @JoinColumn(name = "gender_id")
    @JsonIgnore
    private GenderCategory genderCategory;

    @ManyToOne
    @JoinColumn(name = "apparel_id")
    @JsonIgnore
    private ApparelCategory apparelCategory;

    @ManyToOne
    @JoinColumn(name = "price_id")
    @JsonIgnore
    private PriceRangeCategory priceRangeCategory;

    private double price;

    private int availableQuantity;

    private float ratings;

    private boolean verificationStatus;

    private String imageLocalPath;

    private String imageURL;
    
    private String productDescription;
    
    public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Product() {
        // do nothing
    }


}
