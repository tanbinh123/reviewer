package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.NoticeMapper;
import com.ebusiness.reviewer.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;

    public void insertNotice(String  content) {
        noticeMapper.insertNotice(content);
    }


    public List<Notice> getNoticeList() {
        return noticeMapper.getNoticeList();
    }
}
