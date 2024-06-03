package org.choongang.pay.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

import static org.choongang.global.constants.MainMenu.SEAT;

public class PayControllersLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;


    private PayControllersLocator(){

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
        switch((MainMenu)menu) {
            case PAY: controller = new PayController(); break;
            default: controller = new MainController();
        }



        controllers.put(menu,controller);

        return controller;
    }

}
