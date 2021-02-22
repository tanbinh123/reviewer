package com.ebusiness.reviewer.controller;

import com.ebusiness.reviewer.model.Admins;
import com.ebusiness.reviewer.service.AdminsService;
import com.ebusiness.reviewer.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    AdminsService adminsService;
    @PutMapping("/changeMassage")
    public RespBean changeMassage(@RequestBody Admins admins){
        int result = adminsService.changeMassage(admins);
        if(result == 1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }
}
