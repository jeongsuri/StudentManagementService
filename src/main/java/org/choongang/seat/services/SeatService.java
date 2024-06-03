package org.choongang.seat.services;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.seat.entities.seat;
import org.choongang.seat.mapper.SeatMapper;

import java.util.List;

public class SeatService implements Service<seat> {
    private static SeatService instance;

    public static SeatService getInstance(){
        if(instance == null){
            instance = new SeatService();
        }
        return instance;
    }


    @Override
    public void process(seat form) {
        SqlSession session = DBConn.getSession();

        SeatMapper mapper = session.getMapper(SeatMapper.class);
        List<String> classStudent = mapper.getClassStudent(form.getStudentNo());
        String studentNM = mapper.getStudentNM(form.getStudentNo());
        String classNM = mapper.getClassRoom(form.getStudentNo());



        System.out.println("             좌석 배치도             ");
        System.out.println(form.getStudentNo() + " " + studentNM + " " + classNM + "호" +
                "\n\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n" +
                "\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n" +
                "\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n" +
                "\uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91   \uD83E\uDE91       \uD83E\uDE91    \uD83E\uDE91   \uD83E\uDE91\n");

        System.out.println(classStudent);
    }
}
