package org.choongang.pay.mapper;

import org.choongang.pay.entities.Pay;

import java.util.List;

public interface PayMapper {
    List<Pay> getPay();

    List<Pay> getStudentNo();
}
