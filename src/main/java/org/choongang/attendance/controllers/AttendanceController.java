package org.choongang.attendance.controllers;

import org.choongang.global.AbstractController;

public class AttendanceController extends AbstractController {

    @Override
    public void common() {
        System.out.println("common 출석");
    }

    @Override
    public void show() {
        System.out.println("show 출석");
    }

    @Override
    public void prompt() {
        System.out.print("prompt 출석");
        String message = sc.nextLine();
    }

}
