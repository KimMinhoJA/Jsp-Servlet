package ex0410.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * tomcat version 9.x�̹Ƿ� interface�� �ִ� �޼ҵ� default�̴�.
 * �׷��� �ʿ��� �޼ҵ常 ������ �ص� �ȴ�.
 * @author kosta
 *
 */
@WebListener
public class UserAccessCountListener implements HttpSessionListener, ServletContextListener {
	ServletContext application;
	/**
	 * ������ start�� �� ������ ���� count���� ������ �ʱ�ȭ �۾��� �ʿ�
	 */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		application = e.getServletContext();
		application.setAttribute("count", new AtomicInteger());
	}

	/**
	 * session�� ���۵Ǹ� ������ ���� �����Ѵ�.
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		System.out.println("������ �� : " + count.incrementAndGet());
	}

	/**
	 * session�� ����Ǹ� ������ ���� �����Ѵ�.
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		AtomicInteger count = (AtomicInteger)application.getAttribute("count");
		System.out.println("������ �� : " + count.decrementAndGet());
	}
	
}
