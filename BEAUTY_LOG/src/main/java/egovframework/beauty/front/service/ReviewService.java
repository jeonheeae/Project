package egovframework.beauty.front.service;

import java.util.List;
import org.springframework.stereotype.Service;
import egovframework.beauty.front.model.ReviewVO;

@Service
public interface ReviewService {

    // 리뷰 목록
    List<ReviewVO> list(ReviewVO reviewVO) throws Exception;

    // 리뷰 개수
    int listCnt(ReviewVO reviewVO) throws Exception;

    // 리뷰 등록
    int add(ReviewVO reviewVO) throws Exception;
    
    // 리뷰 상세 조회
    ReviewVO get(Long reviewSn) throws Exception;  
    
    double getAverageRating(Long prdSn) throws Exception;
   
    String getProductNameBySn(Long prdSn);

    // 상품 설명 조회
    String getProductDescriptionBySn(Long prdSn); 

    // 리뷰 수정
    int edit(ReviewVO reviewVO) throws Exception;

    // 리뷰 삭제
    int delete(ReviewVO reviewVO) throws Exception;
    
    List<ReviewVO> getRankedProducts() throws Exception;
    
    // 제품명으로 리뷰 검색
    List<ReviewVO> searchByProductName(String productName) throws Exception;

    // 제품별 리뷰 목록 조회
    List<ReviewVO> getReviewsByProduct(Long prdSn) throws Exception;
    
    // 제품 이미지 목록 조회 추가
    List<String> getProductImagesForReview(Long prdSn) throws Exception; // 추가된 메소드

    List<ReviewVO> getTop3ProductsByView();

}
