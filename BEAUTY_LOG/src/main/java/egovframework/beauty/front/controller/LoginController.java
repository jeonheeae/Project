package egovframework.beauty.front.controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import egovframework.beauty.front.model.LoginVO;
import egovframework.beauty.front.service.LoginService;

@RequestMapping(value="front")
@Controller("frontLoginController")
public class LoginController {

    @Autowired
    @Qualifier("frontLoginServiceImpl") 
    private LoginService loginService;

    // 사용자 로그인 화면
    @RequestMapping(value="/login.do", method = {RequestMethod.GET})
    public String getLoginPage() {
        return "front/login";  
    }

    // 로그인 처리
    @RequestMapping(value="/login.do", method = {RequestMethod.POST})
    public String postLogin(
            ModelMap model,
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session,
            @ModelAttribute("LoginVO") LoginVO loginVO
    ) throws Exception {
        try {
            LoginVO rs = loginService.getLogin(loginVO);

            if (rs == null) {
                PrintWriter writer = response.getWriter(); 
                response.setContentType("text/html; charset=UTF-8;");
                request.setCharacterEncoding("UTF-8");
                writer.println("<script type='text/javascript'>");
                writer.println("alert('아이디를 다시 확인해주세요');");
                writer.println("location.href='/front/login.do';");
                writer.println("</script>");
                writer.flush();
                writer.close();
                return null;
            }

            if (!loginVO.getUserPwd().equals(rs.getUserPwd())) {
                PrintWriter writer = response.getWriter();
                response.setContentType("text/html; charset=UTF-8;");
                request.setCharacterEncoding("UTF-8");
                writer.println("<script type='text/javascript'>");
                writer.println("alert('비밀번호를 다시 확인해주세요');");
                writer.println("location.href='/front/login.do';");
                writer.println("</script>");
                writer.flush();
                writer.close();
                return null;
            }

            if (!rs.isStatus()) {
                PrintWriter writer = response.getWriter(); 
                response.setContentType("text/html; charset=UTF-8;");
                request.setCharacterEncoding("UTF-8");
                writer.println("<script type='text/javascript'>");
                writer.println("alert('사용이 중지된 계정입니다. 관리자에게 문의해주세요.');");
                writer.println("location.href='/front/login.do';");
                writer.println("</script>");
                writer.flush();
                writer.close();
                return null;
            } else {
                session.setAttribute("userId", rs.getUserId());
                session.setAttribute("userSn", rs.getUserSn()); 
                session.setAttribute("userName", rs.getUserName());
                return "redirect:/index.do"; 
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/front/login.do";  
        }
    }

    @RequestMapping(value = "/logout.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/front/login.do"; 
    }
}
