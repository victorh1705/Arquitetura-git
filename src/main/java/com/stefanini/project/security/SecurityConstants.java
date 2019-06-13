package com.stefanini.project.security;

public final class SecurityConstants {
	
	private SecurityConstants() {}

	
	// EXPIRATION_TIME = 30 min
	public static final long EXPIRATION_TIME = 1_800_000;
	public static final String SECRET = "SecretProject";
	public static final String AUTHORITIES_KEY = "authorities";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String AUTHORIZATION_HEADER_KEY = "Authorization";

}
