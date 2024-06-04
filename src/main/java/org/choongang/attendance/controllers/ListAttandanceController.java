package org.choongang.attendance.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.attendance.entities.SelectAttendance;
import org.choongang.global.AbstractController;
import org.choongang.global.configs.DBConn;

import java.util.List;

public class ListAttandanceController extends AbstractController {
    @Override
    public void show() {
        System.out.println("💛출석 조회💛");
    }

    @Override
    public void prompt() {
        SqlSession session = DBConn.getSession();
        List<SelectAttendance> attendanceList = session.selectList("org.choongang.attendance.mapper.AttendanceMapper.selectAttendance");
        attendanceList.forEach(System.out::println);
    }
}
