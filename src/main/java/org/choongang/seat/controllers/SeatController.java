package org.choongang.seat.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.seat.entities.seat;
import org.choongang.seat.mapper.SeatMapper;
import org.choongang.seat.services.SeatService;
import org.choongang.template.Templates;

import java.util.Arrays;
import java.util.List;

public class SeatController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(Menu.SEAT);
    }

    @Override
    public void prompt() {
        String studentNo = promptWithValidation("학번: ", s -> !s.isBlank());

        seat form = seat.builder()
                .studentNo(studentNo)
                .build();

        Router router = MainRouter.getInstance();

        try {
            Service service = SeatService.getInstance();
            service.process(form);

            router.change(Menu.SEAT);

        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

}
