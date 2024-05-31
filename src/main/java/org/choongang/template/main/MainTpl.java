package org.choongang.template.main;
import org.choongang.template.Template;
import org.choongang.template.Templates;

public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("메뉴를 선택하세요. \n")
                .append("1. 학생관리\n")
                .append("2. 출석관리\n")
                .append("3. 수당관리\n")
                .append("4. 점수관리\n")
                .append("5. 예약관리\n")
                .append("6. 좌석관리\n")
                .append("7. 공지관리\n")
                .append(Templates.getInstance().line());
        return sb.toString();
    }
}
