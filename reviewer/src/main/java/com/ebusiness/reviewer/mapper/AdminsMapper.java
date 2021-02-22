package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Admins;
import com.ebusiness.reviewer.model.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminsMapper {
    @Select("select * from admins where phone = #{phone} and password = #{password}")
    Admins adminLogin(@Param("phone") String phone, @Param("password") String password);
    @Select("select * from admins where id = #{id}")
    Admins getUserInfo(Integer id);
    @Select("update admins set username = #{username}, email = #{email},address = #{address},password = #{password} where id = #{id}")
    int changeMassage(Admins admins);
}
