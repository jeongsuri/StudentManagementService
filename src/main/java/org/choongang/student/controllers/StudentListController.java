package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Student;
import org.choongang.template.Template;
import org.choongang.template.Templates;

public class StudentListController extends AbstractController {
    @Override
    public void show() {

        Templates.getInstance().render(StudentMenu.SEARCH, () -> "학번을 입력해주세요.");
    }

    @Override
    public void prompt() {
        System.out.print("학번 : ");
        int choice = sc.nextInt();
        sc.nextLine();
        /*
        private void StudentService() { // 2. 학생 조회
            System.out.print("학번 입력 : ");
            String studentNo = sc.nextLine();
            Student student = StudentService.getStudent(studentNo); // getStudent() 메서드 호출 -> 학생 정보 조회

            if (student != null) { // 저장된 값이 존재하는 경우
                System.out.printf("학번 : %d, 이름 : %s, 전화번호 : %s, 과정 ID : %s%n",
                        student.getStudentNo(),
                        student.getStudentNm(),
                        student.getMobile(),
                        student.getClassId());
            } else { // 저장된 값이 존재하지 않을 경우
                System.out.println("해당 학번의 학생이 존재하지 않습니다.");
            }
        }*/
    }
}
/**
 * 학생 목록을 보여주는 StudentListController 클래스 -> AbstractController 를 상속받아 구현
 * show 메서드 : AbstractController 클래스에서 상속된 추상 메서드 재정의 -> 호출될 때 "학생 목록"을 출력함
 */