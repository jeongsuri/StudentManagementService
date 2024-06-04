package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.Templates;

public class StudentRegisterController extends AbstractController {

    @Override
    public void show() {
        System.out.println("학생 등록");
    }

    @Override
    public void prompt() {
        while(true) {
            String studentNm = promptWithValidation("학생 이름:", s
            -> !s.isBlank());

        }
    }
}

/**
 * 학생 등록 담당하는 StudentRegisterController 클래스 -> AbstractController 를 상속받아 구현, 학생 등록 관련 기능 제공
 * show 메서드 : AbstractController 클래스에서 상속된 추상 메서드 재정의 -> 호출될 때 "학생 목록"을 출력함
 * prompt 메서드 : 학생 이름을 입력받는 루프 포함
 * promptWithValidation 메서드 : 사용자로부터 입력 받고, 입력값이 비어있지 않은지 검증 / 입력이 유효하면 studentNm 변수에 저장
 */