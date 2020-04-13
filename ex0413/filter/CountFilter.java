package ex0413.filter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "clickCount")
		})
public class CountFilter implements Filter {
	Properties properties;
	String propertiesPath;
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		properties = new Properties();
		ServletContext application = fConfig.getServletContext();
		propertiesPath = application.getRealPath("/") + "properties/" + fConfig.getInitParameter("fileName") + ".properties";
		File file = new File(propertiesPath);
		
		System.out.println(file.exists());
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileReader reader;
		try {
			reader = new FileReader(propertiesPath);
			properties.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest)request).getRequestURL().toString();
		if(properties.getProperty(path) == null) {
			properties.setProperty(path, "1");
		}else {
			int count = Integer.parseInt(properties.getProperty(path));
			properties.setProperty(path, (count + 1) + "");
		}
		FileWriter writer = new FileWriter(propertiesPath);
		properties.store(writer, "");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
