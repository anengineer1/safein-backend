package com.safein.backend.security;

import java.io.IOException;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SimpleCORSFilter implements Filter {

private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

public SimpleCORSFilter() {
    log.info("SimpleCORSFilter init");
}

@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    response.setHeader("Access-Control-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Host, Content-Lenght");

    chain.doFilter(req, res);
}

@Override
public void init(FilterConfig filterConfig) {
}

@Override
public void destroy() {
}

}