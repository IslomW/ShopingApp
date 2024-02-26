package com.sharipov.shoppingapp.remote;

import com.sharipov.shoppingapp.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MainApi {


    //login
@POST("/v1/login/")
    Call<User> login(@Body User user);

@POST("/v1/user/")
    Call<User> createUser(@Body User user);


}
