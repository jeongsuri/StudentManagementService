package org.choongang.notice.controllers;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestInsertNotice {
    private String title;
    private String content;
}
