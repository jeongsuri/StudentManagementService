package org.choongang.attendance.mapper;

import org.choongang.attendance.controllers.RequestInsertAttendance;

public interface AttendanceMapper {
    int selectAttendance();
    int insertAttendance(RequestInsertAttendance requestInsertAttendance);
}
