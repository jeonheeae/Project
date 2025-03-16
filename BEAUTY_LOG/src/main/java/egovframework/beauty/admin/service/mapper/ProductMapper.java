package egovframework.beauty.admin.service.mapper;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.beauty.admin.model.ProductVO;

@Mapper("ProductMapper")
public interface ProductMapper {

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
