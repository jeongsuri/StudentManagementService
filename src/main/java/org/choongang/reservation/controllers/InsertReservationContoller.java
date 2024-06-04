package org.choongang.reservation.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.reservation.entities.RequestRes;
import org.choongang.reservation.services.ReservationServiceLocator;
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
        String studentNo = promptWithValidation("학생번호 : ", str -> str.length() >= 0);
        String date = promptWithValidation("날짜 : ", str -> str.length() >= 0);
        String placeId = promptWithValidation("장소 : ",str -> str.length() >= 0);

        Router router = MainRouter.getInstance();
        RequestRes form = RequestRes.builder()
                .studentNo(studentNo)
                .date(date)
                .placeId(placeId)
                .build();

        while(true) {
            try {
                //회원 가입 처리..
                Service service = ReservationServiceLocator.getInstance().find(ReservaitonMenu.RESERVE);
                service.process(form);

                System.out.println("예약을 성공했습니다.");
                router.change(MainMenu.RESERVATION);


            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("예약을 실패했습니다. 다시 시도해주세요.");

            }
        }
    }
}
