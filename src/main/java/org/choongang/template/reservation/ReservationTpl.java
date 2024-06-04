package org.choongang.template.reservation;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class ReservationTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("1. 예약하기  \n");
        sb.append("2. 예약조회 \n");
        sb.append("3. 예약취소 \n");
        sb.append("4. 메인화면 \n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}
