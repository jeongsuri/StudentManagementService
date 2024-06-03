package org.choongang.reservation.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.template.Templates;

public class InsertReservationContoller extends AbstractController {

    public void common() {
        System.out.println("학생관리 프로그램");
        System.out.println(Templates.getInstance().doubleLine());
    }

    @Override
    public void show() {
        System.out.println("예약 페이지 입니다.");
        System.out.println("아래 항목을 입력하세요.");
        System.out.println(Templates.getInstance().line());
    }

    @Override
    public void prompt() {

    }
}
