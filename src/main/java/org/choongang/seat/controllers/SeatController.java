package org.choongang.seat.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

public class SeatController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(Menu.SEAT);
    }

    @Override
    public void prompt() {
        System.out.print("prompt");
        String message = sc.nextLine();
    }

}
