package com.ebusiness.reviewer.mapper;

import com.ebusiness.reviewer.model.Scoring;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoringMapper {


    void insertScoringRecord(Scoring scoring);

    int check(@Param("reviewerId") Integer reviewerId,@Param("workId") Integer id);

    void updateScoringRecord(Scoring scoring);

    List<Scoring> getScoringRecords();
}
