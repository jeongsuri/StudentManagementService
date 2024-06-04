package org.choongang.reservation.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Reserve {
    private String studentNo;
    private String studentNm;
    private String date;
    private String placeId;
}
