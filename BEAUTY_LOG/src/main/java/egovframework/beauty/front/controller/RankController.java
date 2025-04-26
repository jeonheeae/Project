package egovframework.beauty.front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; // 꼭 import!
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.front.model.ReviewVO;
import egovframework.beauty.front.service.ReviewService;

@RequestMapping(value = "front")
@Controller("frontrank")
public class RankController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/rank.do", method = RequestMethod.GET)
    public ModelAndView rank(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView("front/rank/rank");

     // 별점 기준 랭킹 데이터 불러오기
        List<ReviewVO> rankedProducts = reviewService.getRankedProducts();
        
        // 각 리뷰에 대해 관련된 제품 이미지 목록을 설정
        for (ReviewVO product : rankedProducts) {
            // 예시로 productImages 리스트를 얻는 서비스 메소드
            List<String> images = reviewService.getProductImagesForReview(product.getPrdSn());
            
            // ReviewVO에 productImages 필드에 이미지 리스트 설정
            product.setProductImages(images);  // ReviewVO에 productImages 필드가 이미 있어야 합니다.
        }

        // 모델에 데이터를 전달
        mav.addObject("rankedList", rankedProducts);

        return mav;
    }
}
