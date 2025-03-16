package egovframework.beauty.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminInterceptor implements HandlerInterceptor {

	// 로그인 처리 interceptor
	@Override
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler
			) throws Exception{
		
		response.setContentType("text/html.charset=UTF-8");
		try {
			
			HttpSession session = request.getSession();
			
			if(session.getAttribute("ADMSN") == null) {
				response.sendRedirect(request.getContextPath()+"/admin/login.do");
				return false;
			}else {
				return HandlerInterceptor.super.preHandle(request, response, handler);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}
	
    // 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
    @Override
    public void postHandle(
    		HttpServletRequest request
    		, HttpServletResponse response
    		, Object handler
    		, ModelAndView modelAndView
    		) throws Exception {
    	HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    } 
	
}
