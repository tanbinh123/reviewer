package com.ebusiness.reviewer.model;

public class Scoring {
    private Integer id;
    private Integer reviewerId;
    private Integer workId;
    private Integer score;
    private Integer scoreTimes;
    private String createTime;
    private Reviewers reviewer;
    private Works works;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScoreTimes() {
        return scoreTimes;
    }

    public void setScoreTimes(Integer scoreTimes) {
        this.scoreTimes = scoreTimes;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Reviewers getReviewer() {
        return reviewer;
    }

    public Works getWorks() {
        return works;
    }

    public void setWorks(Works works) {
        this.works = works;
    }

    public void setReviewer(Reviewers reviewer) {
        this.reviewer = reviewer;
    }
}
