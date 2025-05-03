package egovframework.beauty.front.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.front.model.ReviewVO;
import egovframework.beauty.front.service.ReviewService;

@Controller
public class MainController {

    @Autowired
    private ReviewService reviewService; 

    @RequestMapping(value="/index.do", method = {RequestMethod.GET})
    public ModelAndView frontMain(
            HttpServletRequest request, 
            HttpServletResponse response, 
            HttpSession session
    ) throws Exception {
        ModelAndView mav = new ModelAndView("front/main");

        // 로그인 사용자 ID 확인
        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            mav.addObject("userId", userId);
        }

        // 서비스 호출로 상위 3개 제품 데이터 가져오기
        List<ReviewVO> top3 = reviewService.getTop3ProductsByView();
        mav.addObject("top3Products", top3);

        return mav;
    }
}
