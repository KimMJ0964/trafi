package com.skt.course.model.vo;

public class SubCourse {
	private int subCourseNo;
	private int courseNo;
	private int tourNo;
	private int fsNo;
	private int turn;
	private String tourName;  // TOURIST 테이블의 TOUR_NAME
    private String fsName;    // FESTIVAL 테이블의 FS_NAME
    private String fsImg;
    private String tourImg;
    private double tourLat;
    private double tourLong;
    private double fsLat;
    private double fsLong;
	
	public SubCourse() {
		super();
	}

	public SubCourse(int subCourseNo, int courseNo, int tourNo, int fsNo, int turn, String tourName, String fsName,
			String fsImg, String tourImg, double tourLat, double tourLong, double fsLat, double fsLong) {
		super();
		this.subCourseNo = subCourseNo;
		this.courseNo = courseNo;
		this.tourNo = tourNo;
		this.fsNo = fsNo;
		this.turn = turn;
		this.tourName = tourName;
		this.fsName = fsName;
		this.fsImg = fsImg;
		this.tourImg = tourImg;
		this.tourLat = tourLat;
		this.tourLong = tourLong;
		this.fsLat = fsLat;
		this.fsLong = fsLong;
	}

	public int getSubCourseNo() {
		return subCourseNo;
	}

	public void setSubCourseNo(int subCourseNo) {
		this.subCourseNo = subCourseNo;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public int getTourNo() {
		return tourNo;
	}

	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}

	public int getFsNo() {
		return fsNo;
	}

	public void setFsNo(int fsNo) {
		this.fsNo = fsNo;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getFsName() {
		return fsName;
	}

	public void setFsName(String fsName) {
		this.fsName = fsName;
	}

	public String getFsImg() {
		return fsImg;
	}

	public void setFsImg(String fsImg) {
		this.fsImg = fsImg;
	}

	public String getTourImg() {
		return tourImg;
	}

	public void setTourImg(String tourImg) {
		this.tourImg = tourImg;
	}

	public double getTourLat() {
		return tourLat;
	}

	public void setTourLat(double tourLat) {
		this.tourLat = tourLat;
	}

	public double getTourLong() {
		return tourLong;
	}

	public void setTourLong(double tourLong) {
		this.tourLong = tourLong;
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

	@Override
	public String toString() {
		return "SubCourse [subCourseNo=" + subCourseNo + ", courseNo=" + courseNo + ", tourNo=" + tourNo + ", fsNo="
				+ fsNo + ", turn=" + turn + ", tourName=" + tourName + ", fsName=" + fsName + ", fsImg=" + fsImg
				+ ", tourImg=" + tourImg + ", tourLat=" + tourLat + ", tourLong=" + tourLong + ", fsLat=" + fsLat
				+ ", fsLong=" + fsLong + "]";
	}

	
	
}
