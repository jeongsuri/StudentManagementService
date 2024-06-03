package org.choongang.template.pay;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class PayTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append(Templates.getInstance().line());
        sb.append("수당관리\n");
        return sb.toString();
    }
}
