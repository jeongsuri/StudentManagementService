package org.choongang.template;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.student.constants.StudentMenu;
import org.choongang.template.attendance.AttendanceTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.notice.NoticeMainTpl;
import org.choongang.template.reservation.ReservationTpl;
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
           /*
            switch (attendanceMenu) {
                case SELECT:
                    tpl = new SelectAttendanceTpl();
                case INSERT:
                    tpl = new InsertAttendanceTpl();
                case DELETE:
                    tpl = new DeleteAttendanceTpl();
                    break;
            }*/
        } else if (menu instanceof StudentMenu) { // 학생 관련 템플릿
            StudentMenu studentMenu = (StudentMenu) menu;
            switch(studentMenu) {
                case SEARCH: tpl = new StudentListTpl(); break;
            }
        } else {
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
                case STUDENT:
                    tpl = new StudentMainTpl();
                    break;
                case NOTICE:
                    tpl = new NoticeMainTpl();
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