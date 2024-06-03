package org.choongang.attendance.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertAttendance {
    private String TODAY;
    private String CLASS_ID;
    private int STUDENT_NO;
    private int ATTENDANCE_DATE;
    private int ATTENDANCE_STATUS;
}
