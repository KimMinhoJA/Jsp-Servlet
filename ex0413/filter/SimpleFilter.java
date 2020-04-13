package ex0413.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class SimpleFilter implements Filter {

	String enc;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SimpleFilter의 init call.....");
		
		String addr = filterConfig.getInitParameter("addr");
		String message = filterConfig.getInitParameter("message");
		System.out.println("addr : " + addr);
		System.out.println("message : " + message);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SimpleFilter의 사전처리");
		chain.doFilter(request, response);
		System.out.println("SimpleFilter의 사후처리");
	}

	@Override
	public void destroy() {
		System.out.println("SimpleFilter의 destroy call.....");
	}
}
