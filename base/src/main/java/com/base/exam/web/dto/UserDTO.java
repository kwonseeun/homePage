package com.base.exam.web.dto;

import java.sql.Date;

import com.base.core.web.dto.PagingDTO;

public class UserDTO extends PagingDTO{

	private String id;
	private String pw;
	private Date joinDttm;
	private String email;
	private String name;
	private String status;
	private String delYn;
	private Date lastLoginDttm;
	
	private String resultCode;
	private String resultMsg;

	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getJoinDttm() {
		return joinDttm;
	}
	public void setJoinDttm(Date joinDttm) {
		this.joinDttm = joinDttm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public Date getLastLoginDttm() {
		return lastLoginDttm;
	}
	public void setLastLoginDttm(Date lastLoginDttm) {
		this.lastLoginDttm = lastLoginDttm;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", joinDttm=" + joinDttm + ", email=" + email + ", name=" + name
				+ ", status=" + status + ", delYn=" + delYn + ", lastLoginDttm=" + lastLoginDttm + "]";
	}
}