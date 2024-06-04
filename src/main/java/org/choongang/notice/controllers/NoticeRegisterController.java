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

        }
    }
}
