package org.choongang.attendance.controllers;


import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractController;
import org.choongang.template.Templates;


public class InsertAttendanceController extends AbstractController {
    @Override
    public void common() {
        System.out.println("common 출석");
    }

    @Override
    public void show() {
        Templates.getInstance().render(AttendanceMenu.INSERT);
    }

    @Override
    public void prompt() {
        String today = promptWithValidation("오늘날짜를 입력하세요: ", s -> !s.isBlank());
        String classId = promptWithValidation("과정명을 입력하세요: ", s -> !s.isBlank());
        String studentNo = promptWithValidation("학번을 입력하세요: ", s -> !s.isBlank());
        String attendanceDate = promptWithValidation("출석일수를 입력하세요: ", s -> !s.isBlank());
        String attendanceState = promptWithValidation("출석상태를 입력하세요: ", s -> !s.isBlank());
    }

    RequestInsertAttendance form = RequestInsertAttendance.builder()
            .today(today)
            .classId(classId)
            .studentNo(studentNo)
            .attendanceDate(attendanceDate)
            .attendanceState(attendanceState)
            .build();

}
