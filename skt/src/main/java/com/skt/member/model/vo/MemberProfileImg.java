package com.skt.member.model.vo;

public class MemberProfileImg {
	private String changeName;
	private String filePath;
	private String memId;
	
	public MemberProfileImg() {
		super();
	}
	
	public MemberProfileImg(String changeName, String filePath, String memId) {
		super();
		this.changeName = changeName;
		this.filePath = filePath;
		this.memId = memId;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "MemberProfileImg [changeName=" + changeName + ", filePath=" + filePath + ", memId=" + memId + "]";
	}
	
}
