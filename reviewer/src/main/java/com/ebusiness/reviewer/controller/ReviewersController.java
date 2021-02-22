package com.ebusiness.reviewer.controller;

import com.ebusiness.reviewer.model.Reviewers;
import com.ebusiness.reviewer.service.ReviewersService;
import com.ebusiness.reviewer.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviewers")
public class ReviewersController {
    @Autowired
    ReviewersService reviewersService;

    @GetMapping("/")
    public RespBean getReviewersList(){
        List<Reviewers> list = reviewersService.getReviewersList();
        if(list != null){
            return RespBean.ok(list);
        }
        return RespBean.error("获取评审列表失败");
    }
    @PutMapping("/update")
    public RespBean changeInEnable(int id,String isenable){
        int result = reviewersService.changeInEnable(id,isenable);
        if(result == 1){
            return  RespBean.ok(isenable+"成功");
        }
        return RespBean.error(isenable+"失败");
    }
    @PutMapping("/updateGroup/")
    public RespBean updateGroup(int groupId,int reviewerId){
        int result = reviewersService.updateGroup(groupId,reviewerId);
        if(result == 1){
            return RespBean.ok("修改分组成功");
        }
        return RespBean.error("修改分组失败");
    }
    @PutMapping("/changeMassage")
    public RespBean changeMassage(@RequestBody Reviewers reviewers){
        int result = reviewersService.changeMassage(reviewers);
        if(result == 1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }
}
