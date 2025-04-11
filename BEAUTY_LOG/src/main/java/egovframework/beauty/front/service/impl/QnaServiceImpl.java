package egovframework.beauty.front.service.impl;

import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.beauty.front.model.QnaVO;
import egovframework.beauty.front.model.CommentVO;
import egovframework.beauty.front.service.QnaService;
import egovframework.beauty.front.service.mapper.QnaMapper;

@Service("frontQnaServiceImpl")
public class QnaServiceImpl implements QnaService {

    @Autowired
    private QnaMapper qnaMapper;
    
    @Override
    public void updateQnaViewCount(int qnaId) throws Exception {
        qnaMapper.updateQnaViewCount(qnaId);
    }
    
    
    // Q&A 게시글 목록 조회
    @Override
    public List<QnaVO> getAllQna() throws Exception {
        return qnaMapper.list(new QnaVO()); // QnaVO 객체를 인자로 전달
    }

    // Q&A 게시글 상세 조회
    @Override
    public QnaVO getQnaDetail(int qnaId) throws Exception {
        QnaVO qnaVO = new QnaVO();
        qnaVO.setQnaId(qnaId);
        return qnaMapper.get(qnaVO);
    }

    // Q&A 게시글 작성
    @Override
    public int writeQna(QnaVO qnaVO, MultipartFile uploadFile) throws Exception {

        // 1. 파일 업로드 처리
        if (uploadFile != null && !uploadFile.isEmpty()) {
            String originalFileName = uploadFile.getOriginalFilename();
            String uploadPath = "C:/uploadPath/"; // 파일 저장 경로 (원하는 경로로 변경 가능)

            File destFile = new File(uploadPath + originalFileName);
            uploadFile.transferTo(destFile);  // 실제 파일 저장

            // VO에 파일명 세팅 (DB에 넣을 값)
            qnaVO.setFileName(originalFileName);
        }

        // 2. DB Insert 처리
        return qnaMapper.add(qnaVO);
    }


    // Q&A 게시글 수정
    @Override
    public int editQna(QnaVO qnaVO) throws Exception {
        return qnaMapper.edit(qnaVO); // edit() 메소드 호출
    }

    // Q&A 게시글 삭제
    @Override
    public int deleteQna(int qnaId) throws Exception {
        return qnaMapper.delete(qnaId); // delete() 메소드 호출
    }

    // 댓글 목록 조회
    @Override
    public List<CommentVO> getCommentsByQnaId(int qnaId) throws Exception {
        return qnaMapper.listCommentsByQnaId(qnaId); // listCommentsByQnaId() 메소드 호출
    }

    // 댓글 작성
    @Override
    public int writeComment(CommentVO commentVO) throws Exception {
        return qnaMapper.addComment(commentVO); // addComment() 메소드 호출
    }

    // 댓글 수정
    @Override
    public int editComment(CommentVO commentVO) throws Exception {
        return qnaMapper.editComment(commentVO); // editComment() 메소드 호출
    }

    // 댓글 삭제
    @Override
    public int deleteComment(int commentId) throws Exception {
        return qnaMapper.deleteComment(commentId); // deleteComment() 메소드 호출
    }
}
