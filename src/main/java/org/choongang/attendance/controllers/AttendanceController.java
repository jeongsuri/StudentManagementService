package org.choongang.attendance.controllers;

import org.choongang.attendance.AttendanceRouter;
import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Menu;
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

                Menu menu = null;
                switch (no) {
                    case 1: menu = AttendanceMenu.SEARCH; break;
                    case 2: menu = AttendanceMenu.REGISTER; break;
                    default:
                        MainRouter.getInstance().change(MainMenu.MAIN);
                        break;
                }
                if (menu != null) {
                    AttendanceRouter.getInstance().change(menu);
                }
                break;
            } catch (Exception e) {
                System.err.println("메뉴 1, 2, 3 중에서 선택하세요.\n");
            }
        }
    }
}
