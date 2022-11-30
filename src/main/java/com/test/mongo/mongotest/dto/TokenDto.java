package com.test.mongo.mongotest.dto;

import java.io.Serializable;
import java.util.Date;

public class TokenDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String jwt;
    private Date expirationJwt;

    public TokenDto() {
    }

    public TokenDto(String jwt, Date expirationJwt) {
        this.jwt = jwt;
        this.expirationJwt = expirationJwt;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Date getExpirationJwt() {
        return expirationJwt;
    }

    public void setExpirationJwt(Date expirationJwt) {
        this.expirationJwt = expirationJwt;
    }
}
