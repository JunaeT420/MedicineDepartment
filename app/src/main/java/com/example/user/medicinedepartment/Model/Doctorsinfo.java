package com.example.user.medicinedepartment.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 11/8/2017.
 */

public class Doctorsinfo {
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("qualification")
    @Expose
    private String doctorQualification;
    @SerializedName("designation")
    @Expose
    private String doctorDesignation;
    @SerializedName("expertise")
    @Expose
    private String doctorExpertise;
    @SerializedName("organization")
    @Expose
    private String doctorOrganization;
    @SerializedName("chamber")
    @Expose
    private String doctorChamber;
    @SerializedName("visiting_Hours")
    @Expose
    private String doctorVisiting_Hours;
    @SerializedName("location")
    @Expose
    private String doctorLocationn;
    @SerializedName("phone")
    @Expose
    private String doctorPhone;
    @SerializedName("email")
    @Expose
    private String doctorEmail;


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorQualification() {
        return doctorQualification;
    }

    public void setDoctorQualification(String doctorQualification) {
        this.doctorQualification = doctorQualification;
    }

    public String getDoctorDesignation() {
        return doctorDesignation;
    }

    public void setDoctorDesignation(String doctorDesignation) {
        this.doctorDesignation = doctorDesignation;
    }

    public String getDoctorExpertise() {
        return doctorExpertise;
    }

    public void setDoctorExpertise(String doctorExpertise) {
        this.doctorExpertise = doctorExpertise;
    }

    public String getDoctorOrganization() {
        return doctorOrganization;
    }

    public void setDoctorOrganization(String doctorOrganization) {
        this.doctorOrganization = doctorOrganization;
    }

    public String getDoctorChamber() {
        return doctorChamber;
    }

    public void setDoctorChamber(String doctorChamber) {
        this.doctorChamber = doctorChamber;
    }

    public String getDoctorVisiting_Hours() {
        return doctorVisiting_Hours;
    }

    public void setDoctorVisiting_Hours(String doctorVisiting_Hours) {
        this.doctorVisiting_Hours = doctorVisiting_Hours;
    }

    public String getDoctorLocationn() {
        return doctorLocationn;
    }

    public void setDoctorLocationn(String doctorLocationn) {
        this.doctorLocationn = doctorLocationn;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }
}
