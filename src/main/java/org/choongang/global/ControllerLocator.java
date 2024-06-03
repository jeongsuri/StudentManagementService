package org.choongang.global;

import org.choongang.global.constants.MainMenu;

public interface ControllerLocator {
    Controller find(Menu menu);
}
