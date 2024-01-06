package com.Ecommerce.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebFilter(urlPatterns = {"/Login.jsp","/Admin/*","/User/*"})
	//@WebFilter("/tst.jsp")
	public class AuthFilter implements Filter {
	
	    public void destroy() {
	    }
	
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	    	
	    	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpSession session = httpRequest.getSession();
	       
	        
	        if ("/Ecommerce/Login.jsp".equals(httpRequest.getRequestURI())) {	
	        	session.setAttribute("ath", "no");
	        	chain.doFilter(request, response);	        
	        }
   
      if(session.getAttribute("ath").equals("ok"))
    	chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Peut contenir du code d'initialisation si nécessaire
    }
}
