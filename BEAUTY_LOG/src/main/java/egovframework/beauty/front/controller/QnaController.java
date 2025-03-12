package egovframework.beauty.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value="front")
@Controller
public class QnaController {

    // Q&A 화면
    @RequestMapping(value="/qna.do", method = {RequestMethod.GET})
    public ModelAndView qna(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
    ) throws Exception {
        ModelAndView mav = new ModelAndView("front/qna/qna");

        return mav;
    }
}
