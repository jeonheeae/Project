package egovframework.beauty.front.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import egovframework.beauty.front.model.ReviewVO;
import egovframework.beauty.front.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

@RequestMapping(value = "front")
@Controller("frontReviewController")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 추가 (POST) - 로그인 필요
    @RequestMapping(value = "/review/post.do", method = RequestMethod.POST)
    public String addReview(HttpSession session, @ModelAttribute("ReviewVO") ReviewVO reviewVO) throws Exception {

        // 로그인 체크 (리뷰 작성은 로그인된 사용자만 가능)
        Object userSnObj = session.getAttribute("userSn");
        if (userSnObj == null) {
            return "redirect:/front/login.do";  // 로그인 페이지로 리디렉션
        }

        int userSn = (int) userSnObj;
        reviewVO.setUserSn(userSn);  // 세션에서 유저 번호 설정

        try {
            reviewService.add(reviewVO);  // 리뷰 등록
        } catch (Exception e) {
            // 예외 처리: 에러 페이지로 리디렉션
            return "error";  
        }

        return "redirect:/front/review/list.do";  // 리뷰 목록 페이지로 리디렉션
    }

    // 리뷰 목록 페이지 (GET) - 로그인 필요 없음
    @RequestMapping(value = "/review/list.do", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "productName", required = false) String productName,
                             @ModelAttribute("ReviewVO") ReviewVO reviewVO) throws Exception {
        ModelAndView mav = new ModelAndView("front/review/review");

        reviewVO.setFirstIndex(0);
        reviewVO.setRecordCountPerPage(100);

        List<ReviewVO> list;
        if (productName != null && !productName.trim().isEmpty()) {
            list = reviewService.searchByProductName(productName);  // 제품명으로 리뷰 검색
        } else {
            list = reviewService.list(reviewVO);  // 전체 리뷰 목록 조회
        }
        mav.addObject("reviews", list);  // "reviews"라는 이름으로 리스트 전달
        mav.addObject("productName", productName);

        return mav;
    }

    // 리뷰 상세 페이지 (GET) - 로그인 필요 없음
    @RequestMapping(value = "/review/detail.do", method = RequestMethod.GET)
    public ModelAndView productReviewDetail(@RequestParam("prdSn") Long prdSn) throws Exception {
        ModelAndView mav = new ModelAndView("front/review/reviewdetail");

        try {
            List<ReviewVO> reviews = reviewService.getReviewsByProduct(prdSn);  // 리뷰 목록 가져오기

            if (!reviews.isEmpty()) {
                ReviewVO productInfo = reviews.get(0); // 첫 번째 리뷰 정보

                mav.addObject("productName", productInfo.getPrdNm());
                mav.addObject("productDescription", productInfo.getPrdDesc());
                mav.addObject("rating", productInfo.getRating());
                mav.addObject("reviewCount", productInfo.getReviewCount());  // reviewCount 전달
            }

            mav.addObject("reviews", reviews); // 리뷰 목록 전달
        } catch (Exception e) {
            mav.setViewName("error");
        }

        return mav;
    }


    

    // 잘못된 요청 처리 (리뷰 목록 페이지로 리디렉션)
    @RequestMapping(value = "/review.do", method = RequestMethod.GET)
    public String redirectReviewList() {
        // 이 URL에 대한 요청은 항상 리뷰 목록 페이지로 리디렉션
        return "redirect:/front/review/list.do";
    }
}
