package com.Bean;

import java.sql.Date;

public class Exam {
	private int id;
	private Date examTime;
	private int duration;
	private String creator;
	private String type;
	private String examName;
	private int choiceNum;
	private int choiceScore;
	private int judgeNum;
	private int judgeScore;
	private int blankNum;
	private int blankScore;
	private String comment;
	public Exam(){}
	
	public Exam(int id, Date examTime, int duration, String creator, String type, String examName, int choiceNum,
			int choiceScore, int judgeNum, int judgeScore, int blankNum, int blankScore, String comment) {
		super();
		this.id = id;
		this.examTime = examTime;
		this.duration = duration;
		this.creator = creator;
		this.type = type;
		this.examName = examName;
		this.choiceNum = choiceNum;
		this.choiceScore = choiceScore;
		this.judgeNum = judgeNum;
		this.judgeScore = judgeScore;
		this.blankNum = blankNum;
		this.blankScore = blankScore;
		this.comment = comment;
	}

	public Exam(int id,Date examTime,String examName,String type,int duration,String creator){
		this.id=id;
		this.type=type;
		this.creator=creator;
		this.duration=duration;
		this.examName=examName;
		this.examTime=examTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getExamTime() {
		return examTime;
	}
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getChoiceNum() {
		return choiceNum;
	}
	public void setChoiceNum(int choiceName) {
		this.choiceNum = choiceName;
	}
	public int getChoiceScore() {
		return choiceScore;
	}
	public void setChoiceScore(int choiceScore) {
		this.choiceScore = choiceScore;
	}
	public int getJudgeNum() {
		return judgeNum;
	}
	public void setJudgeNum(int judgeNum) {
		this.judgeNum = judgeNum;
	}
	public int getJudgeScore() {
		return judgeScore;
	}
	public void setJudgeScore(int judgeScore) {
		this.judgeScore = judgeScore;
	}
	public int getBlankNum() {
		return blankNum;
	}
	public void setBlankNum(int blankNum) {
		this.blankNum = blankNum;
	}
	public int getBlankScore() {
		return blankScore;
	}
	public void setBlankScore(int blankScore) {
		this.blankScore = blankScore;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
