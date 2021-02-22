package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Notice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeMapper {

    @Select("insert into notice (id,content,create_time,isenable) values(default,#{content},NOW(),'可用')")
    void insertNotice(String  content);

    @Select("select * from notice where isenable = '可用'")
    List<Notice> getNoticeList();
}
