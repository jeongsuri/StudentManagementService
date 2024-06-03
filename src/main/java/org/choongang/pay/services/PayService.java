package org.choongang.pay.services;

import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.pay.entities.Pay;
import org.choongang.pay.mapper.PayMapper;

import java.util.List;

public class PayService implements Service<List<Pay>> {
    @Override
    public List<Pay> process(List<Pay> form) {
          PayMapper mapper = DBConn.getSession().getMapper(PayMapper.class);

        return mapper.getPay();
    }
}

   /* @Override
    public List<Pay> process(List<Pay> form) {
        return List.of();
    }
}*/
