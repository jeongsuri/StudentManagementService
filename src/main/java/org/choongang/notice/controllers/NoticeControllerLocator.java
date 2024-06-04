package org.choongang.notice.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.notice.constants.NoticeMenu;


public class NoticeControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private NoticeControllerLocator(){

    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new NoticeControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        NoticeMenu noticeMenu = (NoticeMenu)menu;
        switch(noticeMenu) {
            case NOTICE_WRITE: controller = new NoticeRegisterController(); break;
            case NOTICE_LIST: controller = new NoticeListController(); break;
        }
        controllers.put(menu,controller);

        return controller;
    }

}
