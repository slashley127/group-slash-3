package com.slash3.travelapp.DTO;
public class AppUserDTO {
    public Integer userId;
    public String userName;
    public String password;
    public String email;
    public String firstName;
    public String lastName;

    // Constructors
    public AppUserDTO() {
    }

    public AppUserDTO(Integer userId, String userName, String password, String email, String firstName, String lastName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public AppUserDTO(String userName, String password, String email, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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