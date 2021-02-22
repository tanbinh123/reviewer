package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.CompetitionMapper;
import com.ebusiness.reviewer.mapper.UsersMapper;
import com.ebusiness.reviewer.model.Competition;
import com.ebusiness.reviewer.model.Users;
import com.ebusiness.reviewer.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersMapper usersMapper;

    @Autowired
    CompetitionMapper competitionMapper;
    public int register(Users users) {
        System.out.println(users.getPhone());
        if(usersMapper.findPhone(users.getPhone())>=1){
            return 0;
        }else{
            return usersMapper.register(users);
        }
    }

    public Users userLogin(String phone, String password) {
        return usersMapper.userLogin(phone,password);
    }

    public void joinCompetition(int userId, int competitionId) {
         usersMapper.joinCompetition(userId,competitionId);
    }

    public int check(int userId, int competitionId) {
        return usersMapper.check(userId,competitionId);
    }

    public List<Competition> getMyJoinCompetition(int id) {
        return competitionMapper.getMyJoinCompetition(id);
    }

    public RespPageBean getUsersList(Integer page,Integer size,String keyWords ) {
        if (page != null && size !=null) {
            page = (page-1)*size;
        }
        List<Users> data = usersMapper.getUsersListByPage(page,size,keyWords);
        Integer total = usersMapper.getUsersTotal(keyWords);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public int changeInEnable(int id, String isenable) {
        return usersMapper.changeInEnable(id,isenable);
    }

    public Users getUserMessageByPhone(String phone) {
        return usersMapper.getUserMessageByPhone(phone);
    }

    public int checkQuestion(Users users) {
        return usersMapper.checkQuestion(users);
    }

    public int updatePassword(Users users) {
        return usersMapper.updatePassword(users);
    }

    public Users getUserInfo(Integer id) {
        return usersMapper.getUserInfo(id);
    }

    public int changeMassage(Users users) {
        return usersMapper.changeMassage(users);
    }
}
