package org.choongang.student;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainControllerLocator;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.controllers.StudentControllersLocator;

public class StudentRouter implements Router {

    /**
     * 싱글톤 패턴, 메뉴 컨트롤러가 변경될때마다 새로운 객체를 만들어지는것을 방지
     */
    private static Router instance;
    private StudentRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new StudentRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        StudentMenu studentMenu = (StudentMenu)menu;

        Controller controller = null;
        ControllerLocator locator = StudentControllersLocator.getInstance();
        ControllerLocator mainLocator = MainControllerLocator.getInstance();
        switch(studentMenu) {
            case REGISTER: controller = locator.find(StudentMenu.REGISTER); break;
            case SEARCH: controller = locator.find(StudentMenu.SEARCH); break;
            default : controller = mainLocator.find(MainMenu.MAIN);
        }

        if (controller != null) {
            controller.run();
        }
    }
}
