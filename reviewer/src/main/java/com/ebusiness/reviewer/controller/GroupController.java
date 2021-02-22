package com.ebusiness.reviewer.controller;

import com.ebusiness.reviewer.model.Group;
import com.ebusiness.reviewer.service.GroupService;
import com.ebusiness.reviewer.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/")
    public RespBean getGroupList(){
        List<Group> list = groupService.getGroupList();
        if(list !=null){
            return RespBean.ok(list);
        }
        return RespBean.error("获取小组列表失败");
    }

    @PostMapping("/")
    public RespBean createGroup(@RequestBody Group group){
        groupService.createGroup(group);
        return RespBean.ok("创建小组成功");
    }
}
