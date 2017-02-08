package com.mrin;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;

@Component
@Order(0)
public class CorsFilter implements javax.servlet.Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest  req = (HttpServletRequest) request;
		// Just REPLY OK if request method is OPTIONS for CORS (pre-flight)
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Accept-Encoding, Accept-Language, Host, Referer, Connection, User-Agent, authorization");
		if (req.getMethod().equals("OPTIONS") ) {
			res.setStatus(HttpServletResponse.SC_OK);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
