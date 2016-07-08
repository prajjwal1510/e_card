package com.App.Modal;

import java.io.InputStream;

/**
 * Created by forteeninches on 8/07/16.
 */
public class Person {

    String id;
    String firstName;
    String lastName;
    String city;
    String district;
    String program;
    String validityDate;
    String rollNumber;
    String createdDate;
    String updatedDate;
    String photo;
    String batch;

    public Person(String firstName, String lastName, String city, String district, String program, String validityDate, String rollNumber,String photo,String batch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.district = district;
        this.program = program;
        this.validityDate = validityDate;
        this.rollNumber = rollNumber;
        this.photo = photo;
        this.batch = batch;
    }

    public Person() {
    }

    public String getId(){
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getProgram() {
        return program;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public String getPhoto(){
        return photo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

}
