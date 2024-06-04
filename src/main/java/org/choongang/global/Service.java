package org.choongang.global;

import java.util.List;

public interface Service<T> {
    default void process(T form) {}
    default T get(int no) { return null; };
    default T getList(Object search) { return null; };
}
