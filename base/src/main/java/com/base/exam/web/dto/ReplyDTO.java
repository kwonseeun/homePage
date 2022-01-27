package com.base.exam.web.dto;

import java.util.Date;

public class ReplyDTO {
	
	private int cno;
	private String bid;
	private String content;
	private String regId;
	private Date regDttm;
	private String delYn;
	private String updtId;
	private Date updtDttm;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Date getRegDttm() {
		return regDttm;
	}
	public void setRegDttm(Date regDttm) {
		this.regDttm = regDttm;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public Date getUpdtDttm() {
		return updtDttm;
	}
	public String getUpdtId() {
		return updtId;
	}
	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}
	public void setUpdtDttm(Date updtDttm) {
		this.updtDttm = updtDttm;
	}
	@Override
	public String toString() {
		return "ReplyDTO [cno=" + cno + ", bid=" + bid + ", content=" + content + ", regId=" + regId + ", regDttm="
				+ regDttm + ", delYn=" + delYn + ", updpId="  + ", updtDttm=" + updtDttm + "]";
	}
	
}
