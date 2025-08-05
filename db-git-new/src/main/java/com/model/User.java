package com.model;


import org.springframework.boot.autoconfigure.domain.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table (name="user_db")
public class User {
    @Id
    private String userName;
    private  String password;
    private String email;
    private String city;


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public User(String userName, String password, String email, String city) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.city = city;
    }
}
