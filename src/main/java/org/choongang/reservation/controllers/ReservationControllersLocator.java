package org.choongang.reservation.controllers;

import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.reservation.controllers.DeleteReservaionController;
import org.choongang.reservation.controllers.InsertReservationContoller;
import org.choongang.reservation.controllers.ListReservationController;


public class ReservationControllersLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;

    private ReservationControllersLocator(){

    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new ReservationControllersLocator();
        }
        return instance;
    }


    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);

        if (controller != null) {
            return controller;
        }

        ReservaitonMenu rMenu = (ReservaitonMenu) menu;
        switch (rMenu) {
            case RESERVE: controller = new InsertReservationContoller(); break;
            case SEARCH: controller = new ListReservationController(); break;
            case DELETE: controller = new DeleteReservaionController(); break;
        }

        controllers.put(menu, controller);

        return controller;
    }
}

