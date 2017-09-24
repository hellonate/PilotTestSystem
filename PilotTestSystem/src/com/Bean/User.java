package com.Bean;

import java.sql.Date;

public class User {
	private int id;
	private String password;
	private String name;
	private String identity;
	private String type;
	private String question;
	private String answer;
	private Date registDate;
	private int rightNum;
	private int finishNum;
	private int errorNum;
	private int examNum;
	private String comment;
	public User(){}
	public User(String name){
		this.name=name;
	}
	public User(String name,String passw,String identity){
		this.password=passw;
		this.name=name;
		this.identity=identity;
	}
	
	public User(int id, String password, String name, String identity, String type, String question, String answer,
			Date registDate, int rightNum, int finishNum, int errorNum, int examNum, String comment) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.identity = identity;
		this.type = type;
		this.question = question;
		this.answer = answer;
		this.registDate = registDate;
		this.rightNum = rightNum;
		this.finishNum = finishNum;
		this.errorNum = errorNum;
		this.examNum = examNum;
		this.comment = comment;
	}

	public User(int id,String passw,String name,String identity){
		this.id=id;
		this.password=passw;
		this.name=name;
		this.identity=identity;
	}
	public User(String name,String password,String identity,String question,String answer){
		this.name=name;
		
		this.identity=identity;
		this.password=password;
		this.question=question;
		this.answer=answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public int getRightNum() {
		return rightNum;
	}
	public void setRightNum(int rightNum) {
		this.rightNum = rightNum;
	}
	public int getFinishNum() {
		return finishNum;
	}
	public void setFinishNum(int finishNum) {
		this.finishNum = finishNum;
	}
	public int getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}
	public int getExamNum() {
		return examNum;
	}
	public void setExamNum(int examNum) {
		this.examNum = examNum;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
