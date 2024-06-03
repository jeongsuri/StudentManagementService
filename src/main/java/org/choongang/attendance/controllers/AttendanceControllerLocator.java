package org.choongang.attendance.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.*;
import org.choongang.main.controllers.MainController;
import java.util.HashMap;
import java.util.Map;


public class AttendanceControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private AttendanceControllerLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new AttendanceControllerLocator();
        }
        return instance;
    }


    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);

        if (controller != null) {
            return controller;
        }

        if (menu instanceof AttendanceMenu) {
            AttendanceMenu attendanceMenu = (AttendanceMenu) menu;

            switch (attendanceMenu) {
                case INSERT:
                    controller = new InsertAttendanceController();
                    break;
                case SELECT:
                    controller = new SelectAttendanceController();
                    break;
                case DELETE:
                    controller = new DeleteAttendanceController();
                    break;
            }

        }
                else {
                controller = new MainController();
            }

            //controller.setMenu(menu);

            controllers.put(menu, controller);

            return controller;
        }
}

