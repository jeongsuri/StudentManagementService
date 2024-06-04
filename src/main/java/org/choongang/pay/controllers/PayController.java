package org.choongang.pay.controllers;

import com.sun.tools.javac.Main;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.pay.entities.Pay;
import org.choongang.pay.mapper.PayMapper;
import org.choongang.pay.services.PayService;
import org.choongang.pay.services.PayServiceLocator;
import org.choongang.seat.entities.seat;
import org.choongang.seat.services.SeatService;
import org.choongang.template.Templates;

import java.io.IOException;
import java.util.List;

public class PayController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.PAY);
    }

    @Override
    public void prompt() {
        String studentNo = promptWithValidation("학번: (메인 -> q 입력)", s -> !s.isBlank());

        Pay form = Pay.builder()
                .studentNo(studentNo)
                .build();

        Router router = MainRouter.getInstance();

        try {
            if (studentNo.equals("q")) { router.change(MainMenu.MAIN); }    //나가기 실행

            Service service = new PayService();
            service.process(form);

        } catch (RuntimeException e) {
            System.err.println("존재하지 않는 학번입니다.");
            router.change(MainMenu.PAY);
        }
    }

}




