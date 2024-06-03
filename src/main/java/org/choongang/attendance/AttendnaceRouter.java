package org.choongang.attendance;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.controllers.AttendanceControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;

public class AttendnaceRouter implements Router {
    private static Router instance;
    private AttendnaceRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new AttendnaceRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        Controller controller = null;
        AttendanceMenu aMenu = (AttendanceMenu) menu;
        ControllerLocator locator = AttendanceControllerLocator.getInstance();
        switch (aMenu) {
            case REGISTER: controller =  locator.find(AttendanceMenu.REGISTER); break;
            case SEARCH: controller = locator.find(AttendanceMenu.SEARCH); break;
            default:
                MainRouter.getInstance().change(MainMenu.ATTENDANCE);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
