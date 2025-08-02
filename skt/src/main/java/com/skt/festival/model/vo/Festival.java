package com.skt.festival.model.vo;

public class Festival {
	private int fsNo;
	private String fsName;
	private String fsArea;
	private String fsSeason;
	private String fsTema;
	private String fsImg;
	private String fsUrl;
	private String fsDct;
	private int fsLike;
	private double fsLat;
	private double fsLong;
	private String fsEnd;
	private String fsStart;

	public Festival() {
		super();
	}

	public Festival(int fsNo, String fsName, String fsArea, String fsSeason, String fsTema, String fsImg, String fsUrl,
			String fsDct, int fsLike, double fsLat, double fsLong, String fsEnd, String fsStart) {
		super();
		this.fsNo = fsNo;
		this.fsName = fsName;
		this.fsArea = fsArea;
		this.fsSeason = fsSeason;
		this.fsTema = fsTema;
		this.fsImg = fsImg;
		this.fsUrl = fsUrl;
		this.fsDct = fsDct;
		this.fsLike = fsLike;
		this.fsLat = fsLat;
		this.fsLong = fsLong;
		this.fsEnd = fsEnd;
		this.fsStart = fsStart;
	}

	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public String getFsName() {
		return fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsArea() {
		return fsArea;
	}

	public void setFsArea(String fsArea) {
		this.fsArea = fsArea;
	}

	public String getFsSeason() {
		return fsSeason;
	}

	public void setFsSeason(String fsSeason) {
		this.fsSeason = fsSeason;
	}

	public String getFsTema() {
		return fsTema;
	}

	public void setFsTema(String fsTema) {
		this.fsTema = fsTema;
	}

	public String getFsImg() {
		return fsImg;
	}

	public void setFsImg(String fsImg) {
		this.fsImg = fsImg;
	}

	public String getFsUrl() {
		return fsUrl;
	}

	public void setFsUrl(String fsUrl) {
		this.fsUrl = fsUrl;
	}

	public String getFsDct() {
		return fsDct;
	}

	public void setFsDct(String fsDct) {
		this.fsDct = fsDct;
	}

	public int getFsLike() {
		return fsLike;
	}

	public void setFsLike(int fsLike) {
		this.fsLike = fsLike;
	}

	public double getFsLat() {
		return fsLat;
	}

	public void setFsLat(double fsLat) {
		this.fsLat = fsLat;
	}

	public double getFsLong() {
		return fsLong;
	}

	public void setFsLong(double fsLong) {
		this.fsLong = fsLong;
	}

	public String getFsEnd() {
		return fsEnd;
	}

	public void setFsEnd(String fsEnd) {
		this.fsEnd = fsEnd;
	}

	public String getFsStart() {
		return fsStart;
	}

	public void setFsStart(String fsStart) {
		this.fsStart = fsStart;
	}

	@Override
	public String toString() {
		return "Festival [fsNo=" + fsNo + ", fsName=" + fsName + ", fsArea=" + fsArea + ", fsSeason=" + fsSeason
				+ ", fsTema=" + fsTema + ", fsImg=" + fsImg + ", fsUrl=" + fsUrl + ", fsDct=" + fsDct + ", fsLike="
				+ fsLike + ", fsLat=" + fsLat + ", fsLong=" + fsLong + ", fsEnd=" + fsEnd + ", fsStart=" + fsStart
				+ "]";
	}

}
