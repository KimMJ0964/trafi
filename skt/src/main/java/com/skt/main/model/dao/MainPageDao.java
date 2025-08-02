package com.skt.main.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.skt.festival.model.vo.Festival;
import com.skt.tourist.model.vo.Tourist;

public class MainPageDao {
	public List<Tourist> selectTopTourists(SqlSession sqlSession) {
        return sqlSession.selectList("mainPageMapper.selectTopTourists");
    }
	
	public List<Tourist> selectTopTouristsTwo(SqlSession sqlSession) {
        return sqlSession.selectList("mainPageMapper.selectTopTouristsTwo");
    }
	
	public List<Festival> getFestivalIntro(SqlSession sqlSession) {
		return sqlSession.selectList("mainPageMapper.fesitivalIntro");
	}
}
