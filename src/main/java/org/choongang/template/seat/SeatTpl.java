package org.choongang.template.seat;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class SeatTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("조회하고 싶은 학생의 다음 항목을 입력하세요.\n");
        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}
