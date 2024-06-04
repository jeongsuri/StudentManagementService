package org.choongang.attendance.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.services.AttendanceServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.template.Templates;

import java.util.List;

public class ListAttandanceController extends AbstractController {
    @Override
    public void show() {
        // ListAttendanceService에서 DB에 저장된 데이터 조회한것을(SELECT) 여기서 출력
        // 원래는 뷰 즉 tpl에서 출력물을 보여주도록 해야 하지만 시간이 부족하여
        // ListAttandanceController에서 구현하도록 코드 구성
        Service<List<Attendance>> service = AttendanceServiceLocator.getInstance().find(AttendanceMenu.SEARCH);
        List<Attendance> items = service.process(); // 서비스에서 조회

        Templates.getInstance().render(AttendanceMenu.SEARCH);

        System.out.println("학번     |     오늘날짜      |   출석일수   |  당일 출석   |   과정명");
        for(Attendance item : items) {
            System.out.printf("%d       %s      %s             %s           %s%n", item.getStudentNo(), item.getToday(), item.getAttendanceDate(), item.getAttendanceStatus(), item.getClassId());
        }
    }

    @Override
    public void prompt() {
    }
}
