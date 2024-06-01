package org.choongang.attendance.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;
import org.choongang.template.Template;

import java.util.HashMap;
import java.util.Map;

public class AttendanceControllersLocator extends AbstractController implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private AttendanceControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new AttendanceControllersLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        switch (menu) {
            case ATTENDANCE:
                System.out.println("");
                System.out.println("------------------------------------------");
                System.out.println("                  출석부");
                System.out.println("------------------------------------------");
                System.out.println("1: 출석 등록");
                System.out.println("2: 출석 조회");
                System.out.println("3: 출석 삭제");
                System.out.println("");
                System.out.print("메뉴를 선택해 주세요 : ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        controller = new InsertAttendanceController();
                        break;
                    case 2:
                        controller = new SelectAttendanceController();
                        break;
                    case 3:
                        controller = new DeleteAttendanceController();
                        break;
                    default:
                        controller = new MainController();
                        break;
                }
                break;
            default:
                controller = new MainController();
        }

        controllers.put(menu, controller);
        return controller;
    }

    @Override
    public void show() {

    }
}
