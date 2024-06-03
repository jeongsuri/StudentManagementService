package org.choongang.notice.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.notice.NoticeRouter;
import org.choongang.notice.constants.NoticeMenu;
import org.choongang.template.Templates;

public class NoticeController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.NOTICE);
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
                    case 1: menu = NoticeMenu.NOTICE_WRITE; break;
                    case 2: menu = NoticeMenu.NOTICE_LIST; break;
                    default:
                        MainRouter.getInstance().change(MainMenu.MAIN);
                        break;
                }

                if (menu != null) {
                    NoticeRouter.getInstance().change(menu);
                }

                break;
            } catch (Exception e) {
                System.err.println("메뉴는 1, 2, 3번 중에서 선택하세요.");
            }
        }
    }

}
