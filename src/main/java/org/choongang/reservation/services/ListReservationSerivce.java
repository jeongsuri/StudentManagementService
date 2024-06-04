package org.choongang.reservation.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.reservation.entities.RequestList;
import org.choongang.reservation.entities.RequestRes;
import org.choongang.reservation.entities.Reserve;
import org.choongang.reservation.mapper.ReservationMapper;

import java.util.List;


public class ListReservationSerivce implements Service<RequestList> {
    @Override
    public void process(RequestList form) {
        SqlSession session = DBConn.getSession();


        ReservationMapper mapper = session.getMapper(ReservationMapper.class);
        RequestList requestList = RequestList.builder()
                .studentNo(form.getStudentNo())
                .build();

        List<Reserve> requestLists = mapper.getList(requestList);
        requestLists.forEach(System.out::println);
    }
}
