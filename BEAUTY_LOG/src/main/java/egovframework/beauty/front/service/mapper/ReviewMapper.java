package egovframework.beauty.front.service.mapper;

import java.util.List;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import egovframework.beauty.front.model.ReviewVO;

@Mapper("ReviewMapper")
public interface ReviewMapper {

    // 리뷰 목록
    List<ReviewVO> list(ReviewVO reviewVO) throws Exception;

    // 리뷰 개수
    int listCnt(ReviewVO reviewVO) throws Exception;

    // 리뷰 등록
    int add(ReviewVO reviewVO) throws Exception;
    
    // 리뷰 상세 조회
    ReviewVO get(Long reviewSn) throws Exception;

    // 리뷰 수정
    int edit(ReviewVO reviewVO) throws Exception;

    // 리뷰 삭제
    int delete(ReviewVO reviewVO) throws Exception;

    // 제품명으로 리뷰 검색
    List<ReviewVO> searchByProductName(String productName) throws Exception;

    // 제품 번호로 리뷰 조회
    List<ReviewVO> selectReviewsByProduct(Long prdSn);  // 여기서 파라미터 타입을 Long으로 수정

    String selectProductNameBySn(Long prdSn);  
    String selectProductDescriptionBySn (Long prdSn); 
    
    
}
