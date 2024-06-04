package org.choongang.attendance.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.services.AttendanceServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.template.Templates;

import java.time.LocalDateTime;


public class RegisterAttendanceController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(AttendanceMenu.REGISTER);
    }

    @Override
    public void prompt() {
        try {
            System.out.println("💛출석등록💛");
            String studentNo = promptWithValidation("학번을 입력하세요: ", s -> !s.isBlank());
            String today = promptWithValidation("오늘날짜를 입력하세요: ", s -> !s.isBlank());
            String attendanceDate = promptWithValidation("출석일수를 입력하세요: ", s -> !s.isBlank());
            String attendanceStatus = promptWithValidation("출석상태를 입력하세요: ", s -> !s.isBlank());
            String classId = promptWithValidation("과정명을 입력하세요: ", s -> !s.isBlank());

            Service<Attendance> service = AttendanceServiceLocator.getInstance().find(AttendanceMenu.REGISTER);

            Attendance form = Attendance.builder()
                    .studentNo(Integer.parseInt(studentNo))
                    .today(LocalDateTime.now().withDayOfMonth(Integer.parseInt(today)))
                    .attendanceDate(Integer.parseInt(attendanceDate))
                    .attendanceStatus(attendanceStatus)
                    .classId(classId)
                    .build();

            service.process(form);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
