package org.choongang.template;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.notice.constants.NoticeMenu;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.student.constants.StudentMenu;
import org.choongang.template.attendance.AttendanceTpl;
import org.choongang.template.attendance.ListAttendanceTpl;
import org.choongang.template.attendance.RegisterAttendanceTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.notice.NoticeListTpl;
import org.choongang.template.pay.PayTpl;
import org.choongang.template.notice.NoticeMainTpl;
import org.choongang.template.pay.PayTpl;
import org.choongang.template.reservation.ReservationTpl;
import org.choongang.template.seat.SeatTpl;
import org.choongang.template.student.StudentListTpl;
import org.choongang.template.student.StudentMainTpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Templates {
    private static Templates instance;
    private Map<Menu, Template> tpls;

    private Templates() {
        tpls = new HashMap<>();
    }

    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }

    public void render(Menu menu) {
        render(menu, null);
    }

    public void render(Menu menu, Supplier<String> hook) {
        System.out.println(find(menu, hook).getTpl());
    }


    public Template find(Menu menu, Supplier<String> hook) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        if (menu instanceof AttendanceMenu) {
            AttendanceMenu attendanceMenu = (AttendanceMenu) menu;

            switch (attendanceMenu) {
                case REGISTER:
                    tpl = new ListAttendanceTpl();
                case SEARCH:
                    tpl = new RegisterAttendanceTpl();
                    break;
            }
        } else if (menu instanceof StudentMenu) { // 학생 관련 템플릿
            StudentMenu studentMenu = (StudentMenu) menu;
            switch (studentMenu) {
                case SEARCH:
                    tpl = new StudentListTpl();
                    break;
            }
        } else if (menu instanceof NoticeMenu) {
            NoticeMenu noticeMenu = (NoticeMenu) menu;
            switch (noticeMenu) {
                //case NOTICE_WRITE: tpl = new NoticeListTpl(); break;
                //case NOTICE_LIST: tpl = new NoticeListTpl(); break;
            }
        } else if(menu instanceof ReservaitonMenu){
            ReservaitonMenu reservaitonMenu = (ReservaitonMenu) menu;
        }else {
            MainMenu mainMenu = (MainMenu)menu;
            switch (mainMenu) {
                case MAIN:
                    tpl = new MainTpl();
                    break;
                case RESERVATION:
                    tpl = new ReservationTpl();
                    break;
                case ATTENDANCE:
                    tpl = new AttendanceTpl();
                    break;
                case PAY: tpl = new PayTpl();
                    break;
                case STUDENT:
                    tpl = new StudentMainTpl();
                    break;
                case NOTICE:
                    tpl = new NoticeMainTpl();
                    break;
                case SEAT:
                    tpl = new SeatTpl();
                    break;
                default:
                    tpl = new MainTpl();
            }
        }

        if (hook != null) {
            tpl.addHook(hook);
        }

        tpls.put(menu, tpl);

        return tpl;
    }

    public String line() {
        return "-----------------------------------\n";
    }

    public String doubleLine() {
        return "===================================\n";
    }
}