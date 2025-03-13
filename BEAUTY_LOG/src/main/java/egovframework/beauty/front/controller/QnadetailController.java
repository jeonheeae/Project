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
public class QnadetailController {

    // Q&A detail화면
    @RequestMapping(value="/qnadetail.do", method = {RequestMethod.GET})
    public ModelAndView qnadetail(
            HttpServletRequest request,
            HttpServletResponse response,
            HttpSession session
    ) throws Exception {
        ModelAndView mav = new ModelAndView("front/qna/qnadetail");

        return mav;
    }
}
