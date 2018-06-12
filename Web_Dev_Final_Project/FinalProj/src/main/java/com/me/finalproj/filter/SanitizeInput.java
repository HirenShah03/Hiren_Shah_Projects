package com.me.finalproj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SanitizeInput implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			String search = request.getParameter("searchBy");
            if(search!=null) {
                search = search.replaceAll("[^\\dA-Za-z0-9- ]", "");
                System.out.println(search);
                request.setAttribute("searchBy", search);
            }
            
            String username = request.getParameter("userName");
            System.out.println(username);
            if(username!=null) {
                username = username.replaceAll("[^\\dA-Za-z0-9-@. ]", "");
                System.out.println(username);
                request.setAttribute("username", username);
            }
            String password = request.getParameter("password");
            if(password!=null) {
                password = password.replaceAll("[^\\dA-Za-z0-9-@. ]", "");
                System.out.println(password);
                request.setAttribute("password", password);
            }
            String captchaCode = request.getParameter("captchaCode");
            if(captchaCode!=null) {
                captchaCode = captchaCode.replaceAll("[^\\dA-Za-z0-9]", "");
                System.out.println(captchaCode);
                request.setAttribute("captchaCode", captchaCode);
            }
			chain.doFilter(request, response);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("home.jsp")
                               .forward(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
