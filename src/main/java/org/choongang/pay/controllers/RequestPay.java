package org.choongang.pay.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPay {

    private int studentNo;
    private int payment;
    private int pay;
}
