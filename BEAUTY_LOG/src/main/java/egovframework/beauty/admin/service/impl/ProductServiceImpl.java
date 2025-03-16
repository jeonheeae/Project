package egovframework.beauty.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.beauty.admin.model.ProductVO;
import egovframework.beauty.admin.service.ProductService;
import egovframework.beauty.admin.service.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductMapper productMapper;

	// 상품 목록
	@Override
	public List<ProductVO> list(ProductVO productVO) throws Exception {
		return	productMapper.list(productVO);
	}

	// 상품 목록 개수
	@Override
	public int listCnt(ProductVO productVO) throws Exception {
		return	productMapper.listCnt(productVO);
	}

	// 상품 등록
	@Override
	public int add(ProductVO productVO) throws Exception {
		return productMapper.add(productVO);
	}

	// 상품 수정 화면
	@Override
	public ProductVO get(ProductVO productVO) throws Exception {
		return productMapper.get(productVO);
	}

	// 상품 수정 처리
	@Override
	public int edit(ProductVO productVO) throws Exception {
		return productMapper.edit(productVO);
	}

	// 상품 삭제
	@Override
	public int delete(ProductVO productVO) throws Exception {
		return productMapper.delete(productVO);
	}

}
