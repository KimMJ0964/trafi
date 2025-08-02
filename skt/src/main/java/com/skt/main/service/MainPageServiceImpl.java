package com.skt.main.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.skt.festival.model.vo.Festival;
import com.skt.main.model.dao.MainPageDao;
import com.skt.tourist.model.vo.Tourist;

import common.Template;

public class MainPageServiceImpl implements MainPageService {
	private MainPageDao mpDao = new MainPageDao();

    public List<Tourist> getTopTourists() {
    	SqlSession sqlSession = Template.getSqlSession();
        List<Tourist> topTourists = mpDao.selectTopTourists(sqlSession);
        sqlSession.close();
        return topTourists;
    }
    
    public List<Tourist> getTopTouristsTwo() {
    	SqlSession sqlSession = Template.getSqlSession();
        List<Tourist> topTourists = mpDao.selectTopTouristsTwo(sqlSession);
        sqlSession.close();
        return topTourists;
    }
    
    public List<Festival> getFestivalIntro() {
    	SqlSession sqlSession = Template.getSqlSession();
        List<Festival> festivals = mpDao.getFestivalIntro(sqlSession);
        sqlSession.close();
        return festivals;
    }
}
