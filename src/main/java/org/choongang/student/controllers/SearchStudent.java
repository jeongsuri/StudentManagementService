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

/**
 * SearchStudent 라는 데이터 전송 객체(Data Transfer Object, DTO) 정의 -> 학생 조회와 관련된 데이터 담기 위해 사용
 */