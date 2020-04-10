package ex0410.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	/**
	 * ������ ���۵� �� ȣ��
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionLIstener�� sessionCreated...");
	}

	/**
	 * ������ ����� �� ȣ��
	 * session timeout�� ��
	 * session.invalidate()�� ��
	 * 
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener�� sessionDestroyed");
	}


}
