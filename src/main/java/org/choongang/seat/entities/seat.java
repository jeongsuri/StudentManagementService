package org.choongang.seat.entities;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class seat {
    private List<Number> seatNum;
}
