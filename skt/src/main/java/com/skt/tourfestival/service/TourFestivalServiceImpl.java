package com.skt.tourfestival.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.vo.BoardLike;
import com.skt.festival.model.vo.Festival;
import com.skt.member.model.vo.Interested;
import com.skt.tourfestival.model.dao.TourFestivalDao;
import com.skt.tourist.model.vo.Tourist;

import common.PageInfo;
import common.Template;

public class TourFestivalServiceImpl implements TourFestivalService{
	private TourFestivalDao tfDao = new TourFestivalDao();
	public TourFestivalServiceImpl() {
		this.tfDao = new TourFestivalDao();
	}

	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = tfDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount; 
	}

	@Override
	public ArrayList<Tourist> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Tourist> Tlist = tfDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return Tlist;
	}

	@Override
	public ArrayList<Festival> selectFList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Festival> Flist = tfDao.selectFList(sqlSession, pi);
		
		sqlSession.close();
		
		return Flist;
	}

	//좋아요 기능
	@Override
	public void likeTour(int tourNo) {
		SqlSession sqlSession = Template.getSqlSession();
		try {
			tfDao.increaseTourLike(sqlSession, tourNo);
			sqlSession.commit();
		}catch (Exception e) {
	        sqlSession.rollback(); // 오류 발생 시 롤백
	        e.printStackTrace(); // 예외 로그
	    } finally {
	        sqlSession.close();
	    }
	}

	@Override
	public void unlikeTour(int tourNo) {
		SqlSession sqlSession = Template.getSqlSession();
		try {
			tfDao.decreaseTourLike(sqlSession, tourNo);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	@Override
	public Tourist increaseCount(int tourNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Tourist result = tfDao.selectTour(sqlSession,tourNo);
		
		Tourist t = null;
		if(result != null) {
			sqlSession.commit();
			t = tfDao.selectTour(sqlSession, tourNo);
		}else {
			sqlSession.rollback();
		}
		return t;
	}

	@Override
	public Festival fincreaseCount(int fsNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Festival result = tfDao.selectFestival(sqlSession,fsNo);
		
		Festival f = null;
		if(result != null) {
			sqlSession.commit();
			f = tfDao.selectFestival(sqlSession, fsNo);
		}else {
			sqlSession.rollback();
		}
		return f;
	}

	@Override
	public int tourInterested(HashMap<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int likeCount = 0;
		
		Interested tempStatus = tfDao.checkInterestedTourStatus(sqlSession, map);  // Integer 타입으로 임시 변수 선언

		int currentStatus = 0;  // 기본값 0으로 초기화
		if (tempStatus != null) {
		    currentStatus = 1;  // tempStatus가 null이 아닐 경우에만 할당
		}
		
		System.out.println(currentStatus);
        if (currentStatus == 0) {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 행이 없으면 처음 좋아요하는 경우이므로 행을 생성
            tfDao.insertInterestedTour(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 1; // 좋아요 추가
        } else {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 좋아요 상태 -> 좋아요 취소
            tfDao.updateInterestedTourStatus(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 0; // 좋아요 취소
        }
	}
	
	public int fsInterested(HashMap<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int likeCount = 0;
		
		Interested tempStatus = tfDao.checkInterestedFsStatus(sqlSession, map);  // Integer 타입으로 임시 변수 선언

		int currentStatus = 0;  // 기본값 0으로 초기화
		if (tempStatus != null) {
		    currentStatus = 1;  // tempStatus가 null이 아닐 경우에만 할당
		}
		
		System.out.println(currentStatus);
        if (currentStatus == 0) {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 행이 없으면 처음 좋아요하는 경우이므로 행을 생성
            tfDao.insertInterestedFs(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 1; // 좋아요 추가
        } else {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 좋아요 상태 -> 좋아요 취소
            tfDao.updateInterestedFsStatus(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 0; // 좋아요 취소
        }
	}
	
	public ArrayList<Tourist> searchTours(String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		return tfDao.searchTours(sqlSession, keyword);
	}

	public ArrayList<Festival> searchFestivals(String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		return tfDao.searchFestivals(sqlSession, keyword);
	}

}
