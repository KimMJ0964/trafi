package com.skt.course.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.dao.BoardDao;
import com.skt.course.model.dao.CourseDao;
import com.skt.course.model.vo.Course;
import com.skt.course.model.vo.SubCourse;
import com.skt.member.model.vo.Interested;

import common.PageInfo;
import common.Template;

public class CourseServiceImpl implements CourseService {

	private CourseDao cDao = new CourseDao();

	@Override
	public ArrayList<SubCourse> selectSubCourse(int courseNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<SubCourse> result = cDao.selectSubCourse(sqlSession, courseNo);

		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Course> selectCourseDetail(int courseNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Course> result = cDao.selectCourseDetail(sqlSession, courseNo);

		sqlSession.close();
		return result;
	}

	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = cDao.selectListCount(sqlSession);

		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Course> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Course> list = cDao.selectList(sqlSession, pi);
		sqlSession.close();

		return list;
	}

	@Override
	public List<Course> getFilteredCourses(HashMap<String, Object> filterMap) {
		SqlSession sqlSession = Template.getSqlSession();
		return cDao.findCoursesByFilters(sqlSession, filterMap);
	}

	@Override
	public int tourInterested(HashMap<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int likeCount = 0;
		
		Interested tempStatus = cDao.checkInterestedCourseStatus(sqlSession, map);  // Integer 타입으로 임시 변수 선언

		int currentStatus = 0;  // 기본값 0으로 초기화
		if (tempStatus != null) {
		    currentStatus = 1;  // tempStatus가 null이 아닐 경우에만 할당
		}
		
		System.out.println(currentStatus);
        if (currentStatus == 0) {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 행이 없으면 처음 좋아요하는 경우이므로 행을 생성
            cDao.insertInterestedCourse(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 1; // 좋아요 추가
        } else {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 좋아요 상태 -> 좋아요 취소
            cDao.updateInterestedCourseStatus(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 0; // 좋아요 취소
        }
	}

}
