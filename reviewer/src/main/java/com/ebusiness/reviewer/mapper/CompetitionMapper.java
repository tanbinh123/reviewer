package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Competition;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CompetitionMapper {

//    @Select("insert into competition (id,c_name) ")
    int createCompetition(Competition competition);

    List<Competition> getCompetitionList();

    List<Competition> getMyJoinCompetition(int id);

    int closeCompetitionById(Integer competitionId);
}
