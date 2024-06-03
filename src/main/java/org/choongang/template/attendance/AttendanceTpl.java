package org.choongang.template.attendance;

import org.choongang.template.Template;

public class AttendanceTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);

        sb.append("");
        sb.append("------------------------------------------");
        sb.append("                  출석부");
        sb.append("------------------------------------------");
        sb.append("1: 출석 등록");
        sb.append("2: 출석 조회");
        sb.append("3: 출석 삭제");
        sb.append("");
        sb.append("메뉴를 선택해 주세요 : ");

        return sb.toString();
    }
}
