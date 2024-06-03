package org.choongang.template.pay;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class Pay implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("수당 지급 내역");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}
