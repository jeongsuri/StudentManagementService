package org.choongang.template.attendance;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class ListAttendanceTpl implements Template {



    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append(Templates.getInstance().line());
        sb.append("출석 조회\n");
        sb.append(Templates.getInstance().line());


        return sb.toString();
    }
}
