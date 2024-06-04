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

/**
 * 학생 관련 라우팅을 담당하는 StudentRouter 클래스 정의
 * getInstance(): 싱글톤 패턴을 사용하여 Router 객체의 인스턴스 반환
 * -> 메뉴 컨트롤러가 변경될 때마다 새로운 객체를 생성하는 것 방지
 * change(Menu menu): 주어진 메뉴에 따라 해당하는 컨트롤러 찾고 실행
 * -> 먼저 메뉴를 StudentMenu 로 형변환하여 학생 메뉴인지 확인 StudentControllersLocator 사용하여 해당하는 메뉴에 대한 컨트롤러 찾음
 * 학생 메뉴가 아니라면 MainControllerLocator 사용하여 메인 메뉴 컨트롤러 찾음 -> 마지막으로 찾은 컨트롤러 실행
 * 라우팅을 담당하는 StudentRouter 클래스가 완성
 */