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
public class JoinVO {
    private int userSn;
    private String userId;
    private String userPwd;
    private String confirmPwd;  // confirmPwd를 명시적으로 추가 (회원가입 시 비밀번호 확인용)
    private String userName;
    private String userEmail;
    private String userPhone;
    private boolean status = true; // 기본 값은 true
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // LocalDateTime 변환 메서드
    public LocalDateTime getCreatedAtAsLocalDateTime() {
        return createdAt != null ? createdAt.toLocalDateTime() : null;
    }

    public LocalDateTime getUpdatedAtAsLocalDateTime() {
        return updatedAt != null ? updatedAt.toLocalDateTime() : null;
    }

    // isStatus() 메서드는 boolean 타입 그대로 사용하는 것이 좋습니다
    public boolean isStatus() {
        return status;
    }
}

