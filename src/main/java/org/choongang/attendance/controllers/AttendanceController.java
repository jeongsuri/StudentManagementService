package org.choongang.attendance.controllers;

import org.choongang.attendance.AttendanceRouter;
import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

public class AttendanceController extends AbstractController {
    @Override
    public void show() { // show 재정의
        Templates.getInstance().render(MainMenu.ATTENDANCE);
        // Templates에서 else구문으로 유입 ↓
        // case ATTENDANCE : tpl = new AttendanceTpl(); break;
        // AttendanceTpl을 객체로 생성 + 초기화 + 실행
    }

    @Override
    public void prompt() { // prompt 재정의
        while(true) {
            System.out.print("메뉴 선택: ");
            String menuNo = sc.nextLine(); // AbstractController에 정의된 scanner함수 재활용
            try {
                int no = Integer.parseInt(menuNo); // 스캐너 함수엔 문자형으로 담기니 int형으로 변환
                if (no < 1 || no > 3) {
                    // 숫자 1,2 가 아니면 catch 구문에 있는 System.err.println("메뉴 1, 2, 3 중에서 선택하세요.\n"); 실행
                    throw new RuntimeException();
                }

                Menu menu = null;
                switch (no) {
                    case 1: menu = AttendanceMenu.SEARCH; break; // 숫자 1 입력한 경우 서브메뉴 1. 학생 조회
                    case 2: menu = AttendanceMenu.REGISTER; break; // 숫자 2 입력한 경우 서브메뉴 2. 학생 등록
                    default:
                        MainRouter.getInstance().change(MainMenu.MAIN); // 그외 입력값은 ATTENDANCE 서브메뉴메인으로 유입
                        break;
                }
                if (menu != null) { // 만약 menu로 유입된 값이 없으면 ATTENDANCE 서브메뉴메인으로 유입
                    AttendanceRouter.getInstance().change(menu);
                }
                break;
            } catch (Exception e) {
                System.err.println("메뉴 1, 2, 3 중에서 선택하세요.\n");
            }
        }
    }
}
