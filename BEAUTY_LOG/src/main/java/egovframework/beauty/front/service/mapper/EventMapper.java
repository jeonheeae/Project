package egovframework.beauty.front.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("frontEventMapper")
public interface EventMapper {

    // 오늘 출석했는지 확인
    int checkTodayAttendance(int userSn) throws Exception;

    // 출석 데이터 INSERT
    void insertAttendance(int userSn) throws Exception;

    // 총 출석일수 조회
    int getAttendanceCount(int userSn) throws Exception;

    // 100P 지급
    void insertCouponPoint(int userSn) throws Exception;

    // 5% 할인쿠폰 지급
    void insertCouponDiscount(int userSn) throws Exception;

    // 1+1 이벤트 쿠폰 지급
    void insertCouponEvent(int userSn) throws Exception;

    // 🆕 출석한 일(day)만 가져오기
    List<Integer> selectAttendedDays(
        @Param("userSn") int userSn,
        @Param("year") int year,
        @Param("month") int month
    ) throws Exception;
}
