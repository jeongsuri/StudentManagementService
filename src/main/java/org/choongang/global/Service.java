package org.choongang.global;

import org.choongang.reservation.entities.RequestList;

public interface Service<T> {
    default void process(T form) {};
    default T process() {
        return null;
    }
}
