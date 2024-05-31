package org.choongang.main;

import org.choongang.attendance.controllers.AttendanceControllersLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;
import org.choongang.notice.controllers.NoticeControllersLocator;
import org.choongang.pay.controllers.PayControllersLocator;
import org.choongang.reservation.controllers.ReservationControllersLocator;
import org.choongang.score.controllers.ScoreControllersLocator;
import org.choongang.seat.controllers.SeatControllersLocator;
import org.choongang.student.controllers.StudentControllersLocator;


public class MainRouter implements Router {

    /**
     * 싱글톤 패턴, 메뉴 컨트롤러가 변경될때마다 새로운 객체를 만들어지는것을 방지
     */
    private static Router instance;
    private MainRouter(){}
    public static Router getInstance(){
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
        ControllerLocator student = StudentControllersLocator.getInstance();
        ControllerLocator attendance = AttendanceControllersLocator.getInstance();
        ControllerLocator pay = PayControllersLocator.getInstance();
        ControllerLocator score = ScoreControllersLocator.getInstance();
        ControllerLocator reservation = ReservationControllersLocator.getInstance();
        ControllerLocator seat = SeatControllersLocator.getInstance();
        ControllerLocator notice = NoticeControllersLocator.getInstance();
        Controller controller = null;
        switch (menu){
            case STUDENT: controller = student.find(Menu.STUDENT); break;
            case ATTENDANCE: controller = attendance.find(Menu.ATTENDANCE); break;
            case PAY: controller = pay.find(Menu.PAY); break;
            case SCORE: controller = score.find(Menu.SCORE); break;
            case RESERVATION: controller = reservation.find(Menu.RESERVATION); break;
            case SEAT: controller = seat.find(Menu.SEAT); break;
            case NOTICE: controller = notice.find(Menu.NOTICE); break;
            default: controller = new MainController();
        }
        controller.run(); //common(), show(), prompt()
    }

    @Override
    public void start() {
        while(true){
            change(Menu.MAIN);
        }

    }
}
