package com.ebusiness.reviewer.service;

import com.ebusiness.reviewer.mapper.GroupMapper;
import com.ebusiness.reviewer.mapper.ImageMapper;
import com.ebusiness.reviewer.mapper.ScoringMapper;
import com.ebusiness.reviewer.mapper.WorksMapper;
import com.ebusiness.reviewer.model.Image;
import com.ebusiness.reviewer.model.Scoring;
import com.ebusiness.reviewer.model.Users;
import com.ebusiness.reviewer.model.Works;
import com.ebusiness.reviewer.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class WorksService {
    @Autowired
    WorksMapper worksMapper;

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    ScoringMapper scoringMapper;

    @Autowired
    GroupMapper groupMapper;

    public int updateGroup(int groupId, int worksId) {
        return worksMapper.updateGroup(groupId,worksId);
    }

    public RespPageBean getWorksListByPage(Integer page, Integer size, String keyWords) {

        if (page != null && size !=null) {
            page = (page-1)*size;
        }
        List<Users> data = worksMapper.getWorksListByPage(page,size,keyWords);
        Integer total = worksMapper.getWorksTotal(keyWords);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }


    public int check(int userId, int competitionId) {
        return worksMapper.check(userId,competitionId);
    }


    public int insertWorks(Works works) {
//        查询出当前小组数量，生成随机数，随机分配小组
        int result = groupMapper.findGroupNum();
        Random random = new Random();
        int groupId = random.nextInt(result)+1;
        works.setGroupId(groupId);
        return worksMapper.insertWorks(works);
    }

    public int getWorksId(Works works) {
        return worksMapper.getWorksId(works);
    }


    public int uploadImage(Image image) {
        return imageMapper.uploadImage(image);
    }

    public int changeStartCheck(int id) {
        return worksMapper.changeStartCheck(id);
    }

    public RespPageBean getCheckWorksByPage(Integer page, Integer size, String keyWords,Integer groupId) {
        if (page != null && size !=null) {
            page = (page-1)*size;
        }
        List<Users> data = worksMapper.getCheckWorksByPage(page,size,keyWords,groupId);
        Integer total = worksMapper.getCheckWorksTotal(keyWords);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Works getWorksDetail(int id) {
        return worksMapper.getWorksDetail(id);
    }


    @Transactional
    public int scoring(Integer id, Integer totalLevel, Integer totalScore, Integer reviewerId) {
        Works works = new Works();
        works.setTotalLevel(totalLevel);
        works.setTotalScore(totalScore);
//        这里的id是workId
        works.setId(id);

        Scoring scoring = new Scoring();
        scoring.setScore(totalScore);
        scoring.setReviewerId(reviewerId);
        scoring.setWorkId(id);
//        对一个作品已经打过一次分数
        if(scoringMapper.check(reviewerId,id)==1){
//            就修改
            scoringMapper.updateScoringRecord(scoring);
        }
        else {
//            往打分记录表中插入一条数据
            scoringMapper.insertScoringRecord(scoring);
        }
//        但是无论如何打分都会进行
        return worksMapper.scoring(works);
    }

    @Transactional
    public int endCompetitionById(Integer competitionId) {
        int result = worksMapper.endCompetitionById(competitionId);
        result = worksMapper.computeScore(competitionId);
        result = worksMapper.computeLevel(competitionId);
        return result;
    }

    public List<Works> getMyWorks(Integer userId) {
        return worksMapper.getMyWorks(userId);
    }

    public RespPageBean getScoreListByPage(Integer page, Integer size, String keyWords) {

        if (page != null && size !=null) {
            page = (page-1)*size;
        }
        List<Users> data = worksMapper.getScoreListByPage(page,size,keyWords);
        Integer total = worksMapper.getScoreListTotal(keyWords);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;

    }
}
