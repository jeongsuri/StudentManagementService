package org.choongang.attendance.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.services.AttendanceServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;

public class ListAttandanceController extends AbstractController {
    @Override
    public void show() {
        System.out.println("💛출석 조회💛");
    }

    @Override
    public void prompt() {
        Service<Attendance> service = AttendanceServiceLocator.getInstance().find(AttendanceMenu.SEARCH);
        service.process();

    }
}
