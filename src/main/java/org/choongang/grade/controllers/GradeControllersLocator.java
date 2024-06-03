package org.choongang.grade.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;
import org.choongang.student.controllers.StudentController;
import org.choongang.student.controllers.StudentControllersLocator;

import java.util.HashMap;
import java.util.Map;

public class GradeControllersLocator implements ControllerLocator {
    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private GradeControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new GradeControllersLocator();
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
