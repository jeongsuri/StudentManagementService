package org.choongang.pay.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
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
        Templates.getInstance().render(Menu.PAY);
    }

    @Override
    public void prompt() {
        String StudentNo = promptWithValidation("학번: (메인화면으로 이동 q 입력)", s -> !s.isBlank());


        SqlSession session = null;
        session = DBConn.getSession();
        PayMapper mapper = session.getMapper(PayMapper.class);
        Router router = MainRouter.getInstance();

        /*try {
            if (StudentNo.equals("q")) { router.change(Menu.MAIN); }
            Service service = new PayService();
            service.process(form);
            System.out.println(mapper.getPay());
            router.change(Menu.PAY);
        } catch (RuntimeException e) {
            System.err.println("존재하지 않는 학번입니다.");
            router.change(Menu.PAY);
        } */
    }
}

