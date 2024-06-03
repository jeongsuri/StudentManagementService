package org.choongang.template.attendance;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class AttendanceTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append(Templates.getInstance().line());
        sb.append("                  출석부\n");
        sb.append(Templates.getInstance().line());
        sb.append("1: 출석 등록\n");
        sb.append("2: 출석 조회\n");
        sb.append("3: 메인메뉴 이동\n");

        return sb.toString();
    }
}
