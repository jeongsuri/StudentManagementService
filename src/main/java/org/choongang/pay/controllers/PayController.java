package org.choongang.pay.controllers;

import org.choongang.global.AbstractController;

public class PayController extends AbstractController {

    @Override
    public void common() {
        System.out.println("common");
    }

    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void prompt() {
        System.out.print("prompt");
        String message = sc.nextLine();
    }

}
