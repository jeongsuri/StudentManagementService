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
    public void prompt() { // 사용자로부터 DB에 저장할 데이터 입력값 받기 -> RegisterAttendanceService에서 DB에 저장
        try {
            System.out.println("💛출석등록💛"); // 학번(PK + FK), 출석일수 (PK), 과정명 (FK)
            String studentNo = promptWithValidation("학번을 입력하세요(1번으로 고정): ", s -> !s.isBlank());
            String today = promptWithValidation("오늘날짜를 입력하세요(아무 숫자 입력해도 자동으로 오늘날짜가 기입됩니다): ", s -> !s.isBlank());
            String attendanceDate = promptWithValidation("출석일수를 입력하세요: ", s -> !s.isBlank());
            String attendanceStatus = promptWithValidation("출석상태를 입력하세요(출석/결석): ", s -> !s.isBlank());
            String classId = promptWithValidation("과정명을 입력하세요(1번으로 고정): ", s -> !s.isBlank());

            Service<Attendance> service = AttendanceServiceLocator.getInstance().find(AttendanceMenu.REGISTER);

            Attendance form = Attendance.builder()
                    // 매개변수가 스캐너에선 String형태로 기입되기 때문에 DB에 만든 테이블 자료형에 맞게 자료형 변환해줌
                    .studentNo(Integer.parseInt(studentNo))
                    .today(LocalDateTime.now().withDayOfMonth(Integer.parseInt(today)))
                    .attendanceDate(Integer.parseInt(attendanceDate))
                    .attendanceStatus(attendanceStatus)
                    .classId(classId)
                    .build();

            service.process(form); // 서비스에서 저장
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
