package org.choongang.seat.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

public class SeatControllersLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<MainMenu, Controller> controllers;

    private SeatControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new SeatControllersLocator();
        }
        return instance;
    }

    @Override
    public Controller find(MainMenu mainMenu) {
        Controller controller = controllers.get(mainMenu);
        if (controller != null) {
            return controller;
        }
        switch(mainMenu) {
            case SEAT: controller = new SeatController(); break;
            default: controller = new MainController();
        }

        controllers.put(mainMenu,controller);

        return controller;
    }

}
