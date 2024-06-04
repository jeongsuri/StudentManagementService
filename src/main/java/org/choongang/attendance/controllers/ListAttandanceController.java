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
        Service<List<Attendance>> service = AttendanceServiceLocator.getInstance().find(AttendanceMenu.SEARCH);
        List<Attendance> items = service.process();

        Templates.getInstance().render(AttendanceMenu.SEARCH);

        System.out.println("학번     |     오늘날짜      |   출석일수  |  당일 출석  |  과정명");
        for(Attendance item : items) {
            System.out.printf("%d       %s      %s           %s%n", item.getStudentNo(), item.getToday(), item.getAttendanceDate(), item.getAttendanceStatus(), item.getClassId());
        }
    }

    @Override
    public void prompt() {



    }
}
