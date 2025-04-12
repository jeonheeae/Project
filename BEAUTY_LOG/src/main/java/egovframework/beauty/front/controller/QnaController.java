package egovframework.beauty.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import egovframework.beauty.front.model.QnaVO;
import egovframework.beauty.front.model.CommentVO;
import egovframework.beauty.front.service.QnaService;

@Controller("frontQnaController")
@RequestMapping(value = "front")
public class QnaController {
	
    @Autowired
    private QnaService qnaService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    // Q&A 게시글 목록 페이지
    @RequestMapping(value = "/qna.do", method = RequestMethod.GET)
    public String getQnaList(ModelMap model) {
        try {
            model.addAttribute("qnaList", qnaService.getAllQna());  // 이게 조회수 반영된 목록
        } catch (Exception e) {
            model.addAttribute("error", "게시글 목록을 가져오는 데 실패했습니다.");
        }
        return "front/qna/qna";
    }

    // Q&A 게시글 상세 페이지
    @RequestMapping(value = "/qnadetail.do", method = RequestMethod.GET)
    public String getQnaDetail(@RequestParam("qnaId") int qnaId, ModelMap model) {
        try {
            // 1. 조회수 증가
            qnaService.updateQnaViewCount(qnaId);
            
            // 2. 상세 데이터 다시 조회
            QnaVO qnaDetail = qnaService.getQnaDetail(qnaId);
            System.out.println("조회수 확인 => " + qnaDetail.getViewCount());
            
            // 3. 화면에 전달
            model.addAttribute("qnaDetail", qnaDetail);
            model.addAttribute("comments", qnaService.getCommentsByQnaId(qnaId));
            
        } catch (Exception e) {
            model.addAttribute("error", "게시글을 가져오는 데 실패했습니다.");
        }
        
        return "front/qna/qnadetail";  // 상세 페이지로 이동
    }

    // Q&A 게시글 작성 화면 (GET)
    @RequestMapping(value = "/qnaWrite.do", method = RequestMethod.GET)
    public String getQnaWritePage() {
        return "front/qna/qnaWrite";  // 글쓰기 화면 JSP 경로
    }

    // Q&A 게시글 작성 처리 (POST)
    @RequestMapping(value = "/qnaWrite.do", method = RequestMethod.POST)
    public String postQnaWrite(HttpSession session,
                               @ModelAttribute QnaVO qnaVO, // 여기가 핵심
                               @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
                               ModelMap model) {

        String userId = (String) session.getAttribute("userId");
        Integer userSn = (Integer) session.getAttribute("userSn");

        if (userId == null || userSn == null) {
            return "redirect:/front/login.do";
        }

        qnaVO.setUserId(userId);
        qnaVO.setUserSn(userSn);
        qnaVO.setStatus(true);

        try {
            qnaService.writeQna(qnaVO, uploadFile);
            return "redirect:/front/qna.do";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "게시글 작성에 실패했습니다.");
            return "redirect:/front/qnaWrite.do";
        }
    }

    // 댓글 작성 처리 (POST)
    @RequestMapping(value = "/writeComment.do", method = RequestMethod.POST)
    public String postComment(HttpSession session, @ModelAttribute("CommentVO") CommentVO commentVO) {
        Integer userSn = (Integer) session.getAttribute("userSn");

        if (userSn == null) {
            return "redirect:/front/login.do";
        }

        commentVO.setUserSn(userSn);  // userSn 세팅

        try {
            qnaService.writeComment(commentVO);  // 댓글 작성
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 댓글 작성 후 상세보기로 리다이렉트
        return "redirect:/front/qnadetail.do?qnaId=" + commentVO.getQnaId();
    }
}

