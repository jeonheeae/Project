package egovframework.beauty.front.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {
    private int userSn;
    private String userId;
    private String userPwd;
    private String userName;
    private String userEmail;
    private String userPhone;
    private boolean status; // boolean 그대로 유지
    private Timestamp createdAt; // Timestamp로 수정
    private Timestamp updatedAt; // Timestamp로 수정

    // createdAt을 LocalDateTime으로 변환하는 메서드
    public LocalDateTime getCreatedAtAsLocalDateTime() {
        return createdAt != null ? createdAt.toLocalDateTime() : null;
    }

    // updatedAt을 LocalDateTime으로 변환하는 메서드
    public LocalDateTime getUpdatedAtAsLocalDateTime() {
        return updatedAt != null ? updatedAt.toLocalDateTime() : null;
    }

    // boolean 타입의 status에 대해 isStatus()로 getter 메서드 사용
    public boolean isStatus() {
        return status;
    }
}
