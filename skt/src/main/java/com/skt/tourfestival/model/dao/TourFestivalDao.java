package com.skt.tourfestival.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.skt.festival.model.vo.Festival;
import com.skt.member.model.vo.Interested;
import com.skt.tourist.model.vo.Tourist;

import common.PageInfo;

public class TourFestivalDao {
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("tourMapper.selectListCount");
	}

	public ArrayList<Tourist> selectList(SqlSession sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("tourMapper.selectList", null, rowBounds);
	}

	public ArrayList<Festival> selectFList(SqlSession sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("festivalMapper.selectList", null, rowBounds);
	}

	// 좋아요 증가
	public void increaseTourLike(SqlSession sqlSession, int tourNo) {
		sqlSession.update("tourMapper.increaseTourLike", tourNo);
	}

	// 좋아요 감소
	public void decreaseTourLike(SqlSession sqlSession, int tourNo) {
		sqlSession.update("tourMapper.decreaseTourLike", tourNo);
	}

	// 상세페이지
	public Tourist selectTour(SqlSession sqlSession, int tourNo) {
		return sqlSession.selectOne("tourMapper.selectTour", tourNo);
	}

	public Festival selectFestival(SqlSession sqlSession, int fsNo) {
		return sqlSession.selectOne("festivalMapper.selectFestival", fsNo);
	}

	public Interested checkInterestedTourStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.selectOne("memberMapper.checkInterestedTourStatus", map);
	}

	public int insertInterestedTour(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.insert("memberMapper.insertInterestedTour", map);
	}

	public int updateInterestedTourStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("memberMapper.updateInterestedTourStatus", map);
	}

	public Interested checkInterestedFsStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.selectOne("memberMapper.checkInterestedFsStatus", map);
	}

	public int insertInterestedFs(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.insert("memberMapper.insertInterestedFs", map);
	}

	public int updateInterestedFsStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.update("memberMapper.updateInterestedFsStatus", map);
	}
	
	public ArrayList<Tourist> searchTours(SqlSession sqlSession, String keyword) {
        try {
            // selectList 호출 후 결과를 ArrayList로 변환
            return new ArrayList<>(sqlSession.selectList("tourMapper.searchTours", keyword));
        } finally {
            sqlSession.close(); // SqlSession은 사용 후 반드시 닫아야 합니다.
        }
    }

    public ArrayList<Festival> searchFestivals(SqlSession sqlSession, String keyword) {
        try {
            // selectList 호출 후 결과를 ArrayList로 변환
            return new ArrayList<>(sqlSession.selectList("festivalMapper.searchFestivals", keyword));
        } finally {
            sqlSession.close(); // SqlSession은 사용 후 반드시 닫아야 합니다.
        }
    }
}
