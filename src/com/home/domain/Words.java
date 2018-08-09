package com.home.domain;

import java.io.Serializable;

public class Words implements Serializable{
	private Integer id;
	private String wordname;
	private String quality;
	private Integer state;
	private Integer userid;
	private String chinese;
	
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWordname() {
		return wordname;
	}
	public void setWordname(String wordname) {
		this.wordname = wordname;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
}
