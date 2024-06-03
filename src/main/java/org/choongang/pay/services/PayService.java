package org.choongang.pay.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.pay.entities.Pay;
import org.choongang.pay.entities.Payment;
import org.choongang.pay.mapper.PayMapper;

import java.util.List;

public class PayService implements Service<Pay> {


    @Override
    public void process(Pay form) {


        SqlSession session = DBConn.getSession();
        PayMapper mapper = session.getMapper(PayMapper.class);
        Payment payment = mapper.getPayment(form.getStudentNo());

        //System.out.printf(payment.getPayment());
        System.out.printf("수령 가능한 수당은 %s원 입니다.\n" , payment.getPayment());


    }
}
