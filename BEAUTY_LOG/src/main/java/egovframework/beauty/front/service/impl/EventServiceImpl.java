package egovframework.beauty.front.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.beauty.front.service.EventService;
import egovframework.beauty.front.service.mapper.EventMapper;

@Service("frontEventServiceImpl")
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Override
    public String attendanceCheck(int userSn) throws Exception {
        int count = eventMapper.checkTodayAttendance(userSn);

        if (count > 0) {
            return "이미 출석체크 하셨습니다!";
        }

        eventMapper.insertAttendance(userSn);

        int attendanceDays = eventMapper.getAttendanceCount(userSn);

        String message = "출석완료! 오늘은 " + attendanceDays + "일째 출석입니다!";

        if (attendanceDays == 1) {
            eventMapper.insertCouponPoint(userSn);  // 100P 지급
            message += " 100P 지급!";
        } else if (attendanceDays == 15) {
            eventMapper.insertCouponDiscount(userSn);  // 5% 쿠폰 지급
            message += " 5% 할인쿠폰 지급!";
        } else if (attendanceDays == 30) {
            eventMapper.insertCouponEvent(userSn);  // 1+1 쿠폰 지급
            message += " 1+1 쿠폰 지급!";
        }

        return message;
    }


    @Override
    public int attendance(int userSn) throws Exception {
        return 0;
    }

    // ✅ 출석한 날짜 리스트 반환 (달력 표시용)
    @Override
    public List<Integer> getAttendedDays(int userSn, int year, int month) throws Exception {
        return eventMapper.selectAttendedDays(userSn, year, month);
    }
    
}
