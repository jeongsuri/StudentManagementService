package org.choongang.student.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private long studentNo; // 학번
    private String studentNm; // 학생 이름
    private String mobile; // 전화번호
    private String classId; // 과정 id
}

/**
 * 학생을 나타내는 Student 엔티티 클래스
 */