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


        SqlSession session = DBConn.getSession(); // DB에 연결
        PayMapper mapper = session.getMapper(PayMapper.class); //PayMapper 인터페이스를 구현한 객체 가져오기
        Payment payment = mapper.getPayment(form.getStudentNo()); // form에서 학생 번호를 가져와서 해당 학생의 Payment정보를 조회
        System.out.printf("\u001B[32m" + "\n수령 가능한 수당은 %s원 입니다.\n" + "\u001B[0m" , payment.getPayment()); // 입력한 studentNo와 일치하는 수당을 db에서 가져와 출력

    }
}






//System.out.printf(payment.getPayment());