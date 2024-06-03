package org.choongang.global;

import org.choongang.global.constants.MainMenu;

public interface ServiceLocator<T> {
    Service<T> find(Menu menu);
}
