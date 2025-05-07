package egovframework.beauty.front.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import egovframework.beauty.front.model.QnaVO;
import egovframework.beauty.front.model.CommentVO;

@Service("frontQnaService")
public interface QnaService {

	void updateQnaViewCount(int qnaId) throws Exception;
	
	// Q&A 게시글 목록
    List<QnaVO> getAllQna() throws Exception;

    // Q&A 게시글 상세 조회
    QnaVO getQnaDetail(int qnaId) throws Exception;
    
    // Q&A 게시글 작성 (파일 업로드 포함)
    int writeQna(QnaVO qnaVO, MultipartFile uploadFile) throws Exception;

    // Q&A 게시글 수정
    int editQna(QnaVO qnaVO) throws Exception;

    // Q&A 게시글 삭제
    int deleteQna(int qnaId) throws Exception;

    // 댓글 목록 조회
    List<CommentVO> getCommentsByQnaId(int qnaId) throws Exception;

    // 댓글 작성
    int writeComment(CommentVO commentVO) throws Exception;

    // 댓글 수정
    int editComment(CommentVO commentVO) throws Exception;

    // 댓글 삭제
    int deleteComment(int commentId) throws Exception;

    List<QnaVO> getQnaListWithPaging(int page, int size) throws Exception;

    int getTotalCount() throws Exception;
}
