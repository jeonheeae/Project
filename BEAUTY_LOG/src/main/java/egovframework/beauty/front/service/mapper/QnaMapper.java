package egovframework.beauty.front.service.mapper;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.beauty.front.model.QnaVO;
import egovframework.beauty.front.model.CommentVO;

@Mapper("QnaMapper")
public interface QnaMapper {

    // Q&A 게시글 목록 조회
    List<QnaVO> list(QnaVO qnaVO) throws Exception;

    // Q&A 게시글 목록 개수 조회
    int listCnt(QnaVO qnaVO) throws Exception;

    // Q&A 게시글 상세 조회
    QnaVO get(QnaVO qnaVO) throws Exception;

    // Q&A 게시글 등록
    int add(QnaVO qnaVO) throws Exception;

    // Q&A 게시글 수정
    int edit(QnaVO qnaVO) throws Exception;

    // Q&A 게시글 삭제
    int delete(int qnaId) throws Exception;

    // 댓글 목록 조회
    List<CommentVO> listCommentsByQnaId(int qnaId) throws Exception;

    // 댓글 등록
    int addComment(CommentVO commentVO) throws Exception;

    // 댓글 수정
    int editComment(CommentVO commentVO) throws Exception;

    // 댓글 삭제
    int deleteComment(int commentId) throws Exception;

    // 조회수 증가
    void updateQnaViewCount(int qnaId) throws Exception; // 조회수 증가를 위한 메서드
}
