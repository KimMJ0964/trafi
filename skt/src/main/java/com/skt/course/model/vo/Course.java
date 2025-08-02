package com.skt.course.model.vo;

public class Course {
	private int courseNo;
	private String courseName;
	private String courseArea;
	private String courseTema;
	private String courseImg;

	public Course() {
		super();
	}

	public Course(int courseNo, String courseName, String courseArea, String courseTema, String courseImg) {
		super();
		this.courseNo = courseNo;
		this.courseName = courseName;
		this.courseArea = courseArea;
		this.courseTema = courseTema;
		this.courseImg = courseImg;
	}

	public int getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(int courseNo) {
		this.courseNo = courseNo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseArea() {
		return courseArea;
	}

	public void setCourseArea(String courseArea) {
		this.courseArea = courseArea;
	}

	public String getCourseTema() {
		return courseTema;
	}

	public void setCourseTema(String courseTema) {
		this.courseTema = courseTema;
	}

	public String getCourseImg() {
		return courseImg;
	}

	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}

	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", courseName=" + courseName + ", courseArea=" + courseArea
				+ ", courseTema=" + courseTema + ", courseImg =" + courseImg + "]";
	}

}
