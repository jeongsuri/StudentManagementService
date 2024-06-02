package org.choongang.seat.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.seat.entities.seat;
import org.choongang.seat.mapper.SeatMapper;
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
        SqlSession session = DBConn.getSession();

        SeatMapper mapper = session.getMapper(SeatMapper.class);

        String studentNo = promptWithValidation("학번: ", s -> !s.isBlank());

        List<String> aa = mapper.getList();

        System.out.println(" aa" + aa);

        List<String> classStudent = mapper.getClassStudent(studentNo);

        seat form = seat.builder()
                .seatNum(classStudent)
                .build();
    }

}
