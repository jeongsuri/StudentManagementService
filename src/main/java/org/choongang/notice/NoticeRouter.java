package org.choongang.notice;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainControllerLocator;
import org.choongang.notice.constants.NoticeMenu;
import org.choongang.notice.controllers.NoticeControllerLocator;

public class NoticeRouter implements Router {

    /**
     * 싱글톤 패턴, 메뉴 컨트롤러가 변경될때마다 새로운 객체를 만들어지는것을 방지
     */
    private static Router instance;
    private NoticeRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new NoticeRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        NoticeMenu noticeMenu = (NoticeMenu)menu;

        Controller controller = null;
        ControllerLocator locator = NoticeControllerLocator.getInstance();
        ControllerLocator mainLocator = MainControllerLocator.getInstance();
        switch(noticeMenu) {
            case NOTICE_WRITE: controller = locator.find(NoticeMenu.NOTICE_WRITE); break;
            case NOTICE_LIST: controller = locator.find(NoticeMenu.NOTICE_LIST); break;
            default : controller = mainLocator.find(MainMenu.MAIN);
        }

        if (controller != null) {
            controller.run();
        }
    }
}
