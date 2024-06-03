package org.choongang.student.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

import static org.choongang.global.constants.MainMenu.STUDENT;

public class StudentControllersLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<MainMenu, Controller> controllers;

    private StudentControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new StudentControllersLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }
        switch(menu) {
            case STUDENT: controller = new StudentController(); break;
            default: controller = new MainController();
        }

        controllers.put(menu,controller);

        return controller;
    }

}
