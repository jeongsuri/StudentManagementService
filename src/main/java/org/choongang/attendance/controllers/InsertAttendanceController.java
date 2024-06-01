package org.choongang.attendance.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

public class InsertAttendanceController extends AbstractController {
    @Override
    public void common() {
        System.out.println("common 출석");
    }

    @Override
    public void show() {

    }

    @Override
    public void prompt() {
        String today = promptWithValidation("오늘날짜를 입력하세요: ", s -> !s.isBlank());
        String classId = promptWithValidation("과정명을 입력하세요: ", s -> !s.isBlank());
        String studentNo = promptWithValidation("학번을 입력하세요: ", s -> !s.isBlank());
        String attendanceDate = promptWithValidation("출석일수를 입력하세요: ", s -> !s.isBlank());
        String attendanceState = promptWithValidation("출석상태를 입력하세요: ", s -> !s.isBlank());
    }
    RequestInsertAttendance form = RequestInsertAttendance.builder() // 사용자가 입력한 값을 담는 역할 <- 사용자 요청 데이터
            .today(today)
            .classId(classId)
            .studentNo(studentNo)
            .attendanceDate(attendanceDate)
            .attendanceStatus(attendanceStatus)
            .build(); // 전달용 객체 DTO (why? 전달하기 위해서) -> 컨트롤러에 유입
    Router router = MainRouter.getInstance();

        try {
        Service service = AttendanceServiceLocator.getInstance().find(Menu.MAIN);
        service.process(form);

    } catch (RuntimeException e) {
        System.err.println(e.getMessage());
    }
}
