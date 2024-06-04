package org.choongang.attendance;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.controllers.AttendanceControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;


    // AttendanceRouter : 각각의 메뉴에 맞는 컨트롤러 찾고 실행
public class AttendanceRouter implements Router {
    private static Router instance; // 싱글톤 패턴 통해 AttendanceRouter 객체 생성 및 자료형 제한
    private AttendanceRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new AttendanceRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        AttendanceMenu aMenu = (AttendanceMenu) menu;
        Controller controller = null;

        ControllerLocator locator = AttendanceControllerLocator.getInstance();
        switch (aMenu) {
            case REGISTER: controller =  locator.find(AttendanceMenu.REGISTER); break;
            case SEARCH: controller = locator.find(AttendanceMenu.SEARCH); break;
            default:
                MainRouter.getInstance().change(MainMenu.ATTENDANCE);
                //return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
