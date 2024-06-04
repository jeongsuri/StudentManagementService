package org.choongang.template.pay;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class PayTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append(Templates.getInstance().line());
        sb.append("수령 가능한 수당 확인을 위해 학번을 입력해주세요\n");
        return sb.toString();
    }
}
