package org.choongang.attendance.services;

import org.choongang.attendance.entities.SelectAttendance;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;

import java.util.List;

public class ListAttendanceService implements Service<List<SelectAttendance>> {
    @Override
    public List<SelectAttendance> process() {
        AttendanceMapper mapper = DBConn.getSession().getMapper(AttendanceMapper.class);
        return mapper.selectAttendance();
    }
}
