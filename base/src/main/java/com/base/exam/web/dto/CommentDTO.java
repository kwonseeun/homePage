package com.base.exam.web.dto;

import java.util.Date;

public class CommentDTO {
	
	private int rid;
	private int bid;
	private String content;
	private String reg_id;
	private Date reg_dt;
	private Date edit_dt;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Date getEdit_dt() {
		return edit_dt;
	}
	public void setEdit_dt(Date edit_dt) {
		this.edit_dt = edit_dt;
	}
	
	@Override
	public String toString() {
		return "CommentDTO [rid=" + rid + ", bid=" + bid + ", content=" + content + ", reg_id=" + reg_id + ", reg_dt="
				+ reg_dt + ", edit_dt=" + edit_dt + "]";
	}
}
