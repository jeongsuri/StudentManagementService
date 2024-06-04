package org.choongang.reservation.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDelete {
    private String studentNo;
    private String date;
}
