package org.choongang.notice.controllers;

import org.choongang.global.AbstractController;

public class NoticeRegisterController extends AbstractController {
    @Override
    public void show() {
        System.out.println("공지사항 등록");
    }

    @Override
    public void prompt() {
        while(true) {
            String content = promptWithValidation("작성할 공지 내용:", s
                    -> !s.isBlank());
            // 실제 작성은 안 됨, 서브 메뉴만 구현
        }
    }
}
