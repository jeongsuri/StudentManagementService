package org.choongang.template.notice;

import org.choongang.template.Template;

public class NoticeMainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("공지사항\n");
        sb.append("1. 공지 등록\n");
        sb.append("2. 공지사항 조회\n");
        sb.append("3. 메인 메뉴\n");
        return sb.toString();
    }
}
