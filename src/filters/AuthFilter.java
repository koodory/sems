package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(
			ServletRequest request, ServletResponse response,
	    FilterChain next) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String servletPath = httpRequest.getServletPath();
		
		if (!servletPath.startsWith("/auth/")) {
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("loginUser") == null) {
				String contextRoot= httpRequest.getContextPath(); 
				httpResponse.sendRedirect(contextRoot + "/auth/login.bit");
				//  "/web01/auth/login.bit"
				return;
			}
		}
		next.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}













