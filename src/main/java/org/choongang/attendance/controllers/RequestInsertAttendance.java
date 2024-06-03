package org.choongang.attendance.controllers;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestInsertAttendance {
    private String studentNo;
    private String classId;
    private String today;
    private String attendanceDate;
    private String attendanceStatus;
}
