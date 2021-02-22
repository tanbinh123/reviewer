package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.ReviewersMapper;
import com.ebusiness.reviewer.model.Reviewers;
import com.ebusiness.reviewer.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewersService {
    @Autowired
    ReviewersMapper reviewersMapper;

    public Reviewers reviewerLogin(String phone, String password) {
        return reviewersMapper.reviewerLogin(phone,password);
    }

    public List<Reviewers> getReviewersList() {
        return reviewersMapper.getReviewersList();
    }

    public int changeInEnable(int id, String isenable) {
        return reviewersMapper.changeInEnable(id,isenable);
    }

    public int updateGroup(int groupId, int reviewerId) {
        return reviewersMapper.updateGroup(groupId,reviewerId);
    }

    public Reviewers getUserInfo(Integer id) {
        return reviewersMapper.getUserInfo(id);
    }

    public int changeMassage(Reviewers reviewers) {
        return reviewersMapper.changeMassage(reviewers);
    }
}
