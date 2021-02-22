package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Scoring;
import com.ebusiness.reviewer.model.Users;
import com.ebusiness.reviewer.model.Works;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorksMapper {


    int updateImage(@Param("userId") int userId,@Param("worksName") String worksName);


    int updateGroup(@Param("groupId") int groupId,@Param("worksId") int worksId);

    List<Users> getWorksListByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyWords") String keyWords);

    Integer getWorksTotal(String keyWords);

    int check(@Param("userId") int userId,@Param("competitionId") int competitionId);

    int insertWorks(Works works);

    int getWorksId(Works works);


    int changeStartCheck(int id);

    Integer getCheckWorksTotal(String keyWords);

    List<Users> getCheckWorksByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyWords") String keyWords,@Param("groupId") Integer groupId);

    Works getWorksDetail(int id);


    int scoring(Works works);

    int endCompetitionById(Integer competitionId);

    int computeScore(Integer competitionId);

    int computeLevel(Integer competitionId);

    List<Works> getMyWorks(Integer userId);

    Integer getScoreListTotal(String keyWords);

    List<Users> getScoreListByPage(@Param("page") Integer page,@Param("size") Integer size,@Param("keyWords") String keyWords);
}
