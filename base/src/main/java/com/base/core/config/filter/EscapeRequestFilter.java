package com.base.core.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.core.config.filter.wrapper.EscapeRequestWrapper;
import com.base.core.config.filter.wrapper.EscapeResponseWrapper;

public class EscapeRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        EscapeRequestWrapper reqWrapper = new EscapeRequestWrapper( ( HttpServletRequest ) request );
        EscapeResponseWrapper resWrapper = new EscapeResponseWrapper( (HttpServletResponse ) response );
    // chain.doFilter( reqWrapper , response );
       chain.doFilter( reqWrapper , resWrapper );
    // chain.doFilter( request, response);
    }

    @Override
    public void destroy() {
    }




}
