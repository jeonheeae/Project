package egovframework.beauty.front.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.front.model.ReviewVO;
import egovframework.beauty.front.service.ReviewService;

@RequestMapping("front")
@Controller("frontReviewController")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 작성 폼 이동 (GET)
    @RequestMapping(value = "/review/write.do", method = RequestMethod.GET)
    public ModelAndView writeReviewForm(@RequestParam("prdSn") Long prdSn, HttpSession session) {
        Object userSnObj = session.getAttribute("userSn");
        if (userSnObj == null) {
            return new ModelAndView("redirect:/front/login.do"); 
        }

        // 상품명 조회 로직 추가
        String prdNm = reviewService.getProductNameBySn(prdSn); 
        String prdDesc = reviewService.getProductDescriptionBySn(prdSn); 

        ModelAndView mav = new ModelAndView("front/review/reviewwrite");
        mav.addObject("prdSn", prdSn);
        mav.addObject("prdNm", prdNm); 
        mav.addObject("prdDesc", prdDesc); 
        return mav;
    }

    @RequestMapping(value = "/review/post.do", method = RequestMethod.POST)
    public String addReview(@ModelAttribute ReviewVO reviewVO, HttpSession session) {
        Object userSnObj = session.getAttribute("userSn");
        Object userNameObj = session.getAttribute("userName"); 

        if (userSnObj == null || userNameObj == null) {
            return "redirect:/front/login.do";  
        }

        int userSn = (int) userSnObj;
        String userName = userNameObj.toString(); 

        reviewVO.setUserSn(userSn);
        reviewVO.setWriter(userName);

        try {
            String prdNm = reviewService.getProductNameBySn(reviewVO.getPrdSn());
            reviewVO.setPrdNm(prdNm);

            reviewService.add(reviewVO);
        } catch (Exception e) {
            e.printStackTrace();
            return "error"; 
        }

        return "redirect:/front/review/detail.do?prdSn=" + reviewVO.getPrdSn(); 
    }

    // 리뷰 수정 폼 이동 (GET)
    @RequestMapping(value = "/review/edit.do", method = RequestMethod.GET)
    public ModelAndView editReview(@RequestParam("reviewSn") Long reviewSn, HttpSession session) {
        Object userSnObj = session.getAttribute("userSn");
        if (userSnObj == null) {
            return new ModelAndView("redirect:/front/login.do");  
        }

        try {
            ReviewVO review = reviewService.get(reviewSn);
            if (review == null || review.getUserSn() != (int) userSnObj) {
                return new ModelAndView("error"); 
            }

            ModelAndView mav = new ModelAndView("front/review/reviewedit");
            mav.addObject("review", review);
            return mav;

        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("error");  
        }
    }

    // 리뷰 수정 처리 (POST)
    @RequestMapping(value = "/review/update.do", method = RequestMethod.POST)
    public String updateReview(@ModelAttribute ReviewVO reviewVO, HttpSession session) {
        Object userSnObj = session.getAttribute("userSn");
        if (userSnObj == null) {
            return "redirect:/front/login.do";
        }

        reviewVO.setUserSn((int) userSnObj);

        try {
            reviewService.edit(reviewVO);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";  
        }

        return "redirect:/front/review/detail.do?prdSn=" + reviewVO.getPrdSn(); 
    }

    // 리뷰 삭제 처리 (POST 방식 권장)
    @RequestMapping(value = "/review/delete.do", method = RequestMethod.POST)
    public String deleteReview(@RequestParam("reviewSn") Long reviewSn, HttpSession session) {
        Object userSnObj = session.getAttribute("userSn");
        if (userSnObj == null) {
            return "redirect:/front/login.do";  
        }

        try {
            ReviewVO review = reviewService.get(reviewSn);  
            if (review != null && review.getUserSn() == (int) userSnObj) {
                reviewService.delete(review);  
                return "redirect:/front/review/detail.do?prdSn=" + review.getPrdSn();  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";  
    }

    // 리뷰 목록
    @RequestMapping(value = "/review/list.do", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "productName", required = false) String productName,
                             @ModelAttribute ReviewVO reviewVO) throws Exception {
        ModelAndView mav = new ModelAndView("front/review/review");

        reviewVO.setFirstIndex(0);
        reviewVO.setRecordCountPerPage(100);

        List<ReviewVO> list = (productName != null && !productName.trim().isEmpty())
                ? reviewService.searchByProductName(productName)
                : reviewService.list(reviewVO);

        mav.addObject("reviews", list);
        mav.addObject("productName", productName);

        return mav;
    }

    // 제품 리뷰 상세
    @RequestMapping(value = "/review/detail.do", method = RequestMethod.GET)
    public ModelAndView productReviewDetail(@RequestParam("prdSn") Long prdSn) throws Exception {
        ModelAndView mav = new ModelAndView("front/review/reviewdetail");

        try {
            List<ReviewVO> reviews = reviewService.getReviewsByProduct(prdSn);
            if (!reviews.isEmpty()) {
                ReviewVO productInfo = reviews.get(0);
                mav.addObject("productName", productInfo.getPrdNm());
                mav.addObject("productDescription", productInfo.getPrdDesc());
                mav.addObject("rating", productInfo.getRating());
                mav.addObject("reviewCount", productInfo.getReviewCount());
            }

            mav.addObject("reviews", reviews);
        } catch (Exception e) {
            mav.setViewName("error");
        }

        return mav;
    }

    //  리디렉션 기본 경로
    @RequestMapping(value = "/review.do", method = RequestMethod.GET)
    public String redirectReviewList() {
        return "redirect:/front/review/list.do";
    }
}
