package com.slash3.travelapp.Models;


import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.util.Objects;
@Entity
public class Traveler {

    @Id
    public int id;
    public String name;
    public String username;
    public String email;
    public String password;

    public Traveler(int id, String name, String username, String email, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Traveler traveler = (Traveler) o;
        return id == traveler.id && Objects.equals(name, traveler.name) && Objects.equals(username, traveler.username) && Objects.equals(email, traveler.email) && Objects.equals(password, traveler.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, email, password);
    }
}
