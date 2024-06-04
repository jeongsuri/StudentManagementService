package org.choongang.pay.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.pay.entities.Pay;
import org.choongang.pay.services.PayService;
import org.choongang.template.Templates;

public class PayController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.PAY);
    }

    @Override
    public void prompt() {
        String studentNo = promptWithValidation("학번: (메인 -> q 입력)", s -> !s.isBlank());

        Pay form = Pay.builder()
                .studentNo(studentNo)
                .build(); // 빌더로 Pay 객체를 생성

        Router router = MainRouter.getInstance(); // 설정한 메뉴로 이동하는 인스턴스 생성

        try {
            if (studentNo.equals("q")) { router.change(MainMenu.MAIN); }  //나가기 실행

            Service service = new PayService(); //PayService  가져와서 실행
            service.process(form);
            router.change(MainMenu.PAY);

        } catch (RuntimeException e) {
            System.err.println("존재하지 않는 학번입니다.");
            router.change(MainMenu.PAY); // Pay 로 다시 들어가서 학번 재입력

        }
    }

}




