package com.ebusiness.reviewer.controller;

import com.ebusiness.reviewer.model.Admins;
import com.ebusiness.reviewer.model.Competition;
import com.ebusiness.reviewer.model.Reviewers;
import com.ebusiness.reviewer.model.Users;
import com.ebusiness.reviewer.service.AdminsService;
import com.ebusiness.reviewer.service.ReviewersService;
import com.ebusiness.reviewer.service.UsersService;
import com.ebusiness.reviewer.utils.RespBean;
import com.ebusiness.reviewer.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;
    @Autowired
    ReviewersService reviewersService;
    @Autowired
    AdminsService adminsService;

    @GetMapping("/")
    public RespPageBean getUsersList(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer size, String keyWords) {
        return usersService.getUsersList(page, size, keyWords);
    }

    @PostMapping("/register")
    public RespBean register(@RequestBody Users users) {
        int result = usersService.register(users);
        if (result == 1) {
            return RespBean.ok("注册成功");
        }
        return RespBean.error("手机号已注册");
    }

    @PostMapping("/Login")
    public RespBean login(String phone, String password, String ID) {
        if (ID.equals("学生")) {
            Users users = usersService.userLogin(phone, password);
            if (users != null) {
                return RespBean.ok("登录成功", users);
            }
        } else if (ID.equals("评委")) {
            Reviewers reviewers = reviewersService.reviewerLogin(phone, password);
            if (reviewers != null) {
                return RespBean.ok("登录成功", reviewers);
            }
        } else if (ID.equals("管理员")) {
            Admins admins = adminsService.adminLogin(phone, password);
            if (admins != null) {
                return RespBean.ok("登录成功", admins);
            }
        }
        return RespBean.error("用户名或密码错误");
    }

    @PutMapping("/join")
    public RespBean joinCompetition(int userId, int competitionId) {
        System.out.println(userId + "," + competitionId);
        int result = usersService.check(userId, competitionId);
        if (result == 1) {
            return RespBean.error("你已经报名过该比赛了");
        } else {
            usersService.joinCompetition(userId, competitionId);
            return RespBean.ok("参赛成功,请于报名截止日期前提交作品");
        }
    }

    @GetMapping("/joinList")
    public RespBean getMyJoinCompetition(int id) {
        List<Competition> list = usersService.getMyJoinCompetition(id);
        if (list != null) {
            return RespBean.ok(list);
        }
        return RespBean.error("获取列表失败");
    }

    @PutMapping("/update")
    public RespBean changeInEnable(int id, String isenable) {
        int result = usersService.changeInEnable(id, isenable);
        if (result == 1) {
            return RespBean.ok(isenable + "成功");
        }
        return RespBean.error(isenable + "失败");
    }

    @GetMapping("/getUserMessageByPhone/")
    public RespBean getUserMessageByPhone(String phone) {
        Users user = usersService.getUserMessageByPhone(phone);
        if (user != null) {
            return RespBean.ok(user);
        }
        return RespBean.error("没有该用户");
    }

    @PostMapping("/checkQuestion")
    public RespBean checkQuestion(@RequestBody Users users) {
        int result = usersService.checkQuestion(users);
        if (result == 1) {
            return RespBean.ok("验证成功");
        }
        return RespBean.error("答案错误");
    }

    @PostMapping("/updatePassword/")
    public RespBean updatePassword(@RequestBody Users users) {
        int result = usersService.updatePassword(users);
        if (result == 1) {
            return RespBean.ok("改密成功");
        }
        return RespBean.error("修改失败");
    }

    //    查看个人中心
    @GetMapping("/userinfo")
    public RespBean getUserInfo(Integer id, String position) {
        System.out.println(position);
        if(position.equals("学生")){
            Users users = usersService.getUserInfo(id);
            if(users != null){
                return RespBean.ok(users);
            }
        }else if(position.equals("管理员")) {
            Admins admins = adminsService.getUserInfo(id);
            if (admins != null) {
                return RespBean.ok(admins);
            }
        }else if(position.equals("评审")){
            Reviewers reviewers = reviewersService.getUserInfo(id);
            if(reviewers != null){
                return RespBean.ok(reviewers);
            }
        }
        return RespBean.error("没有该用户");
    }
//    修改个人数据，分三种身份
    @PutMapping("/changeMassage")
    public RespBean changeMassage(@RequestBody Users users){
        int result = usersService.changeMassage(users);
        if(result == 1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }
}
