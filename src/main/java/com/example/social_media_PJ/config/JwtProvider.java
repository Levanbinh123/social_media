package com.example.social_media_PJ.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
    private static SecretKey secretKey=
            Keys.hmacShaKeyFor(JwtConstans.SECRET.getBytes());
    public static String generateToken(Authentication auth) {
        String jwt= Jwts.builder().
                setIssuer("binhbinh").setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+86400000))
                .claim("email",auth.getName())
                .signWith(secretKey).compact();
                 return jwt;
    }
    //lay email tu token jwt
    public static String getEmailFromToken(String token) {
        token=token.substring(7);
        Claims claims=Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
        String email=String.valueOf(claims.get("email"));
        return email;
    }
}
