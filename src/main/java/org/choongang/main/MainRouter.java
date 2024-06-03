package org.choongang.main;

import org.choongang.global.*;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainControllerLocator;


public class MainRouter implements Router, Startable {

    /**
     * 싱글톤 패턴, 메뉴 컨트롤러가 변경될때마다 새로운 객체를 만들어지는것을 방지
     */
    private static MainRouter instance;
    private MainRouter(){}
    public static MainRouter getInstance(){
        if(instance == null){
            instance = new MainRouter();
        }
        return instance;
    }

    /**
     * MAIN, // 메인 화면
     *     STUDENT, //학생
     *     ATTENDANCE, //출석관리
     *     PAY, //수당관리
     *     SCORE, //점수관리
     *     RESERVATION, //예약관리
     *     SEAT, //좌석관리
     *     NOTICE //공지관리
     * @param menu
     */

    @Override
    public void change(Menu menu) {
        MainMenu mainMenu = (MainMenu) menu;
        ControllerLocator locator = MainControllerLocator.getInstance();
        Controller controller = null;
        switch (mainMenu){
            case STUDENT: controller = locator.find(MainMenu.STUDENT); break;
            case ATTENDANCE: controller = locator.find(MainMenu.ATTENDANCE); break;
            case PAY: controller = locator.find(MainMenu.PAY); break;
            case SCORE: controller = locator.find(MainMenu.SCORE); break;
            case RESERVATION: controller = locator.find(MainMenu.RESERVATION); break;
            case SEAT: controller = locator.find(MainMenu.SEAT); break;
            case NOTICE: controller = locator.find(MainMenu.NOTICE); break;
            default: controller = locator.find(MainMenu.MAIN);
        }

        controller.run(); //common(), show(), prompt()
    }

    @Override
    public void start() {
        while(true){
            change(MainMenu.MAIN);
        }

    }
}