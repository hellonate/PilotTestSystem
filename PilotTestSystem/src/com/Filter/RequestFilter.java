package com.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Bean.User;
import com.sun.net.httpserver.HttpServer;

/**
 * Servlet Filter implementation class RequestFilter
 */
@WebFilter("/*")
public class RequestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RequestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		 req.setCharacterEncoding("utf-8");
	/*	 HttpServletRequest request=(HttpServletRequest)req;
		 HttpServletResponse response=(HttpServletResponse)res;
		 HttpSession session = request.getSession();
		 String url = request.getRequestURI();
		 if(session == null){
			 if(url.contains("LoginServlet?param_=login") || url.contains("makeCertPic.jsp") ){
				 chain.doFilter(req, res);
			 }else{
				
				 request.getRequestDispatcher("../index.html").forward(request, response);
			 }
		 }else{
			 request.getRequestDispatcher("index.html").forward(request, response);
		 }*/
		 
		// pass the request along the filter chain
		 chain.doFilter(req, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
