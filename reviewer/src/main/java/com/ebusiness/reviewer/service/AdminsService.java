package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.AdminsMapper;
import com.ebusiness.reviewer.model.Admins;
import com.ebusiness.reviewer.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminsService {
    @Autowired
    AdminsMapper adminsMapper;

    public Admins adminLogin(String phone, String password) {
        return adminsMapper.adminLogin(phone,password);
    }

    public Admins getUserInfo(Integer id) {
        return adminsMapper.getUserInfo(id);
    }

    public int changeMassage(Admins admins) {
        return adminsMapper.changeMassage(admins);
    }
}
