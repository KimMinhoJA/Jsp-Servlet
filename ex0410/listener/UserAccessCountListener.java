package ex0410.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * tomcat version 9.x이므로 interface에 있는 메소드 default이다.
 * 그래서 필요한 메소드만 재정의 해도 된다.
 * @author kosta
 *
 */
@WebListener
public class UserAccessCountListener implements HttpSessionListener, ServletContextListener {
	ServletContext application;
	/**
	 * 서버가 start될 때 접속자 수를 count해줄 변수의 초기화 작업이 필요
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		application = e.getServletContext();
		application.setAttribute("count", new AtomicInteger());
	}

	/**
	 * session이 시작되면 접속자 수를 증가한다.
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		System.out.println("접속자 수 : " + count.incrementAndGet());
	}

	/**
	 * session이 종료되면 접속자 수를 감소한다.
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		System.out.println("접속자 수 : " + count.decrementAndGet());
	}
	
}
