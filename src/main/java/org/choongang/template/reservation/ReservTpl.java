package org.choongang.template.reservation;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class ReservTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("예약페이지\n");
        sb.append("다음 항목을 입력하세요.\n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }

}
