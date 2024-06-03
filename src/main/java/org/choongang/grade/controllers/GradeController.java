package org.choongang.grade.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.constants.Menu;
import org.choongang.template.Templates;

public class GradeController extends AbstractController {

    @Override
    public void common() {
        Templates.getInstance().render(Menu.GRADE);
    }

    @Override
    public void show() {
        System.out.println("학번을 입력하세요");
    }

    @Override
    public void prompt() {}

}
