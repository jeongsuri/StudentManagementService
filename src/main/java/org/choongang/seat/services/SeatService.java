package org.choongang.seat.services;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.seat.entities.seat;
import org.choongang.seat.mapper.SeatMapper;

import java.util.List;

public class SeatService implements Service<seat> {

    @Override
    public void process(seat form) {
        SqlSession session = DBConn.getSession();

        SeatMapper mapper = session.getMapper(SeatMapper.class);
        List<String> classStudent = mapper.getClassStudent(form.getStudentNo());

        System.out.println("\n" + form.getStudentNo() + "\n\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83D\uDC76    \uD83E\uDE91   \uD83E\uDE91\n" +
                "\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n" +
                "\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n" +
                "\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n\n");

        System.out.println(classStudent);
    }
}
