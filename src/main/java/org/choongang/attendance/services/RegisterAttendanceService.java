package org.choongang.attendance.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.attendance.controllers.RequestInsertAttendance;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;

public class RegisterAttendanceService implements Service<RequestInsertAttendance> {
    //private final AttendanceMapper mapper;

    @Override
    public void process(RequestInsertAttendance form) {
        SqlSession session = DBConn.getSession();

        String studentNo = form.getStudentNo();
        String classId = form.getClassId();
        String today = form.getToday();
        String attendanceDate = form.getAttendanceDate();
        String attendanceStatus = form.getAttendanceStatus();

        AttendanceMapper mapper = session.getMapper(AttendanceMapper.class);
        RequestInsertAttendance requestInsertAttendance = RequestInsertAttendance.builder()
                .studentNo(form.getStudentNo())
                .classId(form.getClassId())
                .today(form.getToday())
                .attendanceDate(form.getAttendanceDate())
                .attendanceStatus(form.getAttendanceDate())
                .build();
        int plusAttendance = mapper.insertAttendance(requestInsertAttendance);
        System.out.println(plusAttendance);
    }
}
