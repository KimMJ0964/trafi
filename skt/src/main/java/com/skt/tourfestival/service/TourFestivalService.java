package com.skt.tourfestival.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.skt.festival.model.vo.Festival;
import com.skt.tourist.model.vo.Tourist;

import common.PageInfo;

public interface TourFestivalService {
	// 리스트 조회
	int selectListCount();
	ArrayList<Tourist> selectList(PageInfo pi);
	ArrayList<Festival> selectFList(PageInfo pi);
	
	//좋아요 기능
	void likeTour(int tourNo);
	void unlikeTour(int tourNo);
	
	//게시글 상세조회
	Tourist increaseCount(int tourNo);
	Festival fincreaseCount(int fsNo);
	
	int tourInterested(HashMap<String, Object> map);
	int fsInterested(HashMap<String, Object> map);
	
}
