package egovframework.beauty.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.admin.service.LoginService;

@RequestMapping(value="front")
@Controller("frontLoginController") 
public class LoginController {

    @Autowired
    private LoginService loginService;

    // 사용자 로그인 화면
    @RequestMapping(value="/login.do", method = {RequestMethod.GET})
    public ModelAndView login(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
            ) throws Exception {
        ModelAndView mav = new ModelAndView("front/login");

        return mav;
    }
}
