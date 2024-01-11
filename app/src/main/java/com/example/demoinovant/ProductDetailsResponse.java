package com.example.demoinovant;
import com.google.gson.annotations.SerializedName;

public class ProductDetailsResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private ProductDetails data;



    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ProductDetails getData() {
        return data;
    }
}
