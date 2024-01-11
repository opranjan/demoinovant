package com.example.demoinovant;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attribute {

    @SerializedName("value")
    private String value;

    @SerializedName("option_id")
    private String optionId;

    @SerializedName("attribute_image_url")
    private String attributeImageUrl;

    @SerializedName("price")
    private String price;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("color_code")
    private String colorCode;

    @SerializedName("swatch_url")
    private String swatchUrl;



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOptionId() {
        return optionId;
    }

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public String getAttributeImageUrl() {
        return attributeImageUrl;
    }

    public void setAttributeImageUrl(String attributeImageUrl) {
        this.attributeImageUrl = attributeImageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getSwatchUrl() {
        return swatchUrl;
    }

    public void setSwatchUrl(String swatchUrl) {
        this.swatchUrl = swatchUrl;
    }
}
