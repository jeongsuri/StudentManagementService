package org.choongang.attendance.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Attendance { // DB에 있는 데이터와 매핑하기위한 변수선언, xml파일에서 변수명 변환작업 함
    private int studentNo;
    private LocalDateTime today;
    private int attendanceDate;
    private String attendanceStatus;
    private String classId;
}
