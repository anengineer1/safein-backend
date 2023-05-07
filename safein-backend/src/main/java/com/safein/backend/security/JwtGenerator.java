package com.safein.backend.security;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expirationDate = new Date(currentDate.getTime() + Constants.TOKEN_EXPIRATION_TIME);

		String token = Jwts.builder().setSubject(username).setIssuedAt(currentDate).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, Constants.SUPER_SECRET_KEY).compact();
		// .signWith(Keys.hmacShaKeyFor(Constants.SUPER_SECRET_KEY.getBytes())).compact();
		return token;
	}

	public String getUserNameFromJwt(String token) {
		Claims claims = Jwts.parser().setSigningKey(Constants.SUPER_SECRET_KEY).parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(Constants.SUPER_SECRET_KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
		}
	}

}
