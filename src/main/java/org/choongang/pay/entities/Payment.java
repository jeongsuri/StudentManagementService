package org.choongang.pay.entities;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class Payment {
    String studentNo;
    String payment;
}


