package com.trabajofinal.services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    private static final String SECRET_KEY="TGFIZXN0aWFEZUNhbGNoaW5RdWllcmVPdHJNdW5kaWFs";

    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(),usuario);
    }

    private String getToken(Map<String,Object> extraClaims, UserDetails usuario){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(usuario.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key getKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String getUsernameFromToken(String token){
        return getClaim(token,Claims::getSubject);
    }
    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
    private Claims getAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    public Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }
    public boolean isTokenExpired(String token){
        return getExpiration(token).before(new Date());
    }
}

