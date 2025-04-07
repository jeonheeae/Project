package egovframework.beauty.front.service;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.beauty.admin.model.ProductVO;

@Service
public interface ProductService {

	// 상품 목록
	List<ProductVO> list(ProductVO productVO) throws Exception;

	// 상품 목록 개수
	int listCnt(ProductVO productVO) throws Exception;

	// 상품 등록
	int add(ProductVO productVO) throws Exception;

	// 상품 수정 화면
	ProductVO get(ProductVO productVO) throws Exception;

	// 상품 수정 처리
	int edit(ProductVO productVO) throws Exception;

	// 상품 삭제
	int delete(ProductVO productVO) throws Exception;

}
