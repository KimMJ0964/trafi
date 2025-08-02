package com.skt.tourist.model.vo;

public class Tourist {
	private int tourNo;
	private String tourName;
	private String tourArea;
	private String tourTema;
	private String tourSeason;
	private String tourImg;
	private String tourThumbnail;
	private int tourLike;
	private double tourLat;
	private double tourLong;
	
	public Tourist() {
		super();
	}
	
	public Tourist(int tourNo, String tourName, String tourArea, String tourTema, String tourSeason, String tourImg,
			String tourThumbnail, int tourLike, double tourLat, double tourLong) {
		super();
		this.tourNo = tourNo;
		this.tourName = tourName;
		this.tourArea = tourArea;
		this.tourTema = tourTema;
		this.tourSeason = tourSeason;
		this.tourImg = tourImg;
		this.tourThumbnail = tourThumbnail;
		this.tourLike = tourLike;
		this.tourLat = tourLat;
		this.tourLong = tourLong;
	}
	public int getTourNo() {
		return tourNo;
	}
	public void setTourNo(int tourNo) {
		this.tourNo = tourNo;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getTourArea() {
		return tourArea;
	}
	public void setTourArea(String tourArea) {
		this.tourArea = tourArea;
	}
	public String getTourTema() {
		return tourTema;
	}
	public void setTourTema(String tourTema) {
		this.tourTema = tourTema;
	}
	public String getTourSeason() {
		return tourSeason;
	}
	public void setTourSeason(String tourSeason) {
		this.tourSeason = tourSeason;
	}
	public String getTourImg() {
		return tourImg;
	}
	public void setTourImg(String tourImg) {
		this.tourImg = tourImg;
	}
	public String getTourThumbnail() {
		return tourThumbnail;
	}
	public void setTourThumbnail(String tourThumbnail) {
		this.tourThumbnail = tourThumbnail;
	}
	public int getTourLike() {
		return tourLike;
	}
	public void setTourLike(int tourLike) {
		this.tourLike = tourLike;
	}
	public double getTourLat() {
		return tourLat;
	}
	public void setTourLat(double tourlat) {
		this.tourLat = tourlat;
	}
	public double getTourLong() {
		return tourLong;
	}
	public void setTourLong(double tourLong) {
		this.tourLong = tourLong;
	}
	@Override
	public String toString() {
		return "Tourist [tourNo=" + tourNo + ", tourName=" + tourName + ", tourArea=" + tourArea + ", tourTema="
				+ tourTema + ", tourSeason=" + tourSeason + ", tourImg=" + tourImg + ", tourThumbnail=" + tourThumbnail
				+ ", tourLike=" + tourLike + ", tourlat=" + tourLat + ", tourLong=" + tourLong + "]";
	}
}
