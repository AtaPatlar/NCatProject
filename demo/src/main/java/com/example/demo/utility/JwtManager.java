package com.example.demo.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtManager {

    @Value("${my-config.jwt-secret-key}")
    private String secretKey;


    public Optional<String> createToken(String id, String email){
        String token="";
        Long expireTime=1000*60*60l;
        try{
            token= JWT.create()
                    .withClaim("id",id)
                    .withClaim("email",email)
                    .withIssuer("alperenEfsanedir")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis()+expireTime))
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);
        }
        catch (Exception e){
            return Optional.of(null);
        }
    }




    public Optional<String> getIdByToken(String token){
        try{
            Algorithm algorithm=Algorithm.HMAC512(secretKey);
            JWTVerifier jwtVerifier=JWT.require(algorithm).withIssuer("alperenEfsanedir").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            if (decodedJWT==null) {
                return Optional.empty();
            }
            Optional<String> id=Optional.of(decodedJWT.getClaim("id").as(String.class));
            return id;
        }catch (Exception e){
            throw new RuntimeException();
        }


    }
}
