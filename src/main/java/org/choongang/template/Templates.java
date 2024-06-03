package org.choongang.template;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.attendance.AttendanceTpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.reservation.ReservationTpl;
import java.util.HashMap;
import java.util.Map;

public class Templates {
    private static Templates instance;
    private Map<MainMenu, Template> tpls;
    private Map<AttendanceMenu, Template> attendanceTpls;
    private Templates() {
        tpls = new HashMap<>();
        attendanceTpls = new HashMap<>();
    }
    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }
    public void render(MainMenu mainMenu) {
        render(mainMenu, null);
    }

    public <T> void render(MainMenu mainMenu, T data) {
        System.out.println(find(mainMenu,data).getTpl());
    }

    public <T> void render(AttendanceMenu attendanceMenu, T data) {
        System.out.println(find(attendanceMenu, data).getTpl());
    }


    public <T> Template find(MainMenu mainMenu, T data){
        Template tpl = tpls.get(mainMenu);
        if(tpl != null){
            return tpl;
        }
        if (menu instanceof AttendanceMenu) {
            AttendanceMenu attendanceMenu = (AttendanceMenu) menu;
         }
        switch (mainMenu){
            case RESERVATION: tpl = new ReservationTpl(); break;
            case ATTENDANCE: tpl = new AttendanceTpl(); break;
            default: tpl = new MainTpl();
        }

        if (data != null) {
            tpl.setData(data);
        }

        tpls.put(mainMenu,tpl);
        return tpl;
    }

    public String line(){
        return "------------------------------------------\n";
    }

    public String doubleLine(){
        return "==========================================\n";
    }
}
