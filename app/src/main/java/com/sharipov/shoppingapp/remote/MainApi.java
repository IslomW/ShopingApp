package com.sharipov.shoppingapp.remote;

import com.sharipov.shoppingapp.model.Banner;
import com.sharipov.shoppingapp.model.Category;
import com.sharipov.shoppingapp.model.Classification;
import com.sharipov.shoppingapp.model.Product;
import com.sharipov.shoppingapp.model.SubProduct;
import com.sharipov.shoppingapp.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MainApi {


    //login
    @POST("/v1/login/")
    Call<User> login(@Body User user);

    @POST("/v1/user/")
    Call<User> createUser(@Body User user);


    //banner
    @GET("/v1/banner/")
    Call<ArrayList<Banner>> getBanners();

     //Classification
    @GET("/v1/classification")
    Call<ArrayList<Classification>> getClassification();

    //Popular Product
    @GET("/v1/popular/")
    Call<ArrayList<Product>> getPopularProduct();



    //Category
    @GET("/v1/classification/")
    Call<ArrayList<Classification>> getClassifications();

    @GET("/v1/classification/{id}/category/")
    Call<ArrayList<Category>> getCategories(@Path("id") int classificationId);


    @GET("/v1/category/{id}/subproduct/")
    Call<ArrayList<SubProduct>> getSubProducts(@Path("id") int categoryId);

}
