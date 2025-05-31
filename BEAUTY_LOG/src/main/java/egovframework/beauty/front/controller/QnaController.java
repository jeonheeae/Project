package egovframework.beauty.front.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String getQnaList(@RequestParam(value = "page", defaultValue = "1") int page, ModelMap model) {
        int size = 10;
        try {
            List<QnaVO> qnaList = qnaService.getQnaListWithPaging(page, size);
            int totalCount = qnaService.getTotalCount();
            int totalPages = (int) Math.ceil((double) totalCount / size);

            model.addAttribute("qnaList", qnaList);
            model.addAttribute("page", page);
            model.addAttribute("totalPages", totalPages);
        } catch (Exception e) {
            model.addAttribute("error", "게시글 목록을 가져오는 데 실패했습니다.");
        }
        return "front/qna/qna";
    }

    // Q&A 상세 페이지
    @RequestMapping(value = "/qnadetail.do", method = RequestMethod.GET)
    public String getQnaDetail(@RequestParam("qnaId") int qnaId, ModelMap model) {
        try {
            qnaService.updateQnaViewCount(qnaId);
            QnaVO qnaDetail = qnaService.getQnaDetail(qnaId);

            model.addAttribute("qnaDetail", qnaDetail);
            model.addAttribute("comments", qnaService.getCommentsByQnaId(qnaId));
        } catch (Exception e) {
            model.addAttribute("error", "게시글을 가져오는 데 실패했습니다.");
        }
        return "front/qna/qnadetail";
    }

    // Q&A 글쓰기 페이지 (GET)
    @RequestMapping(value = "/qnaWrite.do", method = RequestMethod.GET)
    public String getQnaWritePage() {
        return "front/qna/qnaWrite";
    }

    // Q&A 글쓰기 처리 (POST)
    @RequestMapping(value = "/qnaWrite.do", method = RequestMethod.POST)
    public String postQnaWrite(HttpSession session,
                               @ModelAttribute QnaVO qnaVO,
                               @RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile,
                               ModelMap model) {

        String userId = (String) session.getAttribute("userId");
        Integer userSn = (Integer) session.getAttribute("userSn");

        if (userId == null || userSn == null) {
            return "redirect:/login.do";  // ✅ 수정됨
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

    // 댓글 작성 처리
    @RequestMapping(value = "/writeComment.do", method = RequestMethod.POST)
    public String postComment(HttpSession session, @ModelAttribute("CommentVO") CommentVO commentVO) {
        Integer userSn = (Integer) session.getAttribute("userSn");

        if (userSn == null) {
            return "redirect:/login.do";  // ✅ 수정됨
        }

        commentVO.setUserSn(userSn);

        try {
            qnaService.writeComment(commentVO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/front/qnadetail.do?qnaId=" + commentVO.getQnaId();
    }

    // 첨부파일 다운로드 처리
    @RequestMapping(
        value = "/qnaDownload.do",
        method = RequestMethod.GET,
        produces = "application/octet-stream"
    )
    public ResponseEntity<Resource> downloadQnaFile(@RequestParam("fileName") String fileName) throws IOException {
        String uploadDir = "C:/uploadPath/";
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            throw new IOException("파일을 찾을 수 없거나 읽을 수 없습니다: " + fileName);
        }

        String encodedName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedName + "\"")
            .header(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate")
            .header(HttpHeaders.PRAGMA, "no-cache")
            .header(HttpHeaders.EXPIRES, "0")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(resource);
    }
}
