package egovframework.beauty.front.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {

    private int commentId;       // 댓글 ID
    private int qnaId;           // Q&A 글 ID (외래키)
    private int userSn; 
    private String userId;       // 작성자
    private String content;      // 댓글 내용
    private Timestamp createdAt; // 생성일
    private Timestamp updatedAt; // 수정일
}
