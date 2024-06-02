package org.choongang.seat.mapper;


import java.util.List;

public interface SeatMapper {
    List<String> getClassStudent(String studentNo);
    List<String> getList();
}
