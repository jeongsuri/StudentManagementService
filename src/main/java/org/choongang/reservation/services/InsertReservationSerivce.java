package org.choongang.reservation.services;

import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.reservation.entities.RequestRes;
import org.choongang.reservation.mapper.ReservationMapper;
import org.apache.ibatis.session.SqlSession;


public class InsertReservationSerivce implements Service<RequestRes> {

    @Override
    public void process(RequestRes form) {
        SqlSession session = DBConn.getSession();


        ReservationMapper mapper = session.getMapper(ReservationMapper.class);
        RequestRes requestRes = RequestRes.builder()
                .studentNo(form.getStudentNo())
                .date(form.getDate())
                .placeId(form.getPlaceId())
                .build();

        int plusAttendance = mapper.insertReservation(requestRes);
        System.out.println(plusAttendance);
    }
}
