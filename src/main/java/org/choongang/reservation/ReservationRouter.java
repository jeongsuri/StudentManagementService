package org.choongang.reservation;


import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.reservation.constants.ReservaitonMenu;
import org.choongang.reservation.controllers.ReservationControllersLocator;

public class ReservationRouter implements Router {
    private static Router instance;
    private ReservationRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new ReservationRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        Controller controller = null;
        ReservaitonMenu rMenu = (ReservaitonMenu) menu;
        ControllerLocator locator = ReservationControllersLocator.getInstance();
        switch (rMenu) {
            case RESERVE: controller =  locator.find(ReservaitonMenu.RESERVE); break;
            case SEARCH: controller =  locator.find(ReservaitonMenu.SEARCH); break;
            case DELETE: controller =  locator.find(ReservaitonMenu.DELETE); break;
            default:
                MainRouter.getInstance().change(MainMenu.RESERVATION);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
