package com.ebusiness.reviewer.testMayBatisPlus.Controller;

import com.ebusiness.reviewer.model.Admins;
import com.ebusiness.reviewer.testMayBatisPlus.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAdminById")
    public Admins getAdminById(@PathVariable int id){

        return adminService.getAdminMapper(id);
    }
}
