package org.choongang.attendance.services;

import org.choongang.attendance.entities.Attendance;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.Service;

public class RegisterAttendanceService implements Service<Attendance> {
    private AttendanceMapper mapper;

    public RegisterAttendanceService(AttendanceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Attendance form) {
        Attendance register = Attendance.builder()
                .studentNo(form.getStudentNo())
                .today(form.getToday())
                .attendanceDate(form.getAttendanceDate())
                .attendanceStatus(form.getAttendanceStatus())
                .classId(form.getClassId())
                .build();
        int save = mapper.insertAttendance(register);
        System.out.println(save);
    }
}
