package ex0410.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {
	long curtime;
	@Override
    public void requestInitialized(ServletRequestEvent sre)  { 
		System.out.println("RequestListener�� requestInitialized");
		curtime = System.nanoTime();
    }
	
	@Override
    public void requestDestroyed(ServletRequestEvent sre)  { 
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		System.out.println("RequestListener�� requestDestroyed");
		System.out.println(request.getRequestURL().toString() + "������");
		System.out.println("�� �ҿ�ð� : " + (System.nanoTime() - curtime) +"ns");
    }
	
}
