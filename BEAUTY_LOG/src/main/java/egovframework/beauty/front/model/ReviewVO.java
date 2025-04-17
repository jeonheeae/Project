package egovframework.beauty.front.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReviewVO {

    private int reviewSn;
    private Long prdSn;
    private String prdNm;  
    private String prdDesc;
    private BigDecimal rating;
    private int reviewCount;
    private String writer;
    private String content;
    private int userSn;
    private Timestamp regDate;

    // 페이징 관련 필드 추가
    private int firstIndex;
    private int recordCountPerPage;

    public LocalDateTime getRegDateAsLocalDateTime() {
        return regDate != null ? regDate.toLocalDateTime() : null;
    }
}
