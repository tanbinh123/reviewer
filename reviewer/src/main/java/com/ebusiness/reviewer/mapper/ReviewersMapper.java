package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Reviewers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewersMapper {
    Reviewers reviewerLogin(@Param("phone") String phone,@Param("password") String password);

    List<Reviewers> getReviewersList();

    int changeInEnable(@Param("id") int id,@Param("isenable") String isenable);

    int updateGroup(@Param("groupId") int groupId,@Param("reviewerId") int reviewerId);

    @Select("select * from reviewers where id = #{id}")
    Reviewers getUserInfo(Integer id);

    int changeMassage(Reviewers reviewers);
}
