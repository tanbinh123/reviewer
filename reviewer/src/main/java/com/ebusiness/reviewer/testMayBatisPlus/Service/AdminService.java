package com.ebusiness.reviewer.testMayBatisPlus.Service;

import com.ebusiness.reviewer.model.Admins;
import com.ebusiness.reviewer.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService{

    @Autowired
    private AdminMapper adminMapper;

    public Admins getAdminMapper(int id) {

        Admins admins = adminMapper.selectById(id);

        System.out.println(admins.toString());
        return admins;
    }
}
