package org.choongang.notice.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

import static org.choongang.global.constants.MainMenu.NOTICE;

public class NoticeControllersLocator implements ControllerLocator {

    private static ControllerLocator instance;

    private Map<MainMenu, Controller> controllers;

    private NoticeControllersLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new NoticeControllersLocator();
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
            case NOTICE: controller = new NoticeController(); break;
            default: controller = new MainController();
        }

        controllers.put(menu,controller);

        return controller;
    }
}
