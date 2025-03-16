package egovframework.beauty.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.admin.model.ProductVO;
import egovframework.beauty.admin.service.ProductService;

@RequestMapping(value="admin")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// 상품 정보 관리
	@RequestMapping(value="/product/list.do", method = {RequestMethod.GET})
	public ModelAndView list(
			HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("ProductVO") ProductVO productVO
			
			)throws Exception {
		ModelAndView mav = new ModelAndView("admin/product/list");
		// 페이징 기능 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(productVO.getPageIndex());  //현재 페이지
		paginationInfo.setRecordCountPerPage(10);					//페이지당 10개씩 나열	
		paginationInfo.setPageSize(productVO.getPageSize());		// 페이지 개수
		
		// VO에 page 관련 데이터 삽입
		productVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		productVO.setLastIndex(paginationInfo.getLastRecordIndex());
		productVO.setPageUnit(paginationInfo.getRecordCountPerPage());
		
		// 상품 목록 데이터 가져오기
		List<ProductVO> list = productService.list(productVO); // 목록
		int listCnt = productService.listCnt(productVO);	// 목록 개수
		
		// 페이징 총개수
		paginationInfo.setTotalRecordCount(listCnt);
		
		// jsp로 데이터 넘기기
		mav.addObject("list", list);
		mav.addObject("listCnt", listCnt);
		mav.addObject("paginationInfo", paginationInfo);
		
		return mav;
	}
	
	// 상품 정보 등록 화면
	@RequestMapping(value="/product/post.do", method = {RequestMethod.GET})
	public ModelAndView post(
			HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			)throws Exception {
		ModelAndView mav = new ModelAndView("admin/product/post");
		
		return mav;
	}
	
	// 상품 정보 등록 처리
	@RequestMapping(value="/product/post.do", method = {RequestMethod.POST})
	public String doPost(
			HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("ProductVO") ProductVO productVO
			)throws Exception {
		
		try {
			int rs = productService.add(productVO);
			
			return "redirect:list.do";
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirec:list.do";
	}
	
	// 상품 정보 수정 화면
	@RequestMapping(value="/product/edit.do", method = {RequestMethod.GET})
	public ModelAndView edit(
			HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("ProductVO") ProductVO productVO
			)throws Exception {
		ModelAndView mav = new ModelAndView("admin/product/edit");
		
		ProductVO rs = productService.get(productVO);
		
		mav.addObject("rs", rs);
		
		return mav;
	}
	
	// 상품 정보 수정 처리
	@RequestMapping(value="/product/edit.do", method = {RequestMethod.POST})
	public String doEdit(
			HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("ProductVO") ProductVO productVO
			)throws Exception {
		
		try {
			int rs = productService.edit(productVO);
			
			return "redirect:list.do";
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirec:list.do";
	}
	
	// 상품 정보 삭제
	@RequestMapping(value="/product/delete.do", method = {RequestMethod.POST})
	public String doDelete(
			ModelMap model
			, HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, @ModelAttribute("ProductVO") ProductVO productVO
			)throws Exception {
		
		try {
			int rs = productService.delete(productVO);

			model.addAttribute("rs", rs);
			return "jsonView";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
		
	}
}
