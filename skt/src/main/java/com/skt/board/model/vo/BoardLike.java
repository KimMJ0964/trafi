package com.skt.board.model.vo;

public class BoardLike {
	private int commNo;
	private String memId;
	private int likeStatus;
	
	public BoardLike() {
		super();
	}

	public BoardLike(int commNo, String memId, int likeStatus) {
		super();
		this.commNo = commNo;
		this.memId = memId;
		this.likeStatus = likeStatus;
	}

	public int getCommNo() {
		return commNo;
	}

	public void setCommNo(int commNo) {
		this.commNo = commNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	@Override
	public String toString() {
		return "BoardLike [commNo=" + commNo + ", memId=" + memId + ", likeStatus=" + likeStatus + "]";
	}
	
}
