package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.GroupMapper;
import com.ebusiness.reviewer.model.Group;
import org.apache.catalina.mbeans.GroupMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupMapper groupMapper;

    public List<Group> getGroupList() {
        return groupMapper.getGroupList();
    }

    public void createGroup(Group group) {
        groupMapper.createGroup(group);
    }
}
