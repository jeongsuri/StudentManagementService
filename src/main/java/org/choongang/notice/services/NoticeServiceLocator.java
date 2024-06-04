package org.choongang.notice.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.notice.constants.NoticeMenu;
import org.choongang.notice.mapper.NoticeMapper;

public class NoticeServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new NoticeServiceLocator();
        }

        return instance;
     }

     public NoticeMapper noticeMapper() {
        return DBConn.getSession().getMapper(NoticeMapper.class);
     }

    @Override
    public Service find(Menu menu) {

        Service service = null;
        NoticeMenu nMenu = (NoticeMenu)menu;
        switch (nMenu) {
            case NOTICE_UPDATE: // 공지사항 수정 구현 X
            case NOTICE_WRITE: service = new NoticeSaveService(noticeMapper()); break;
            case NOTICE_LIST: service = new NoticeInfoService(noticeMapper()); break;
            case NOTICE_DELETE: service = new NoticeDeleteService(noticeMapper()); break;
        }

        return service;
    }
}
