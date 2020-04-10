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
		System.out.println("RequestListener의 requestInitialized");
		curtime = System.nanoTime();
    }
	
	@Override
    public void requestDestroyed(ServletRequestEvent sre)  { 
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		
		System.out.println("RequestListener의 requestDestroyed");
		System.out.println(request.getRequestURL().toString() + "문서의");
		System.out.println("총 소요시간 : " + (System.nanoTime() - curtime) +"ns");
    }
	
}
