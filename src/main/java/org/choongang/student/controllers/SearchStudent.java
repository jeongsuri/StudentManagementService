package org.choongang.student.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchStudent {
    private String studentNo; // 학번
    private String studentNm; // 이름
    private int sRow; // 페이징 시작 번호
    private int eRow; // 페이징 종료 번호
}