package org.choongang.attendance.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;


public class AttendanceControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private AttendanceControllerLocator(){

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

        AttendanceMenu aMenu = (AttendanceMenu) menu;
        switch (aMenu) {
            case REGISTER: controller = new InsertAttendanceController(); break;
            case SEARCH: controller = new ListAttandanceController(); break;
        }

        controllers.put(menu, controller);

        return controller;
    }
}

