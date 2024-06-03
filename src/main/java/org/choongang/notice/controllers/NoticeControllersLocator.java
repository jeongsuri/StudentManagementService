package org.choongang.notice.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;

import java.util.HashMap;
import java.util.Map;

import static org.choongang.global.constants.MainMenu.NOTICE;

public class NoticeControllersLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private NoticeControllersLocator(){

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


        controllers.put(menu,controller);

        return controller;
    }
}
