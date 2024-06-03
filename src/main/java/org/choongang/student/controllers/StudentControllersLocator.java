package org.choongang.student.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;
import org.choongang.student.services.StudentService;
import org.choongang.student.mapper.StudentRepository;

import java.util.HashMap;
import java.util.Map;

public class StudentControllersLocator implements ControllerLocator {

    private static ControllerLocator instance; // 싱글톤 패턴 구현 정적 필드

    private Map<Menu, Controller> controllers; // Map -> 메뉴 항목에 따라 컨트롤러 저장

    private StudentControllersLocator() {
        controllers = new HashMap<>(); // controllers Map 초기화
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        controllers.put(Menu.STUDENT, new StudentController(studentService)); // controllers 맵에 초기 컨트롤러 추가
    }

    public static ControllerLocator getInstance() { // 싱글톤 패턴 구현 정적 메서드
        if (instance == null) { // 처음 호출될 때 인스턴스 생성
            instance = new StudentControllersLocator();
        }
        return instance; // 이후 -> 동일한 인스턴스 반환
    }

    @Override
    public Controller find(Menu menu) { // ControllerLocator 인터페이스의 메서드 구현
        Controller controller = controllers.get(menu); // menu 항목에 해당하는 컨트롤러 controllers Map 검색
        if (controller != null) {
            return controller;
        }

        switch (menu) {
            case STUDENT:
                StudentRepository studentRepository = new StudentRepository();
                StudentService studentService = new StudentService(studentRepository);
                controller = new StudentController(studentService);
                controllers.put(menu, controller);
                break;
            default:
                controller = new MainController(); // 새로운 MainController 인스턴스 생성해 Map 에 추가
                controllers.put(menu, controller);
                break;
        }

        return controller; // 검색된 컨트롤러 반환
    }
}