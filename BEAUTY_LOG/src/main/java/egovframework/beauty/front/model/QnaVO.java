package egovframework.beauty.front.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class QnaVO {
    private int userSn;
    private int qnaId;
    private String title;
    private String content;
    private String userId;
    private String fileName;
    private Date createdAt;
    private Date updatedAt;
    private int viewCount;
    private boolean status = true;

    public LocalDateTime getCreatedAtAsLocalDateTime() {
        return createdAt != null ? createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }

    public LocalDateTime getUpdatedAtAsLocalDateTime() {
        return updatedAt != null ? updatedAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }

    public boolean isStatus() {
        return status;
    }
}
