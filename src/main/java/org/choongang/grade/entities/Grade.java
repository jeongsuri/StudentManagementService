package org.choongang.grade.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Grade {
    private long studentNo; // 학번
    private String classId; // 과정 id
    private long javaScore; // 과목
    private long htmlScore; // 과목
    private long dbScore; // 과목
}

