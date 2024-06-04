package org.choongang.reservation.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.reservation.entities.RequestList;
import org.choongang.reservation.services.ReservationServiceLocator;
import org.choongang.template.Templates;

public class ListReservationController extends AbstractController {

    public void common() {
        System.out.println("학생관리 프로그램");
        System.out.println(Templates.getInstance().doubleLine());
    }

    @Override
    public void show() {
        System.out.println("예약 조회 페이지 입니다.");
        System.out.println("아래 항목을 입력하세요.");
        System.out.println(Templates.getInstance().line());
    }

    @Override
    public void prompt() {
        String studentNo = promptWithValidation("학생번호 : ", str -> str.length() >= 0);

        Router router = MainRouter.getInstance();
        RequestList form = RequestList.builder()
                .studentNo(studentNo)
                .build();

        while(true) {
            try {
                Service service = ReservationServiceLocator.getInstance().find(ReservaitonMenu.SEARCH);
                service.process(form);


                router.change(MainMenu.RESERVATION);


            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("조회를 실패했습니다. 다시 시도해주세요.");

            }
        }
    }
}
