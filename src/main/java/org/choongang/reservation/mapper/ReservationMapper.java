package org.choongang.reservation.mapper;

import org.choongang.reservation.entities.RequestList;
import org.choongang.reservation.entities.RequestRes;
import org.choongang.reservation.entities.Reserve;

import java.util.List;


public interface ReservationMapper {
    List<Reserve> getList(RequestList search);
    int insertReservation(RequestRes requestres);

}
