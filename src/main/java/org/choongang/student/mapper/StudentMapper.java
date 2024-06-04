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

/**
 * 학생 관련 데이터베이스 작업을 수행하는 인터페이스인 StudentMapper 정의
 * getList : 특정 조건에 맞는 학생 목록 조회하는 메서드 / SearchStudent 객체를 매개변수로 받아 해당 조건에 맞는 학생 목록 반환
 * get : 학번을 기준으로 특정 학생 조회하는 메서드 / 학번을 매개변수로 받아 해당 학생 정보 반환
 * getTotal : 특정 조건에 맞는 학생 목록의 총 수 조회하는 메서드 /
 * SearchStudent 객체를 매개변수로 받아 해당 조건에 맞는 학생 목록의 총 수 반환
 * exist : 주어진 학번이 이미 등록되어 있는지 확인하는 메서드 / 학번을 매개변수로 받아 해당 학생이 등록되어 있는지 여부 반환
 * register : 새로운 학생을 등록하는 메서드 / Student 객체를 매개변수로 받아 데이터베이스에 해당 학생 정보 등록
 */