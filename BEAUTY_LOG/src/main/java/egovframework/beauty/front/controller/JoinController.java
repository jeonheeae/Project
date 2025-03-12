package egovframework.beauty.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.front.service.JoinService;

@Controller("frontJoinController")
@RequestMapping(value = "front")
@Import(JoinService.class)  
public class JoinController {

    @Autowired
    private JoinService joinService;


    // 사용자 회원가입 화면 
    @RequestMapping(value="/join.do", method = {RequestMethod.GET})
    public ModelAndView join(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
            ) throws Exception {
        ModelAndView mav = new ModelAndView("front/join");

        return mav;
    }
} 