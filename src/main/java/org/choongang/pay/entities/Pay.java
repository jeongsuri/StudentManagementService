package org.choongang.pay.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pay {
    private int studentNo;
    private int payment;

}
