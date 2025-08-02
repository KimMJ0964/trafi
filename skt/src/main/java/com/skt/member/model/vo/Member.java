package com.skt.member.model.vo;

public class Member {
	private String memId;
	private String memPwd;
	private String memName;
	private String phone;
	private String address;
	private String memNo;
	private String email;
	private String status;
	private String grade;
	
	public Member() {
		super();
	}
	
	public Member(String memId, String memPwd, String memName, String phone, String address, String memNo, String email,
			String status, String grade) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.phone = phone;
		this.address = address;
		this.memNo = memNo;
		this.email = email;
		this.status = status;
		this.grade = grade;
	}
	
	public Member(String memId, String memName, String phone, String address, String memNo, String email) {
		super();
		this.memId = memId;
		this.memName = memName;
		this.phone = phone;
		this.address = address;
		this.memNo = memNo;
		this.email = email;
	}
	
	public Member(String memId, String memPwd, String memName, String phone, String address, String memNo, String email) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
		this.memName = memName;
		this.phone = phone;
		this.address = address;
		this.memNo = memNo;
		this.email = email;
	}
	
	public Member(String memId, String memPwd) {
		super();
		this.memId = memId;
		this.memPwd = memPwd;
	}
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemNo() {
		return memNo;
	}

	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memPwd=" + memPwd + ", memName=" + memName + ", phone=" + phone
				+ ", address=" + address + ", memNo=" + memNo + ", email=" + email + ", status=" + status + ", grade="
				+ grade + "]";
	}
}
