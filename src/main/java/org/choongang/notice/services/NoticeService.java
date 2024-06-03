package org.choongang.notice.services;

import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.notice.entities.Notice;
import org.choongang.notice.mapper.NoticeMapper;

import java.util.List;

public class NoticeService implements Service<List<Notice>> {
    @Override
    public List<Notice> process() {
        NoticeMapper mapper = DBConn.getSession().getMapper(NoticeMapper.class);
        return mapper.getNotice();
    }
}


