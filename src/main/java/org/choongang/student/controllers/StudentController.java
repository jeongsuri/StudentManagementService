package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.student.StudentRouter;
import org.choongang.student.constants.StudentMenu;
import org.choongang.template.Templates;

public class StudentController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.STUDENT);
    }

    @Override
    public void prompt() {
        while(true) {
            System.out.print("메뉴 선택 : ");
            String menuNo = sc.nextLine();
            try {
                int no = Integer.parseInt(menuNo);
                if (no < 1 || no > 3) {
                    throw new RuntimeException();
                }

                Menu menu = null;
                switch (no) {
                    case 1: menu = StudentMenu.REGISTER; break;
                    case 2: menu = StudentMenu.SEARCH; break;
                    default:
                        MainRouter.getInstance().change(MainMenu.MAIN);
                        break;
                }

                if (menu != null) {
                    StudentRouter.getInstance().change(menu);
                }

                break;
            } catch (Exception e) {
                System.err.println("1. 학생 등록, 2. 학생 조회 중 하나를 선택하세요.");
            }
        }
    }
}

/**
 * 학생 관리 시스템에서 학생 관련 메뉴를 제어하는 StudentController 클래스
 * -> 사용자의 입력을 받아 학생 등록 또는 조회 메뉴로 이동하는 기능 제공
 * StudentController 클래스는 AbstractController 를 상속받아 정의됨
 * show 메서드 : 학생 메뉴 화면 출력 -> Templates 클래스의 render 메서드 사용해 MainMenu.STUDENT 템플릿을 화면에 렌더링함
 * prompt 메서드 : 사용자의 입력을 받아 메뉴를 선택하는 기능 수행 -> 올바른 입력을 할 때까지 반복
 * -> 입력된 숫자가 1에서 3 사이가 아니면 예외 발생 / 입력된 숫자에 따라 menu 변수를 설정
 * 1 입력 시 StudentMenu.REGISTER 설정, 2 입력 시 StudentMenu.SEARCH 설정, 그 외 숫자는 메인 메뉴로 돌아감
 */

/* package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.global.constants.MainMenu;
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
        Templates.getInstance().render(MainMenu.STUDENT);
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
} */