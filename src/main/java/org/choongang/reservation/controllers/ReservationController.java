package org.choongang.reservation.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

public class ReservationController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(Menu.RESERVATION);
    }

    @Override
    public void prompt() {
        System.out.print("원하는 서비스를 입력하세요 : ");
        Router router = MainRouter.getInstance();
        switch(sc.nextInt()){
            case 1:
                System.out.println("예약하기");
            case 2:
                System.out.println("예약조회");
            case 3:
                System.out.println("예약삭제");
            case 4:
                router.change(Menu.MAIN);
            default:
                System.out.println("잘못된 입력을 하셨습니다. 메인으로 돌아갑니다.");
                router.change(Menu.MAIN);

        }

    }

}
