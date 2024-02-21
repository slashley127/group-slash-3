package com.slash3.travelapp.Models;

import com.slash3.travelapp.DTO.LoginAuth;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;




@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
    @NotNull
    @Column(name="user_name")
    private String userName;
    @NotNull
    @Column(name="password")
    private String password;
    @NotNull
    @Column(name="email")
    private String email;
    @NotNull
    @Column(name= "first_name")
    private String firstName;
    @NotNull
    @Column(name= "last_name")
    private String lastName;
//    @Column(name= "trips")
//    private List<Trip> trips;

    private LoginAuth loginAuth;
    public AppUser(String userName, String password, String email, Integer Id, String lastName, String firstName) {
        this.email=email;
        this.userName=userName;
        this.password = password;
        this.userId=Id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public AppUser(String userName, String password, String email, String firstName, String lastName) {
        this.email=email;
        this.userName=userName;
        this.password = password;
        this.firstName=firstName;
        this.lastName=lastName;
    }
    public AppUser(){}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public LoginAuth getLoginAuth() {
        return loginAuth;

    }
}

