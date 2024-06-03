package org.choongang.reservation.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

public class ReservationControllersLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<MainMenu, Controller> controllers;

    private ReservationControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new ReservationControllersLocator();
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
            case RESERVATION: controller = new ReservationController(); break;
            default: controller = new MainController();
        }

        controllers.put(mainMenu,controller);

        return controller;
    }

}
