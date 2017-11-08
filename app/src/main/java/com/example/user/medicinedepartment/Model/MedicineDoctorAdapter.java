package com.example.user.medicinedepartment.Model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.medicinedepartment.AppointmentActivity;
import com.example.user.medicinedepartment.R;

import java.util.List;

/**
 * Created by USER on 11/8/2017.
 */

public class MedicineDoctorAdapter extends RecyclerView.Adapter<MedicineDoctorAdapter.MyViewHolder>{
    private List<Doctorsinfo> doctorsinfoList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View iView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);
        return new MyViewHolder(iView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Doctorsinfo doctorsinfo=doctorsinfoList.get(position);
        holder.latTextview.setText(doctorsinfo.getDoctorName());
        holder.longTextView.setText(doctorsinfo.getDoctorQualification());
        holder.timeTextview.setText(doctorsinfo.getDoctorDesignation());

    }

    @Override
    public int getItemCount() {
        return doctorsinfoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView latTextview,longTextView,timeTextview;

        public MyViewHolder(View itemView) {
            super(itemView);
            latTextview= (TextView) itemView.findViewById(R.id.tv_name);
            longTextView= (TextView) itemView.findViewById(R.id.tv_qualification);
            timeTextview= (TextView) itemView.findViewById(R.id.tv_designation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /**/
                    final int position = getAdapterPosition();
                    Log.e("position"," pos"+position);

                    Context context=v.getContext();
                    Intent intent = new Intent(context, AppointmentActivity.class);
                    intent.putExtra("Name",doctorsinfoList.get(position).getDoctorName());
                    intent.putExtra("qualification",doctorsinfoList.get(position).getDoctorQualification());
                    intent.putExtra("designation",doctorsinfoList.get(position).getDoctorDesignation());
                    intent.putExtra("expertise",doctorsinfoList.get(position).getDoctorExpertise());
                    intent.putExtra("organization",doctorsinfoList.get(position).getDoctorOrganization());
                    intent.putExtra("chamber",doctorsinfoList.get(position).getDoctorChamber());
                    intent.putExtra("visiting_Hours",doctorsinfoList.get(position).getDoctorVisiting_Hours());
                    intent.putExtra("location",doctorsinfoList.get(position).getDoctorLocationn());
                    intent.putExtra("phone",doctorsinfoList.get(position).getDoctorPhone());
                    intent.putExtra("email",doctorsinfoList.get(position).getDoctorEmail());

                    // intent.putExtras(extras);
                    context.startActivity(intent);


                }
            });

        }


    }
    public MedicineDoctorAdapter(List<Doctorsinfo> doctorsinfoList) {
        this.doctorsinfoList = doctorsinfoList;
    }


}



