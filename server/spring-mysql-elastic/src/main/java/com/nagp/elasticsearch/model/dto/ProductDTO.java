package com.nagp.elasticsearch.model.dto;

import java.util.Date;
import com.nagp.elasticsearch.model.ApparelCategory;
import com.nagp.elasticsearch.model.GenderCategory;
import com.nagp.elasticsearch.model.PriceRangeCategory;
import com.nagp.elasticsearch.model.ProductBrandCategory;

public class ProductDTO {
    private int id;

	public ProductDTO(int id, int sellerId, String name, Date modificationDate,
			ProductBrandCategory productBrandCategoryObj, GenderCategory genderCategoryObj, ApparelCategory apparelCategoryObj,
			PriceRangeCategory priceRangeCategoryObj, double price, int availableQuantity, float ratings,
			boolean verificationStatus, String imageLocalPath, String imageURL, String productDescription) {
		super();
		this.id = id;
		this.sellerId = sellerId;
		this.name = name;
		this.modificationDate = modificationDate;
		this.productBrandCategoryId = productBrandCategoryObj.getId();
		this.productBrandCategory = productBrandCategoryObj.getType();
		this.genderCategoryId = genderCategoryObj.getId();
		this.genderCategory = genderCategoryObj.getType();
		this.apparelCategoryId = apparelCategoryObj.getId();
		this.apparelCategory = apparelCategoryObj.getType();
		this.priceRangeCategoryId = priceRangeCategoryObj.getId();
		this.priceRangeCategory = priceRangeCategoryObj.getType();
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.ratings = ratings;
		this.verificationStatus = verificationStatus;
		this.imageLocalPath = imageLocalPath;
		this.imageURL = imageURL;
		this.productDescription= productDescription;}
    
	private int sellerId;
    private String name;
    private Date modificationDate;
    private int productBrandCategoryId;
	private String productBrandCategory;
	private int genderCategoryId;
    private String genderCategory;
	private int apparelCategoryId;
    private String apparelCategory;
    private int priceRangeCategoryId;
    private String priceRangeCategory;
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

	public ProductDTO() {
        // do nothing
    }
    
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

	public int getGenderCategoryId() {
		return genderCategoryId;
	}

	public void setGenderCategoryId(int genderCategoryId) {
		this.genderCategoryId = genderCategoryId;
	}

	public int getApparelCategoryId() {
		return apparelCategoryId;
	}

	public void setApparelCategoryId(int apparelCategoryId) {
		this.apparelCategoryId = apparelCategoryId;
	}

	public int getPriceRangeCategoryId() {
		return priceRangeCategoryId;
	}

	public void setPriceRangeCategoryId(int priceRangeCategoryId) {
		this.priceRangeCategoryId = priceRangeCategoryId;
	}

	public void setGenderCategory(String genderCategory) {
		this.genderCategory = genderCategory;
	}

	public void setApparelCategory(String apparelCategory) {
		this.apparelCategory = apparelCategory;
	}

	public void setPriceRangeCategory(String priceRangeCategory) {
		this.priceRangeCategory = priceRangeCategory;
	}

	public int getProductBrandCategoryId() {
		return productBrandCategoryId;
	}

	public void setProductBrandCategoryId(int productBrandCategoryId) {
		this.productBrandCategoryId = productBrandCategoryId;
	}

	public String getGenderCategory() {
		return genderCategory;
	}

	public String getApparelCategory() {
		return apparelCategory;
	}

	public String getPriceRangeCategory() {
		return priceRangeCategory;
	}

	public void setProductBrandCategory(String productBrandCategory) {
		this.productBrandCategory = productBrandCategory;
	}

	 public String getProductBrandCategory() {
			return productBrandCategory;
	}


}
