package com.shop.dto;

import java.sql.Date;

public class TextVo {
	private int num;
	private String title;
	private String content;
	private String userId;
	private Date reg_date;
	private int  viewCnt;
	private String fileP;
	
	public String getFileP() {
		return fileP;
	}
	public void setFileP(String fileP) {
		this.fileP = fileP;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "TextVo [num=" + num + ", title=" + title + ", content=" + content + ", userId=" + userId + ", reg_date="
				+ reg_date + ", viewCnt=" + viewCnt + ", fileP=" + fileP + "]";
	}
	
}
