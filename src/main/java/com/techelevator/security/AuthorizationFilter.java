package com.techelevator.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpRespone = (HttpServletResponse) response;

		String sessionUser = getUserFromSession(httpRequest);
		String requestUser = getUserFromRequest(httpRequest);

		if (requestUser != null && requestUser.equals(sessionUser) == false) {
			if (sessionUser == null) {
				redirectToLoginPage(httpRequest, httpRespone);
			} else {
				httpRespone.sendError(403);
			}
		}
		chain.doFilter(httpRequest, response);

	}

	private void redirectToLoginPage(HttpServletRequest httpRequest, HttpServletResponse httpRespone)
			throws IOException {

		String originalRequest = httpRequest.getRequestURL().toString();
		String queryString = httpRequest.getQueryString();
		if (queryString != null) {
			originalRequest = originalRequest + "?" + httpRequest.getQueryString();
		}
		
		String context = httpRequest.getServletContext().getContextPath();
		httpRespone.sendRedirect(context + "/login?destination=" +URLEncoder.encode(originalRequest, "UTF-8"));
	}

	private String getUserFromSession(HttpServletRequest httpRequest) {
		String sessionUser = (String) httpRequest.getSession().getAttribute("user");
		return sessionUser;
	}

	private String getUserFromRequest(HttpServletRequest httpRequest) {
		String requestUser = null;
		String[] path = httpRequest.getServletPath().split("/");
		if (path.length >= 3) {
			if (path[2].equals("new") == false) {
				requestUser = path[2];
			}

		}
		return requestUser;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
