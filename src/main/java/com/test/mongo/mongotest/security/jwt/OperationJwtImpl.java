package com.test.mongo.mongotest.security.jwt;

import com.test.mongo.mongotest.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

public class OperationJwtImpl implements OperationJwt{

    //private final String keySecret = "ADA_Secret*123";
    @Value("${KeySecret}")
    private String keySecret;
    @Override
    public String generateJwt(User user, Calendar expirationDate) {

        return Jwts.builder()
                .setSubject(user.getId())
                .claim("name", user.getFullName())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate.getTime())
                .signWith(SignatureAlgorithm.HS256, keySecret)
                .compact();
    }

    @Override
    public Boolean validateJwt(String jwt, User user) {
        Boolean isJwtExpired = returnClaims(jwt).getExpiration().before(new Date());
        Boolean isValidJwt = user.getId().equals(extractSubject(jwt)) && !isJwtExpired;
        return isValidJwt;
    }

    @Override
    public Claims returnClaims(String jwt) {
        return Jwts.parser().setSigningKey(keySecret).parseClaimsJws(jwt).getBody();
    }

    @Override
    public String extractSubject(String jwt) {
        return returnClaims(jwt).getSubject();
    }
}
