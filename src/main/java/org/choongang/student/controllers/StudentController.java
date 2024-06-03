package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.student.entities.Student;
import org.choongang.student.services.StudentService;
import org.choongang.template.Templates;

import java.util.Scanner;

public class StudentController extends AbstractController {
    private final StudentService studentService; // 학생 등록 및 조회
    private final Scanner sc = new Scanner(System.in); // Scanner -> 사용자 입력

    public StudentController(StudentService studentService) {
        this.studentService = studentService; // StudentController 의 생성자, StudentService 인스턴스 받아 초기화
    }

    @Override
    public void common() {
        Templates.getInstance().render(Menu.STUDENT);
    }

    @Override
    public void show() {
        System.out.println("1. 학생 등록 또는 2. 학생 조회 중 하나를 선택하세요.");
    }

    @Override
    public void prompt() {
        System.out.print("선택 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: registerStudent(); break; // 학생 등록
            case 2: searchStudent(); break; // 학생 조회
            default: System.out.println("올바른 선택이 아닙니다.");
        }
    }

    private void registerStudent() { // 1. 학생 등록
        System.out.println("등록하려는 학생의 정보를 입력하세요. (학번, 이름, 전화번호, 과정 ID 순서대로 작성하세요.)");
        System.out.print("학번 : ");
        long studentNo = sc.nextLong();
        sc.nextLine(); // 버퍼 비우기

        System.out.print("이름 : ");
        String studentNm = sc.nextLine();

        System.out.print("전화번호 : ");
        String mobile = sc.nextLine();

        System.out.print("과정 ID : ");
        String classId = sc.nextLine();

        Student student = Student.builder()
                .studentNo(studentNo)
                .studentNm(studentNm)
                .mobile(mobile)
                .classId(classId)
                .build(); // Student 객체 생성

        String result = studentService.registerStudent(student); // registerStudent() 메서드 호출 -> 학생 등록
        System.out.println(result);
    }

    private void searchStudent() { // 2. 학생 조회
        System.out.print("학번 입력 : ");
        String studentNo = sc.nextLine();
        Student student = studentService.getStudent(studentNo); // getStudent() 메서드 호출 -> 학생 정보 조회

        if (student != null) { // 저장된 값이 존재하는 경우
            System.out.printf("학번 : %d, 이름 : %s, 전화번호 : %s, 과정 ID : %s%n",
                    student.getStudentNo(),
                    student.getStudentNm(),
                    student.getMobile(),
                    student.getClassId());
        } else { // 저장된 값이 존재하지 않을 경우
            System.out.println("해당 학번의 학생이 존재하지 않습니다.");
        }
    }
}