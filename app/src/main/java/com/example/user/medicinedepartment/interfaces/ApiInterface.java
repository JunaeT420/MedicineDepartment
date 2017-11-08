package com.example.user.medicinedepartment.interfaces;

import com.example.user.medicinedepartment.Model.Doctorsinfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by USER on 11/8/2017.
 */

public interface ApiInterface {

    @GET("/Final_Project/Medicine/Medicine.php")
    Call<List<Doctorsinfo>> getMedicineDoctors();


    @FormUrlEncoded
    @POST("/RetrofitExample/insert.php")
    public void insertUser(
            @Field("serial") String serial,
            @Field("name") String name,
            @Field("address") String address,
            @Field("phone") String phone,
            @Field("time") String time,
            Callback<Response> callback);

}
