package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupMapper {

    List<Group> getGroupList();

    @Select("insert INTO `group` (id,group_name,isenable,create_time) VALUES(DEFAULT,#{groupName},'可用',NOW())")
    void createGroup(Group group);
    @Select("select COUNT(*) from `group`")
    int findGroupNum();
}
