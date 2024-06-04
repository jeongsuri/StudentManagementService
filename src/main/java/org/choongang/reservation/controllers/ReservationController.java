package org.choongang.reservation.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.reservation.ReservationRouter;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.template.Templates;

public class ReservationController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.RESERVATION);
    }

    @Override
    public void prompt() {
        while(true) {
            System.out.print("메뉴 선택: ");
            int menuNo = sc.nextInt();
            try {
                if (menuNo < 1 || menuNo > 4) {
                    throw new RuntimeException();
                }

                switch (menuNo) {
                    case 1: ReservationRouter.getInstance().change(ReservaitonMenu.RESERVE); break;
                    case 2: ReservationRouter.getInstance().change(ReservaitonMenu.SEARCH); break;
                    case 3: ReservationRouter.getInstance().change(ReservaitonMenu.DELETE); break;
                    default:
                        MainRouter.getInstance().change(MainMenu.MAIN);break;
                }
                break;
            } catch (Exception e) {
                System.err.println("메뉴 1, 2, 3 중에서 선택하세요.\n");
            }
        }

    }

}
