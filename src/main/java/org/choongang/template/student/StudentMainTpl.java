package org.choongang.template.student;

import org.choongang.template.Template;

public class StudentMainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("             <학생관리>\n");
        sb.append("           1. 학생 등록\n");
        sb.append("           2. 학생 조회\n");
        sb.append("           3. 메인 메뉴\n");
        return sb.toString();
    }
}
