package org.choongang.attendance.controllers;

import org.choongang.attendance.AttendnaceRouter;
import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

public class AttendanceController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.ATTENDANCE);
    }

    @Override
    public void prompt() {
        while(true) {
            System.out.print("메뉴 선택: ");
            String menuNo = sc.nextLine();
            try {
                int no = Integer.parseInt(menuNo);
                if (no < 1 || no > 3) {
                    throw new RuntimeException();
                }

                switch (no) {
                    case 1: AttendnaceRouter.getInstance().change(AttendanceMenu.REGISTER); break;
                    case 2: AttendnaceRouter.getInstance().change(AttendanceMenu.SEARCH); break;
                    default:
                        MainRouter.getInstance().change(MainMenu.MAIN);
                }
                break;
            } catch (Exception e) {
                System.err.println("메뉴 1, 2, 3 중에서 선택하세요.\n");
            }
        }
    }
}
