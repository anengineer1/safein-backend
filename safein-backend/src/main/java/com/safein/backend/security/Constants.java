package com.safein.backend.security;

public class Constants {

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "admin";
	public static final String SUPER_SECRET_KEY = "2p980453nySRYNHDGFB234634ys34v2676f5rq34bvSDFBHEYJS34f456747iknub45wctgsrfw4w45b7yub6j75uryt45e6n7urytf";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	// public static final long TOKEN_EXPIRATION_TIME = 70000; // ni idea

}
