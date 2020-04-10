package ex0410.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	/**
	 * 세션이 시작될 때 호출
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionLIstener의 sessionCreated...");
	}

	/**
	 * 세션이 종료될 때 호출
	 * session timeout일 때
	 * session.invalidate()일 때
	 * 
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener의 sessionDestroyed");
	}


}
