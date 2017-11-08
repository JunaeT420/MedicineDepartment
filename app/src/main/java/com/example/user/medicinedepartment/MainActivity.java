package com.example.user.medicinedepartment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.user.medicinedepartment.Model.Doctorsinfo;
import com.example.user.medicinedepartment.Model.MedicineDoctorAdapter;
import com.example.user.medicinedepartment.interfaces.ApiInterface;
import com.example.user.medicinedepartment.retrofit.RetrofitApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {
    RecyclerView recyclerView;
    List<Doctorsinfo> doctorlist;
    private LinearLayoutManager layoutManager;
    MedicineDoctorAdapter medicineDoctorAdapter;
    private ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        doctorlist = new ArrayList<>();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        getMedicineDoctors();
    }




    public void getMedicineDoctors(){
        apiInterface.getMedicineDoctors().enqueue(new Callback<List<Doctorsinfo>>() {
            @Override
            public void onResponse(Call<List<Doctorsinfo>> call, Response<List<Doctorsinfo>> response) {
                List<Doctorsinfo> doctorsinfoList = response.body();
                Doctorsinfo doctorsinfo=null;
                for (int i=0;i<doctorsinfoList.size();i++){
                    doctorsinfo=new Doctorsinfo();
                    String doc_Name = doctorsinfoList.get(i).getDoctorName();
                    String doc_Qualification=doctorsinfoList.get(i).getDoctorQualification();
                    String doc_Designation=doctorsinfoList.get(i).getDoctorDesignation();
                    doctorsinfo.setDoctorName(doc_Name);
                    doctorsinfo.setDoctorDesignation(doc_Designation);
                    doctorsinfo.setDoctorQualification(doc_Qualification);

                    medicineDoctorAdapter=new MedicineDoctorAdapter(doctorsinfoList);
                    recyclerView.setAdapter(medicineDoctorAdapter);


                }
            }

            @Override
            public void onFailure(Call<List<Doctorsinfo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
