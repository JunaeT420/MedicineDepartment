package com.example.user.medicinedepartment.interfaces;

import com.example.user.medicinedepartment.Model.Doctorsinfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by USER on 11/8/2017.
 */

public interface ApiInterface {

    @GET("/Final_Project/Medicine/Medicine.php")
    Call<List<Doctorsinfo>> getMedicineDoctors();

}
