package org.choongang.attendance.mapper;

import org.choongang.attendance.controllers.RequestInsertAttendance;
import org.choongang.attendance.entities.SelectAttendance;

import java.util.List;

public interface AttendanceMapper {
    List<SelectAttendance> selectAttendance();
    int insertAttendance(RequestInsertAttendance requestInsertAttendance);
}
