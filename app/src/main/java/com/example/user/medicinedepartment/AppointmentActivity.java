package com.example.user.medicinedepartment;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.medicinedepartment.Model.AppointDoctor;
import com.example.user.medicinedepartment.Model.Doctorsinfo;
import com.example.user.medicinedepartment.interfaces.ApiInterface;
import com.example.user.medicinedepartment.retrofit.RetrofitApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentActivity extends AppCompatActivity {
    TextView doctor_Name, doctor_Qualification, doctor_Designation,
            doctor_expertise, doctor_organization, doctor_chamber, doctor_visiting_Hours,
            doctor_location, doctor_phone, doctor_email;

    private ApiInterface apiInterface;
    private List<Doctorsinfo> doctorsinfoList;
    int position;
public Doctorsinfo doctorsinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        initialize();
          doctorsinfo=new Doctorsinfo();
        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String Qualification = intent.getStringExtra("qualification");
        String Designation = intent.getStringExtra("designation");
        String expertise = intent.getStringExtra("expertise");
        String organization = intent.getStringExtra("organization");
        String chamber = intent.getStringExtra("chamber");
        String visiting_Hours = intent.getStringExtra("visiting_Hours");
        String location = intent.getStringExtra("location");
        String phone = intent.getStringExtra("phone");
        String email = intent.getStringExtra("email");

        doctor_Name.setText(name);
        doctor_Qualification.setText(Qualification);
        doctor_Designation.setText(Designation);
        doctor_expertise.setText(expertise);
        doctor_organization.setText(organization);
        doctor_chamber.setText(chamber);
        doctor_visiting_Hours.setText(visiting_Hours);
        doctor_location.setText(location);
        doctor_phone.setText(phone);
        doctor_email.setText(email);



}


public void appointment(View view){
    final LayoutInflater inflater = getLayoutInflater();
    View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
    final EditText userSerial = (EditText) alertLayout.findViewById(R.id.serial);
    final EditText userName = (EditText) alertLayout.findViewById(R.id.name);
    final EditText userAddress = (EditText) alertLayout.findViewById(R.id.address);
    final EditText userNumber= (EditText) alertLayout.findViewById(R.id.number);
    final EditText userDate = (EditText) alertLayout.findViewById(R.id.time);

    AlertDialog.Builder alert = new AlertDialog.Builder(this);
    alert.setTitle("Insert address");
    alert.setView(alertLayout);
    alert.setCancelable(false);
    alert.setNegativeButton("Cencle", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();

        }
    });

    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);
            AppointDoctor appointDoctor=new AppointDoctor();
            appointDoctor.setPatientSerial(userSerial.getText().toString());
            appointDoctor.setPatientName(userName.getText().toString());
            appointDoctor.setPatientAddress(userAddress.getText().toString());
            appointDoctor.setPatientNumber(userNumber.getText().toString());
            appointDoctor.setPatientDate(userDate.getText().toString());
            Call<AppointDoctor> call=apiInterface.insertPatientInfo(appointDoctor.getPatientSerial(),appointDoctor.getPatientName(),appointDoctor.getPatientAddress(),appointDoctor.getPatientNumber(),appointDoctor.getPatientDate());
            call.enqueue(new Callback<AppointDoctor>() {
                @Override
                public void onResponse(Call<AppointDoctor> call, Response<AppointDoctor> response) {
                    Toast.makeText(AppointmentActivity.this, "response"+response, Toast.LENGTH_LONG).show();


                }

                @Override
                public void onFailure(Call<AppointDoctor> call, Throwable t) {
                    Toast.makeText(AppointmentActivity.this, "response"+t, Toast.LENGTH_LONG).show();
                }
            });


        }
    });

    AlertDialog dialog=alert.create();
    dialog.show();
}

public void serial(View view){

}





public void initialize(){
    doctor_Name = (TextView) findViewById(R.id.doctor_name);
    doctor_Qualification = (TextView) findViewById(R.id.doctor_qualification);
    doctor_Designation = (TextView) findViewById(R.id.doctor_designation);
    doctor_expertise = (TextView) findViewById(R.id.doctor_expertis);
    doctor_organization = (TextView) findViewById(R.id.doctor_organization);
    doctor_chamber = (TextView) findViewById(R.id.doctor_chamber);
    doctor_visiting_Hours = (TextView) findViewById(R.id.doctor_visit);
    doctor_location = (TextView) findViewById(R.id.doctor_location);
    doctor_phone = (TextView) findViewById(R.id.doctor_phone);
    doctor_email = (TextView) findViewById(R.id.doctor_email);

}

}
