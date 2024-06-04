package org.choongang.reservation.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestRes {
    private String studentNo;
    private String date;
    private String placeId;
}
