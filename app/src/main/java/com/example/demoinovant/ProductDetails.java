package com.example.demoinovant;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProductDetails {

    @SerializedName("id")
    private String id;

    @SerializedName("sku")
    private String sku;

    @SerializedName("is_return")
    private int isReturn;

    @SerializedName("name")
    private String name;

    @SerializedName("attribute_set_id")
    private String attributeSetId;

    @SerializedName("price")
    private String price;

    @SerializedName("final_price")
    private String finalPrice;

    @SerializedName("status")
    private String status;

    @SerializedName("type")
    private String type;

    @SerializedName("web_url")
    private String webUrl;

    @SerializedName("brand_name")
    private String brandName;

    @SerializedName("brand")
    private String brand;

    @SerializedName("is_following_brand")
    private int isFollowingBrand;

    @SerializedName("brand_banner_url")
    private String brandBannerUrl;

    @SerializedName("is_salable")
    private boolean isSalable;

    @SerializedName("is_new")
    private int isNew;

    @SerializedName("is_sale")
    private int isSale;

    @SerializedName("is_trending")
    private int isTrending;

    @SerializedName("is_best_seller")
    private int isBestSeller;

    @SerializedName("image")
    private String image;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("weight")
    private String weight;

    @SerializedName("description")
    private String description;

    @SerializedName("configurable_option")
    private List<ConfigurableOption> configurableOption;

    @SerializedName("images")
    private List<String> images;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(int isReturn) {
        this.isReturn = isReturn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeSetId() {
        return attributeSetId;
    }

    public void setAttributeSetId(String attributeSetId) {
        this.attributeSetId = attributeSetId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getIsFollowingBrand() {
        return isFollowingBrand;
    }

    public void setIsFollowingBrand(int isFollowingBrand) {
        this.isFollowingBrand = isFollowingBrand;
    }

    public String getBrandBannerUrl() {
        return brandBannerUrl;
    }

    public void setBrandBannerUrl(String brandBannerUrl) {
        this.brandBannerUrl = brandBannerUrl;
    }

    public boolean isSalable() {
        return isSalable;
    }

    public void setSalable(boolean salable) {
        isSalable = salable;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getIsSale() {
        return isSale;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
    }

    public int getIsTrending() {
        return isTrending;
    }

    public void setIsTrending(int isTrending) {
        this.isTrending = isTrending;
    }

    public int getIsBestSeller() {
        return isBestSeller;
    }

    public void setIsBestSeller(int isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ConfigurableOption> getConfigurableOption() {
        return configurableOption;
    }

    public void setConfigurableOption(List<ConfigurableOption> configurableOption) {
        this.configurableOption = configurableOption;
    }


    public List<String> getImages() {
        return images;
    }
}

