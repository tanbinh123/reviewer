package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Competition;
import com.ebusiness.reviewer.model.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {

     int register(Users users);
    @Select("select count(*) from users where phone = #{phone}")
    int findPhone(String phone);

    @Select("select * from users where phone = #{phone} and password = #{password}")
    Users userLogin(@Param("phone") String phone,@Param("password") String password);

    @Select("insert into user_competition (id,user_id,competition_id,create_time) values(default,#{userId},#{competitionId},NOW())")
    void joinCompetition(@Param("userId") int userId,@Param("competitionId") int competitionId);

    @Select("select count(*) from user_competition where user_id = #{userId} and competition_id =#{competitionId}")
    int check(@Param("userId") int userId,@Param("competitionId") int competitionId);


    int changeInEnable(@Param("id") int id, @Param("isenable") String isenable);

    @Select("select * from users where phone = #{phone}")
    Users getUserMessageByPhone(String phone);

    @Select("select count(*) from users where phone = #{phone} and answer = #{answer} and question = #{question}")
    int checkQuestion(Users users);

    int updatePassword(Users users);

    Integer getUsersTotal(String keyWords);

    List<Users> getUsersListByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyWords") String keyWords);

    @Select("select * from users where id= #{id}")
    Users getUserInfo(Integer id);

    int changeMassage(Users users);
}
