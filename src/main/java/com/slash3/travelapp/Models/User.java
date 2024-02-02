package com.slash3.travelapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.aspectj.bridge.IMessage;

@Table
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    @Column(name="UserId")
    private Integer userId;

    @NotNull
    @Column(name="User_Name")
    private String userName;

    @NotNull
    @Column(name="Password")
    private String password;


    @NotNull
    @Column(name="Email_Id")
    private String email;
    @NotBlank(message="First name is required")
    @Column(name= "First_Name")
    private String firstName;
    @NotBlank(message="Last name is required")
    @Column(name= "Last_Name")
    private String lastName;
    public User(){

    }

    public User(String userName,String password,String email,Integer Id, String lastName, String firstName) {
        this.email=email;
        this.userName=userName;
        this.password = password;
//        this.userId=Id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}





