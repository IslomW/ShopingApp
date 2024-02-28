package com.sharipov.shoppingapp.remote;

import com.sharipov.shoppingapp.model.Banner;
import com.sharipov.shoppingapp.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MainApi {


    //login
@POST("/v1/login/")
    Call<User> login(@Body User user);

@POST("/v1/user/")
    Call<User> createUser(@Body User user);


//banner
    @GET("/v1/banner/")
    Call<ArrayList<Banner>> getBanners();


}
