package com.ebusiness.reviewer.controller;

import com.ebusiness.reviewer.model.Notice;
import com.ebusiness.reviewer.service.NoticeService;
import com.ebusiness.reviewer.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @GetMapping("/publish")
    public RespBean insertNotice(String content){
        noticeService.insertNotice(content);
        return RespBean.ok("发布公告成功");
    }
    @GetMapping("/")
    public  RespBean getNoticeList(){
        List<Notice> list =  noticeService.getNoticeList();
        if(list != null){
            return RespBean.ok("",list);
        }
        return RespBean.error("获取公告失败");
    }
}
