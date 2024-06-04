package org.choongang.template.notice;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

public class NoticeListTpl implements Template {

    private Supplier<String> hook;

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append(Templates.getInstance().doubleLine());
        sb.append("공지사항\n");
        sb.append(Templates.getInstance().doubleLine());
        if (hook != null) {
            sb.append(hook.get());
        }
        return sb.toString();
    }

    @Override
    public void addHook(Supplier<String> hook) {
        this.hook = hook;
    }
}
