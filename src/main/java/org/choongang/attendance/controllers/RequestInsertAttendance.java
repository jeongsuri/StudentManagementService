package org.choongang.attendance.controllers;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestInsertAttendance {
    private int studentNo;
    private String classId;
    private String today;
    private int attendanceDate;
    private String attendanceStatus;
}
