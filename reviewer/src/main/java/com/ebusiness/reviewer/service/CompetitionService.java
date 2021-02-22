package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.CompetitionMapper;
import com.ebusiness.reviewer.mapper.ScoringMapper;
import com.ebusiness.reviewer.model.Competition;
import com.ebusiness.reviewer.model.Scoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;
    @Autowired
    ScoringMapper scoringMapper;

    public int createCompetition(Competition competition) {
        System.out.println(competition.getId());
        return competitionMapper.createCompetition(competition);
    }

    public List<Competition> getCompetitionList() {
        return competitionMapper.getCompetitionList();
    }


    public List<Scoring> getScoringRecords() {

        return scoringMapper.getScoringRecords();
    }

    public int closeCompetitionById(Integer competitionId) {
        return competitionMapper.closeCompetitionById(competitionId);
    }
}
