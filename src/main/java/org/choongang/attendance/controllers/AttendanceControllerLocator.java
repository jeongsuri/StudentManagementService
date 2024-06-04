package org.choongang.attendance.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

    // AttendanceControllerLocator : 컨트롤러를 객체 생성 및 반환(개방 폐쇄 원칙)
public class AttendanceControllerLocator extends AbstractControllerLocator {
    // AttendanceControllerLocator를 싱글톤 패턴으로 객체생성과 동시에 ControllerLocator(상위클래스)로 자료형제한 -> 다형성
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

        if (controller != null) { // controller가 있으면 controller객체를 반환
            return controller;
        }

        AttendanceMenu aMenu = (AttendanceMenu) menu;
        switch (aMenu) {
            case REGISTER: controller = new RegisterAttendanceController(); break;
            case SEARCH: controller = new ListAttandanceController(); break;
        }

        controllers.put(menu, controller);

        return controller;
    }
}

