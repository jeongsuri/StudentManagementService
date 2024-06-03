package org.choongang.template.grade;

import org.choongang.global.constants.Menu;
import org.choongang.template.Template;
import org.choongang.template.Templates;

public class GradeTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("학번을 입력하세요 .\n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}
