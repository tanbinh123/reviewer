package com.ebusiness.reviewer.model;

import java.util.List;

public class Works {
    private int id;
    private String worksName;
    private Integer userId;
    private int  averageScore;
    private int  totalScore;
    private int level;
    private int totalLevel;
    private String createTime;
    private int groupId;
    private int competitionId;
    private Competition competition;
    private String startCheck;
    private String checkEnd;
    private String reviewersNum;

    private Users users;
    private Group group;
    private List<Image> images;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalLevel() {
        return totalLevel;
    }

    public void setTotalLevel(int totalLevel) {
        this.totalLevel = totalLevel;
    }

    public String getReviewersNum() {
        return reviewersNum;
    }

    public void setReviewersNum(String reviewersNum) {
        this.reviewersNum = reviewersNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getStartCheck() {
        return startCheck;
    }

    public void setStartCheck(String startCheck) {
        this.startCheck = startCheck;
    }

    public String getCheckEnd() {
        return checkEnd;
    }

    public void setCheckEnd(String checkEnd) {
        this.checkEnd = checkEnd;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
