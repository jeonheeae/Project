package egovframework.beauty.front.service;

import java.util.List;

public interface EventService {

    String attendanceCheck(int userSn) throws Exception;
    int attendance(int userSn) throws Exception;
    List<Integer> getAttendedDays(int userSn, int year, int month) throws Exception;

}
