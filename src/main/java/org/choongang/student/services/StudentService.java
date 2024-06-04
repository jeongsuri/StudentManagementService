package org.choongang.student.services;

import org.choongang.student.entities.Student;
import org.choongang.student.mapper.StudentMapper;

public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public String registerStudent(Student student) {
        if (studentMapper.exist(String.valueOf(student.getStudentNo())) > 0) {
            return "해당 학생이 이미 등록되어 있습니다.";
        }
        int result = studentMapper.register(student);
        return result > 0 ? "학생 등록 성공" : "학생 등록 실패";
    }

    public Student getStudent(String studentNo) {
        return studentMapper.get(studentNo);
    }
}

/**
 *  StudentService 클래스 정의하여 학생 관련 기능 제공 -> StudentMapper 사용하여 데이터베이스와 상호작용
 * StudentService : 생성자에서 StudentMapper 객체를 받아들여 이를 사용함으로써 데이터베이스와 상호작용
 * registerStudent : 주어진 학생 정보 등록
 * -> 먼저 해당 학생이 이미 등록되어 있는지 확인한 후, 등록되어 있지 않으면 StudentMapper 를 사용하여 학생 등록
 * 등록 결과에 따라 적절한 메시지 반환
 * getStudent : 주어진 학번에 해당하는 학생 정보 조회 -> StudentMapper 를 사용하여 데이터베이스에서 학생 정보 가져옴
 * 학생 등록과 학생 정보 조회 기능 제공, 내부적으로는 StudentMapper 를 사용하여 데이터베이스와 상호작용
 */