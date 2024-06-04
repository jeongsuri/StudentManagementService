package org.choongang.reservation.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.reservation.constants.ReservaitonMenu;

public class ReservationServiceLocator extends AbstractServiceLocator {

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new ReservationServiceLocator();
        }
        return instance;
    }


    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }

        if (menu instanceof ReservaitonMenu) {
            ReservaitonMenu subMenu = (ReservaitonMenu)menu;
            switch (subMenu) {
                case RESERVE: service = new InsertReservationSerivce(); break;
                case DELETE: service = new DeleteReservationSerivce(); break;
                case SEARCH: service = new ListReservationSerivce(); break;
            }

        } else { // 주메뉴

        }

        services.put(menu, service);

        return service;
    }
}