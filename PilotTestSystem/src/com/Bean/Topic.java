package com.Bean;



public class Topic {
	private int id;
	private String question;
	private String answer;
	private String type;
	private int score;
	private int chapterId;
	private String charpterName;
	private String sectionName;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	public Topic(){}
	public Topic(int id,String chaptername, String question,String type,String answer){
		this.id=id;
		this.charpterName=chaptername;
		this.question=question;
		this.type=type;
		this.answer=answer;
	}
	
	public Topic(int id, String question, String answer, String type, int score, int chapterId, String charpterName,
			String sectionName, String optionA, String optionB, String optionC, String optionD) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.type = type;
		this.score = score;
		this.chapterId = chapterId;
		this.charpterName = charpterName;
		this.sectionName = sectionName;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int charpterId) {
		this.chapterId = charpterId;
	}
	public String getChapterName() {
		return charpterName;
	}
	public void setChapterName(String charpterName) {
		this.charpterName = charpterName;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	

}
