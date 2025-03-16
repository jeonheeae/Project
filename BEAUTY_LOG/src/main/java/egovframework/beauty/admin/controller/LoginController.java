package egovframework.beauty.admin.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.admin.model.LoginVO;
import egovframework.beauty.admin.service.LoginService;

@RequestMapping(value="admin")
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	// 관리자 로그인 화면
	@RequestMapping(value="/login.do", method = {RequestMethod.GET})
	public ModelAndView login(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session
			)throws Exception {
		ModelAndView mav = new ModelAndView("admin/login");
		
		return mav;
	}
	
	// 로그인 처리
	@RequestMapping(value="/login.do", method = {RequestMethod.POST})
	public String postLogin(
			ModelMap model
			, HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("LoginVO") LoginVO loginVO
			)throws Exception {
		
		try {
			//로그인 정보 가져오기
			LoginVO rs = loginService.getLogin(loginVO);
			
			// ID Check
			if(rs == null) {
				PrintWriter writer = response.getWriter(); 
				
				response.setContentType("text/html; charset=UTF-8;");
				request.setCharacterEncoding("UTF-8");
				writer.println("<script type='text/javascript'>");
				writer.println("alert('아이디를 다시 확인해주세요');");
				writer.println("location.href='/admin/login.do';");
			    writer.println("</script>");
				writer.flush();
				writer.close();
			
				return null;
			}if(!request.getParameter("admPwd").equals(rs.getAdmPwd())) {
				// PASSWORD Check
				PrintWriter writer = response.getWriter(); 
				
				response.setContentType("text/html; charset=UTF-8;");
				request.setCharacterEncoding("UTF-8");
				writer.println("<script type='text/javascript'>");
				writer.println("alert('비밀번호를 다시 확인해주세요');");
				writer.println("location.href='/admin/login.do';");
			    writer.println("</script>");
				writer.flush();
				writer.close();
			
				return null;
				
			}if(!rs.getStat().equals("1")){
				// 상태값 체크
				PrintWriter writer = response.getWriter(); 
				
				response.setContentType("text/html; charset=UTF-8;");
				request.setCharacterEncoding("UTF-8");
				writer.println("<script type='text/javascript'>");
				writer.println("alert('사용이 중지된 계정 입니다. 관리자에게 문의 해주세요.');");
				writer.println("location.href='/admin/login.do';");
			    writer.println("</script>");
				writer.flush();
				writer.close();
			
				return null;				
				
			}else {
				session.setAttribute("ADMSN", rs.getAdmSn());
				session.setAttribute("ADMID", rs.getAdmId());
				return "redirect:index.do"; 
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:login.do";
		}
		
		
	}
	
	
}
