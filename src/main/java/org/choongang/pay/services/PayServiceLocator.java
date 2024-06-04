package org.choongang.pay.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.constants.MainMenu;

public class PayServiceLocator extends AbstractServiceLocator {

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new PayServiceLocator();
        }
        return instance;
    }
    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service !=  null){
            return service;
        }
        switch ((MainMenu)menu) {
            case PAY:
                service = new PayService();
                break;
        }
        return service;
    }


}
