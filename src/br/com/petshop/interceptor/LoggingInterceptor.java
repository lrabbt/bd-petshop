package br.com.petshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class LoggingInterceptor implements HandlerInterceptor  {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		 String uri = request.getRequestURI();
	      if(uri.contains("login") || 
	              uri.contains("cadastrarCliente"))
	      			{
	        return true;
	      }
	      if(request.getSession().getAttribute("clientLogado") != null) {
	          return true;
	        }
	        
	        response.sendRedirect("/Petshop/login/");
	        return false;
	    
	}
	@Override
	public void postHandle(	HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("---method executed---");
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		System.out.println("---Request Completed---");
	}
} 