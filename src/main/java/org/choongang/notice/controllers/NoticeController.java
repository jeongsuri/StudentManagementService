package org.choongang.notice.controllers;

import org.choongang.global.AbstractController;

public class NoticeController extends AbstractController {

    @Override
    public void common() {
        System.out.println("common");
    }

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void prompt() {}

}
