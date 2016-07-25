package net.wasdev.samples.ferret;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FerretFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI().substring(req.getContextPath().length());

		if (path.startsWith("/static")) {
		    chain.doFilter(request, response); // Goes to default servlet.
		} else {
		    request.getRequestDispatcher("/pages" + path).forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
