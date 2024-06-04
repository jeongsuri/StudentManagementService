package org.choongang.notice.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.notice.NoticeRouter;
import org.choongang.notice.constants.NoticeMenu;
import org.choongang.notice.entities.Notice;
import org.choongang.notice.services.NoticeServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class NoticeListController extends AbstractController {
    private Service<List<Notice>> service;

    public NoticeListController() {
        service = NoticeServiceLocator.getInstance().find(NoticeMenu.NOTICE_LIST);
    }

    @Override
    public void show() {
        List<Notice> items = service.process();
        String body = items.stream().map(p -> String.format("%d\t%s\t%s%n", p.getNOTICE_NO(), p.getTITLE(), p.getTIME_POST()))
                .collect(Collectors.joining("\n"));

        Templates.getInstance().render(NoticeMenu.NOTICE_LIST, () -> body);
    }
    //


    @Override
    public void prompt() {
        while(true) {
            String noticeNo = promptWithValidation("조회할 공지 번호: ", s -> !s.isBlank());
            try {
                int no = Integer.parseInt(noticeNo);

                Notice notice = service.get(no);
                if (notice == null) {
                    System.err.println("등록된 게시글이 아닙니다.");
                    continue;
                }

                System.out.printf("글번호: %d%n", notice.getNOTICE_NO());
                System.out.printf("공지 제목: %s%n", notice.getTITLE());
                System.out.printf("공지 내용: %s%n", notice.getTIME_POST()); // 작성 시간이 떠야 하는데 내용이 뜸..


                System.out.print("수정(1), 삭제(2): ");
                String menuNo = sc.nextLine();
                try {
                    int m = Integer.parseInt(menuNo);
                    if (m == 1) {  // 수정시에는 변경할 항목과 수정 내용 입력

                        String itemNo = promptWithValidation("수정할 항목 번호:", s -> !s.isBlank());
                        String changeStr = promptWithValidation("변경할 내용: ", s -> !s.isBlank());
                    } else {
                        // 삭제 처리
                    }
                } catch (Exception e) {
                    System.err.println("메뉴 1, 2 중에서 선택하세요.");
                }
                break;
            } catch (Exception e) {
                System.err.println("글 번호는 숫자만 입력하세요.");
            }
        }
    }
}