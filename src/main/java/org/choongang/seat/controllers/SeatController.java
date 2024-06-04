package org.choongang.seat.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.seat.entities.seat;
import org.choongang.seat.services.SeatService;
import org.choongang.template.Templates;

public class SeatController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.SEAT);

    }

    @Override
    public void prompt() {
        String studentNo = promptWithValidation("학번: (메인화면으로 이동 -> q)", s -> !s.isBlank());

        seat form = seat.builder()
                .studentNo(studentNo)
                .build();

        Router router = MainRouter.getInstance();



        try {
            if (studentNo.equals("q")) { router.change(MainMenu.MAIN); }    //나가기 실행

            Service service = new SeatService();    //싱글톤으로 할경우에 Array와 String을 수동으로 비워야함.
            service.process(form);
            router.change(MainMenu.SEAT);

        } catch (RuntimeException e) {
            System.err.println("존재하지 않는 학번입니다.");
            router.change(MainMenu.SEAT);
        }
    }

}
