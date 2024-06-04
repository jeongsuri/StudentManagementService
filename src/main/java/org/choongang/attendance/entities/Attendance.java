package org.choongang.attendance.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Attendance {
    private int studentNo;
    private LocalDateTime today;
    private int attendanceDate;
    private String attendanceStatus;
    private String classId;
}
