package com.offcn.filter;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharacterEncodingFilter", urlPatterns = {"/*"})
public class CharacterEncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, javax.servlet.FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(javax.servlet.FilterConfig config) throws ServletException {

    }

}
