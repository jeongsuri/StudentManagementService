package org.choongang.main.controllers;

import org.choongang.attendance.controllers.AttendanceController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.grade.controllers.GradeController;
import org.choongang.notice.controllers.NoticeController;
import org.choongang.pay.controllers.PayController;
import org.choongang.reservation.controllers.ReservationController;
import org.choongang.seat.controllers.SeatController;
import org.choongang.student.controllers.StudentController;

public class MainControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    public static ControllerLocator getInstance() {
        if (instance == null) {
            instance = new MainControllerLocator();
        }

        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }


        MainMenu mainMenu = (MainMenu) menu;
        switch(mainMenu) {
            case STUDENT: controller = new StudentController(); break;
            case ATTENDANCE: controller = new AttendanceController(); break;
            case PAY: controller = new PayController(); break;
            case SCORE: controller = new GradeController(); break;
            case RESERVATION: controller = new ReservationController(); break;
            case SEAT: controller = new SeatController(); break;
            case NOTICE: controller = new NoticeController(); break;
            default:
                controller = new MainController();
        }


        controllers.put(menu, controller);

        return controller;
    }
}
