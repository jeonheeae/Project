package egovframework.beauty.admin.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO extends DefaultVO{

	private static final long serialVersionUID = 1L;
	
	private int prdSn;				// 상품 일련번호
	private String prdNm;			// 상품명
	private String prdDesc;			// 상품 설명
	private String prdThum;			// 상품 썸네일 경로
	
	

}
