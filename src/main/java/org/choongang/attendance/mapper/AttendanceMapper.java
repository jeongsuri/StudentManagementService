package org.choongang.attendance.mapper;

import org.choongang.attendance.entities.Attendance;

import java.util.List;

public interface AttendanceMapper {
    List<Attendance> getList();
    int insertAttendance(Attendance attendance);
}
