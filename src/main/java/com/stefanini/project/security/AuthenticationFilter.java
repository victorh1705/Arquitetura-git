package com.stefanini.project.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;

public class AuthenticationFilter extends GenericFilterBean {

	private static final String TOKEN_EXPIRADO = "Token Expirado";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String token = ((HttpServletRequest) request).getHeader(SecurityConstants.AUTHORIZATION_HEADER_KEY);
		try {
			Authentication authentication = JwtTokenHelper.getAuthentication(token);

			if (authentication == null) {
				((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			} else {

				token = JwtTokenHelper.generateToken(authentication);

				((HttpServletResponse) response).addHeader(SecurityConstants.AUTHORIZATION_HEADER_KEY,
						SecurityConstants.TOKEN_PREFIX + " " + token);

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException ex) {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			((HttpServletResponse) response).getWriter().write(TOKEN_EXPIRADO);
		}
	}

}