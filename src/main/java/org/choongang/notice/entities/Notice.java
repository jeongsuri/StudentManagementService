package org.choongang.notice.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notice {
    private int NOTICE_NO;
    private String TITLE;
    private String TIME_POST;
}
