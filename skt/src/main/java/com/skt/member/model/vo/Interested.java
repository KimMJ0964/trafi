package com.skt.member.model.vo;

public class Interested {
	private String memId;
	private int courseNo;
	private int fsNo;
	private int tourNo;
	
	public Interested() {
		super();
	}
	
	public Interested(String memId, int courseNo, int fsNo, int tourNo) {
		super();
		this.memId = memId;
		this.courseNo = courseNo;
		this.fsNo = fsNo;
		this.tourNo = tourNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public int getTourNo() {
		return tourNo;
	}

	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}

	@Override
	public String toString() {
		return "Interested [memId=" + memId + ", courseNo=" + courseNo + ", fsNo=" + fsNo + ", tourNo=" + tourNo + "]";
	}
	
	
}
