package org.choongang.student.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.mapper.StudentRepository;
import org.choongang.student.services.StudentService;

import java.util.HashMap;
import java.util.Map;

public class StudentControllersLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private StudentControllersLocator(){

    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new StudentControllersLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        StudentMenu studentMenu = (StudentMenu)menu;
        switch(studentMenu) {
            case REGISTER: controller = new StudentRegisterController(); break;
            case SEARCH: controller = new StudentListController(); break;
        }
        controllers.put(menu,controller);

        return controller;
    }

}

/**
 * 학생 관리 시스템에서 특정 메뉴에 대한 컨트롤러를 제공하는 StudentControllersLocator 클래스
 * instance : 싱글톤 패턴을 구현하기 위한 ControllerLocator 타입의 정적 변수
 * getInstance 메서드 : 싱글톤 인스턴스 반환
 * find 메서드 : 주어진 메뉴에 대한 컨트롤러를 찾음
 * controllers 맵에서 해당 메뉴에 대한 컨트롤러가 이미 존재하는지 확인 -> 존재하면 해당 컨트롤러 반환
 * REGISTER 메뉴 -> StudentRegisterController 생성 / SEARCH 메뉴 -> StudentListController 생성
 */

/* package org.choongang.student.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.student.controllers.StudentController;
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
        controllers.put(MainMenu.STUDENT, new StudentController(studentService)); // controllers 맵에 초기 컨트롤러 추가
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
} */
