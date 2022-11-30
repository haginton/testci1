package com.test.mongo.mongotest.dto;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.security.SecureRandom;
import java.time.LocalDate;

public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fullName;
    private String email;
    private String password;
    private LocalDate birthDate;

    public UserDto() {
    }

    public UserDto(String fullName, String email, String password, LocalDate birthDate) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
