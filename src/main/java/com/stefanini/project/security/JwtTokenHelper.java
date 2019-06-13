package com.stefanini.project.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class JwtTokenHelper {

	private static final String COMMA_SEPARATOR = ",";

	private JwtTokenHelper() {
	}

	static String generateToken(Authentication auth) {
		String authorities = getAuthorities(auth);

		return Jwts.builder()
				.setSubject(auth.getName())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
				.claim(SecurityConstants.AUTHORITIES_KEY, authorities).compact();

	}

	private static String getAuthorities(Authentication auth) {
		return auth
				.getAuthorities()
				.stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(COMMA_SEPARATOR));
	}

	static Authentication getAuthentication(String token) {
		if (token != null) {
			Claims claims = Jwts.parser()
					.setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
					.getBody();

			String user = claims.getSubject();

			Collection<GrantedAuthority> authorities = getAuthorities(claims);

			return new UsernamePasswordAuthenticationToken(user, null, authorities);
		}

		return null;
	}

	private static Collection<GrantedAuthority> getAuthorities(Claims claims) {
		String[] authoritiesClaim = claims.get(SecurityConstants.AUTHORITIES_KEY).toString().split(COMMA_SEPARATOR);
		
		return Arrays
				.stream(authoritiesClaim)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

}