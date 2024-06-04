package org.choongang.attendance.services;

import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.Service;

public class RegisterAttendanceService implements Service<Attendance> {
    // 입력한 데이터 DB에 저장하기(INSERT) :  mapper.register(form);
    private AttendanceMapper mapper;

    public RegisterAttendanceService(AttendanceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Attendance form) {
       mapper.register(form);
    }
}
