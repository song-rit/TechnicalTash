package com.example.awidcha.technicaltask.model;

/**
 * Created by Awidcha on 23/6/2560.
 */

public class UserModel {

    private int id;
    private String fullName;
    private String nickName;
    private String address;
    private String phoneNumber;
    private String photo;
    private String qualification;
    private String experience;
    private String email;
    private String dob;
    private String anniversary;
    private String facebook;
    private String linkedInLink;
    private String currentLocation;

    public UserModel() {
    }

    public UserModel(int id, String name, String nickName, String address, String phoneNumber, String photo, String qualification, String experience, String email, String dob, String anniversary, String facebook, String linkedInLink, String currentLocation) {
        this.id = id;
        this.fullName = name;
        this.nickName = nickName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.qualification = qualification;
        this.experience = experience;
        this.email = email;
        this.dob = dob;
        this.anniversary = anniversary;
        this.facebook = facebook;
        this.linkedInLink = linkedInLink;
        this.currentLocation = currentLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedInLink() {
        return linkedInLink;
    }

    public void setLinkedInLink(String linkedInLink) {
        this.linkedInLink = linkedInLink;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}
