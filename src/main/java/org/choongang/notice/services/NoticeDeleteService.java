package org.choongang.notice.services;

import org.choongang.global.Service;
import org.choongang.notice.mapper.NoticeMapper;

public class NoticeDeleteService implements Service<Integer> {
    private NoticeMapper mapper;

    public NoticeDeleteService(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Integer noticeNo) {
    }
}
