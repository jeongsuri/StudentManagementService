 package org.choongang.template.student;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

 public class StudentListTpl implements Template {

     private Supplier<String> hook;

     @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(20000);
        sb.append(Templates.getInstance().doubleLine());
        sb.append("학생 목록\n");
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