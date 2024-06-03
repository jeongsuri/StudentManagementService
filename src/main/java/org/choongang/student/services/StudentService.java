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