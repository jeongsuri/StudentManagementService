package org.choongang.pay.services;

import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.pay.entities.Pay;
import org.choongang.pay.mapper.PayMapper;

import java.util.List;

public class PayService implements Service<List<Pay>> {
    @Override
    public void process(List<Pay> form) {
          PayMapper mapper = DBConn.getSession().getMapper(PayMapper.class);

        List<Pay> studentNo = mapper.getStudentNo();
        List<Pay> payment = mapper.getPay();

        Pay form = Pay.builder()
                .studentNo(studentNo)
                .build();


        if (studentNo != mapper.getStudentNo()) {
            throw new RuntimeException();
        }
        else {
            System.out.printf("%d , %d " , studentNo , payment);
        }
       /* if(studentNo  {
            throw new RuntimeException();
        }
*/

    }
}
