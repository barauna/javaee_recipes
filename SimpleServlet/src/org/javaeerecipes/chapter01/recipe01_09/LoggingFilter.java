package org.javaeerecipes.chapter01.recipe01_09;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter("/*")
public class LoggingFilter implements Filter {
	private FilterConfig filterConf;

    public LoggingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String userIP = request.getRemoteHost();
		filterConf.getServletContext().log("IP do visitante: " + userIP);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		filterConf = fConfig;
	}

}
