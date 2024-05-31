package org.choongang.template;

import org.choongang.global.constants.Menu;
import org.choongang.template.main.MainTpl;
import org.choongang.template.reservation.ReservationTpl;

import java.util.HashMap;
import java.util.Map;

public class Templates {
    private static Templates instance;
    private Map<Menu, Template> tpls;
    private Templates() {
        tpls = new HashMap<>();
    }
    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }
    public void render(Menu menu) {
        render(menu, null);
    }

    public <T> void render(Menu menu, T data) {
        System.out.println(find(menu,data).getTpl());
    }


    public <T> Template find(Menu menu, T data){
        Template tpl = tpls.get(menu);
        if(tpl != null){
            return tpl;
        }
        switch (menu){
            case RESERVATION: tpl = new ReservationTpl(); break;
            default: tpl = new MainTpl();
        }

        if (data != null) {
            tpl.setData(data);
        }

        tpls.put(menu,tpl);
        return tpl;
    }

    public String line(){
        return "------------------------------------------\n";
    }

    public String doubleLine(){
        return "==========================================\n";
    }
}
