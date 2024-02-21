package com.slash3.travelapp.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class LoginAuth{
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @NotNull
    private String email;

    @NotNull
    private String pwHash;

    public LoginAuth() {
    }

    public LoginAuth(String email, String password) {
        this.email = email;
        this.pwHash = encoder.encode(password);
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}