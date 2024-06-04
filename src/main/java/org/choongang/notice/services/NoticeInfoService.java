package org.choongang.notice.services;

import org.choongang.global.Service;
import org.choongang.notice.entities.Notice;
import org.choongang.notice.mapper.NoticeMapper;

import java.util.List;

public class NoticeInfoService implements Service<List<Notice>> {
    private NoticeMapper mapper;

    public NoticeInfoService(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Notice> process() {
        return mapper.getNotice();
    }

    @Override
    public Notice get(int no) {
        return mapper.getContent(no);
    }
}


