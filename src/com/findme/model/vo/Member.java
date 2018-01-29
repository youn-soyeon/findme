package com.findme.model.vo;

public class Member {
	private String memId;
	private String password;
	private int point;

	public Member(String memId, String password) {
		this.memId = memId;
		this.password = password;
	}

	
	public Member(String memId, String password, int point) {
		this.memId = memId;
		this.password = password;
		this.point = point;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Member [memId=" + memId + ", password=" + password + ", point=" + point + "]";
	}
}
