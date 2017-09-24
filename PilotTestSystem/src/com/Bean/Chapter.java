package com.Bean;

public class Chapter {
	private int chapterId;
	private String name;
	private String content;
	private String comment;
	private String status;
	public Chapter(){}
	public Chapter(String name,String content,String comment){
		this.name=name;
		this.content=content;
		this.comment=comment;
	}
	public Chapter(int chapterId,String name,String comment){
		this.chapterId=chapterId;
		this.name=name;
		this.comment=comment;
		
	}
	public int getChapterId() {
		return chapterId;
	}
	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
