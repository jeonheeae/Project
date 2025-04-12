package egovframework.beauty.front.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceVO {
    private int attendanceId;
    private int userSn;
    private Date attendanceDate;
    private Date createdAt;
}
