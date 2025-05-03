package egovframework.beauty.front.service.impl;

import java.util.List;
import java.util.ArrayList;  // ArrayList 추가
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import egovframework.beauty.front.service.mapper.ReviewMapper;
import egovframework.beauty.front.model.ReviewVO;
import egovframework.beauty.front.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
    @Autowired
    private ReviewMapper reviewMapper;
    
    @Override
    public String getProductDescriptionBySn(Long prdSn) {
        // ReviewMapper에서 상품 설명을 조회
        return reviewMapper.selectProductDescriptionBySn(prdSn);
    }

    @Override
    public List<ReviewVO> getReviewsByProduct(Long prdSn) throws Exception {
        List<ReviewVO> reviews = reviewMapper.selectReviewsByProduct(prdSn);

        // 리뷰 개수 계산
        if (reviews != null && !reviews.isEmpty()) {
            int reviewCount = reviews.size();  
            for (ReviewVO review : reviews) {
                review.setReviewCount(reviewCount); 
            }
        }

        return reviews;  // 리뷰 목록 반환
    }
   
    @Override
    public double getAverageRating(Long prdSn) throws Exception {
        return reviewMapper.getAverageRating(prdSn);
    }
    
    @Override
    public List<ReviewVO> list(ReviewVO reviewVO) throws Exception {
        return reviewMapper.list(reviewVO);
    }

    @Override
    public int listCnt(ReviewVO reviewVO) throws Exception {
        return reviewMapper.listCnt(reviewVO);
    }

    @Override
    public int add(ReviewVO reviewVO) throws Exception {
        try {
            return reviewMapper.add(reviewVO);
        } catch (Exception e) {
            // 예외 처리: 예를 들어, 로깅 및 사용자 친화적인 메시지 반환
            throw new Exception("리뷰 등록에 실패했습니다.", e);
        }
    }

    @Override
    public ReviewVO get(Long reviewSn) throws Exception { 
        try {
            return reviewMapper.get(reviewSn);  
        } catch (Exception e) {
            throw new Exception("리뷰 조회에 실패했습니다.", e);
        }
    }

    @Override
    public int edit(ReviewVO reviewVO) throws Exception {
        try {
            return reviewMapper.edit(reviewVO);
        } catch (Exception e) {
            throw new Exception("리뷰 수정에 실패했습니다.", e);
        }
    }

    @Override
    public int delete(ReviewVO reviewVO) throws Exception {
        try {
            return reviewMapper.delete(reviewVO);
        } catch (Exception e) {
            throw new Exception("리뷰 삭제에 실패했습니다.", e);
        }
    }

    @Override
    public String getProductNameBySn(Long prdSn) {
        return reviewMapper.selectProductNameBySn(prdSn);
    }
    
    // 제품명으로 리뷰 검색
    @Override
    public List<ReviewVO> searchByProductName(String productName) throws Exception {
        try {
            return reviewMapper.searchByProductName(productName);
        } catch (Exception e) {
            throw new Exception("제품명으로 리뷰 검색에 실패했습니다.", e);
        }
    }

    @Override
    public List<ReviewVO> getRankedProducts() throws Exception {
        return reviewMapper.getRankedProducts();
    }

    // 제품 이미지 목록 가져오는 메소드 구현
    @Override
    public List<String> getProductImagesForReview(Long prdSn) throws Exception {
        List<String> productImages = new ArrayList<>();  // 빈 리스트 초기화

        // DB에서 prdSn에 해당하는 이미지 목록을 가져오는 메소드 호출
        productImages = reviewMapper.getProductImagesByPrdSn(prdSn);
        
        return productImages;  // 이미지 목록 반환
    }
    @Override
    public List<ReviewVO> getTop3ProductsByView() {
        return reviewMapper.selectTop3ProductsByView();
    }
}
