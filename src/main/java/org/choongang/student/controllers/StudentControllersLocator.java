package org.choongang.student.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.student.constants.StudentMenu;

public class StudentControllersLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private StudentControllersLocator(){

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

        StudentMenu studentMenu = (StudentMenu)menu;
        switch(studentMenu) {
            case REGISTER: controller = new StudentRegisterController(); break;
            case SEARCH: controller = new StudentListController(); break;
        }
        controllers.put(menu,controller);

        return controller;
    }

}
