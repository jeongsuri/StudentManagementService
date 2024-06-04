package org.choongang.student.services;

import org.choongang.global.Service;
import org.choongang.student.controllers.SearchStudent;
import org.choongang.student.entities.Student;
import org.choongang.student.mapper.StudentMapper;

import java.util.List;

public class StudentInfoService implements Service<List<Student>> {

    private StudentMapper mapper;

    public StudentInfoService(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Student> getList(Object search) {

        return mapper.getList((SearchStudent) search);
    }
}
