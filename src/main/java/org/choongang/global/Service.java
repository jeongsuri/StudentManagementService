package org.choongang.global;

public interface Service<T> {
    default void process(T form) {}
    default T process() {
        return null;
    }
    default <T> T get(int no) { return null; }

    }
