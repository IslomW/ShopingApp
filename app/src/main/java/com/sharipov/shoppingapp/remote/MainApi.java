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

    //Products
    //popular
    @GET("/v1/popular/")
    Call<ArrayList<Product>> getPopularProduct();

    @GET("/v1/subproduct/{id}/products/")
    Call<ArrayList<Product>> getProductsBySubProduct(@Path("id") int subProductId);


    //Category
    @GET("/v1/classification/")
    Call<ArrayList<Classification>> getClassifications();

    @GET("/v1/classification/{id}/category/")
    Call<ArrayList<Category>> getCategories(@Path("id") int classificationId);


    @GET("/v1/category/{id}/subproduct/")
    Call<ArrayList<SubProduct>> getSubProducts(@Path("id") int categoryId);

    @GET("/v1/product/{id}")
    Call<Product> getProductDetails(@Path("id") int productId);

    //Cart


    @POST("/v1/cart")
    Call<CartResponse> addProductToCart(@Body CartRequest cartRequest);
    @GET("/v1/cart")
    Call<ArrayList<Cart>> getMyCart();

}
