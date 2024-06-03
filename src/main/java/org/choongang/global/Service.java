package org.choongang.global;

import org.choongang.pay.entities.Pay;

import java.util.List;

public interface Service<T> {
    List<Pay> process(T form);
}
