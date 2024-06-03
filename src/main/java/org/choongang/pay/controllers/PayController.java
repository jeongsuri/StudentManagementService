package org.choongang.pay.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.pay.entities.Pay;
import org.choongang.pay.mapper.PayMapper;
import org.choongang.pay.services.PayService;
import org.choongang.pay.services.PayServiceLocator;
import org.choongang.template.Templates;

import java.io.IOException;
import java.util.List;

public class PayController extends AbstractController {

   // @Override
   // public void common() {
     //   System.out.println("common");
   // }

    @Override
    public void show() {
        Templates.getInstance().render(Menu.PAY);
    }

    @Override
    public void prompt() {

        Templates.getInstance().render(Menu.PAY);
        SqlSession session = null;

     //  session = DBConn.getSession();
       /* List<Pay> pays = session.selectList("org.choongang.pay.mapper.PayMapper.getPay");
        System.out.println("수당 내역입니다.");
       System.out.printf("%d번 %d원입니다\n", pays.get(0).getSTUDENT_NO(), pays.get(0).getPAYMENT());
   */
        session = DBConn.getSession();
        Router router = MainRouter.getInstance();
        try {
            //Service service = PayServiceLocator.getInstance().find(Menu.PAY);
            System.out.println("수당 지급 내역입니다.");
            PayMapper mapper = session.getMapper(PayMapper.class);
            System.out.println(mapper.getPay());
        } catch (RuntimeException e) {
            System.out.println("저장된 값이 없습니다.");
            router.change(Menu.MAIN);
        }
    }

}
