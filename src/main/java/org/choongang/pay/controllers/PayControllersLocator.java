package org.choongang.pay.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

public class PayControllersLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private PayControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new PayControllersLocator();
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
            case PAY: controller = new PayController(); break;
            default: controller = new MainController();
        }

        controllers.put(menu,controller);

        return controller;
    }

}
