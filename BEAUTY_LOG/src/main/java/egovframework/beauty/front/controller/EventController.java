package egovframework.beauty.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import egovframework.beauty.front.service.EventService;

@RequestMapping(value="front")
@Controller("frontEventController")
public class EventController {

    @Autowired
    @Qualifier("frontEventServiceImpl")
    private EventService eventService;

    // 이벤트 페이지 진입
    @RequestMapping(value="/event.do", method = {RequestMethod.GET})
    public ModelAndView event(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        ModelAndView mav = new ModelAndView("front/event/event");

        Integer userSn = (Integer) session.getAttribute("userSn");

        // 오늘 날짜 정보
        LocalDate today = LocalDate.now();
        int month = today.getMonthValue();
        int lastDayOfMonth = today.lengthOfMonth();

        // 출석 정보는 로그인한 경우에만 조회
        List<Integer> attendedDays = new ArrayList<>();
        StringBuilder sb = new StringBuilder(",");
        if (userSn != null) {
            attendedDays = eventService.getAttendedDays(userSn, today.getYear(), month);
            for (Integer day : attendedDays) {
                if (day != null) {
                    sb.append(String.format("%02d", day)).append(",");
                }
            }
        }

        Set<Integer> attendedDaySet = attendedDays.stream()
                .filter(day -> day != null && day > 0)
                .collect(Collectors.toSet());

        // 출석 횟수 계산
        int attendanceCount = attendedDays.size();  // 출석한 날짜 수를 계산

        // ModelAndView에 데이터 추가
        mav.addObject("attendedDaySet", attendedDaySet);
        mav.addObject("attendedDaysListAsString", sb.toString());
        mav.addObject("month", month);
        mav.addObject("today", today.getDayOfMonth());
        mav.addObject("lastDayOfMonth", lastDayOfMonth);
        mav.addObject("attendedDays", attendedDays);
        mav.addObject("attendanceCount", attendanceCount);  // 출석 횟수 추가

        return mav;
    }

    // 출석체크 처리
    @RequestMapping(value="/attendanceCheck.do", method = {RequestMethod.POST})
    public void attendanceCheck(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Integer userSn = (Integer) session.getAttribute("userSn");

        response.setContentType("text/html; charset=UTF-8;");
        PrintWriter writer = response.getWriter();

        // 로그인 안했을 때 처리
        if(userSn == null) {
            writer.println("<script>alert('로그인이 필요합니다.'); location.href='/BEAUTY_LOG/front/login.do';</script>");
            writer.flush();
            writer.close();
            return;
        }

        // 출석체크 처리
        String result = eventService.attendanceCheck(userSn);

        writer.println("<script>alert('"+ result +"'); location.href='/BEAUTY_LOG/front/event.do';</script>");
        writer.flush();
        writer.close();
    }

}
