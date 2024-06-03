package org.choongang.grade.entities;

import lombok.Builder;
import lombok.Data;
import org.choongang.global.constants.Menu;

@Data
@Builder
public  class Grade {
    private int studentNo; // 학번
    private int classId; // 과정 id
    public String javaScore; // 과목
    public String htmlScore; // 과목
    public String dbScore; // 과목

    public Grade(int studentNo, int grade) {
    }

}

