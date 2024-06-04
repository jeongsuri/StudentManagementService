package org.choongang.pay.mapper;

import org.choongang.pay.entities.Pay;
import org.choongang.pay.entities.Payment;

import java.util.List;

public interface PayMapper {

    Payment getPayment(String studentNo);
}
