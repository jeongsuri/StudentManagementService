package org.choongang.attendance.services;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;

// AttendanceServiceLocator : 서비스를 객체 생성 및 반환(개방 폐쇄 원칙)
public class AttendanceServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new AttendanceServiceLocator();
        }

        return instance;
    }

    public AttendanceMapper attendanceMapper() {
        return DBConn.getSession().getMapper(AttendanceMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        AttendanceMenu aMenu = (AttendanceMenu)menu;
        Service service = null;
        switch (aMenu) {
            case SEARCH: service = new ListAttendanceService(attendanceMapper()); break;
            case REGISTER: service = new RegisterAttendanceService(attendanceMapper()); break;
        }
        return service; // service객체를 반환
    }
}
