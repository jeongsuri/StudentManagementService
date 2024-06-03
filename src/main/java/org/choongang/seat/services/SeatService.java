package org.choongang.seat.services;
import org.apache.ibatis.session.SqlSession;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.seat.entities.seat;
import org.choongang.seat.mapper.SeatMapper;

import java.util.ArrayList;
import java.util.List;

public class SeatService implements Service<seat> {
    private static SeatService instance;
    List<String> seatPositionArr = new ArrayList<String>();

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
        
        if (studentNM == null) {        //데이터베이스에 없을 경우
            throw new RuntimeException();
        }

        if (form.getStudentNo().charAt(0) == '0') {         //학번에 01 이런식으로 입력했을경우
            System.err.println("숫자 맨 앞 자리에 0을 제거하고 입력해주세요.");
            throw new RuntimeException();
        }

        int intStudentNo = classStudent.indexOf(form.getStudentNo()) + 1;
        for (int i=1; i<=28; i++) {
            if (i > 3 && i % 7 == 1) {
                if ( i == intStudentNo) {
                    seatPositionArr.add("\n\uD83D\uDC76");
                    continue;}
                seatPositionArr.add("\n\uD83E\uDE91");
            } else if (i == intStudentNo) {
                seatPositionArr.add("\uD83D\uDC76");
            } else if (i % 7 == 4) {
                seatPositionArr.add("\uD83E\uDE91   ");
            } else {
                seatPositionArr.add("\uD83E\uDE91");
            }
        }
        String seatPositionStr = String.join("   ", seatPositionArr);


        System.out.println("\u001B[32m" + "            좌석 배치도             " + "\u001B[0m");
        System.out.println(form.getStudentNo() + " " + studentNM + " " + classNM + "호");
        System.out.println("               \uD83D\uDCBB \uD83E\uDDCF\u200D♂\uFE0F");
        System.out.println(seatPositionStr);
    }
}

