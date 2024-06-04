package org.choongang.notice.services;

import org.choongang.global.Service;
import org.choongang.notice.entities.Notice;
import org.choongang.notice.mapper.NoticeMapper;

public class NoticeSaveService implements Service<Notice> {

    private NoticeMapper mapper;

    public NoticeSaveService(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Notice form) {

    }
}
