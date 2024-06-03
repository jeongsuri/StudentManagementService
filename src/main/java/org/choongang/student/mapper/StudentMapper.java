package org.choongang.student.mapper;

import org.choongang.student.controllers.SearchStudent;
import org.choongang.student.entities.Student;

import java.util.List;

public interface StudentMapper { // 학생 등록 및 조회 | SQL 매핑 추상 메서드 추가
    List<Student> getList(SearchStudent search); // 전체 학생 목록 조회
    Student get(String studentNo); // 학생 개별 조회
    long getTotal(SearchStudent search); // 학생 목록 -> 페이징 조회
    int exist(String studentNo); // 학생 등록 여부 확인
    int register(Student student); // 학생 등록
}