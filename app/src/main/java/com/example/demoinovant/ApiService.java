package com.example.demoinovant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("productdetails/{productId}/{storeId}")
    Call<ProductDetailsResponse> getProductDetails(
            @Path("productId") String productId,
            @Path("storeId") String storeId,
            @Query("lang") String lang,
            @Query("store") String store
    );

}
