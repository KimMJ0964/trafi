package com.skt.course.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.skt.course.model.vo.Course;
import com.skt.course.model.vo.SubCourse;
import com.skt.member.model.vo.Interested;

import common.PageInfo;

public class CourseDao {
	public ArrayList<SubCourse> selectSubCourse(SqlSession sqlSession, int courseNo) {
		return (ArrayList) sqlSession.selectList("courseMapper.selectSubCourse", courseNo);
	}

	public ArrayList<Course> selectCourseDetail(SqlSession sqlSession, int courseNo) {
		return (ArrayList) sqlSession.selectList("courseMapper.selectCourseDetail", courseNo);
	}

	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("courseMapper.selectListCount");
	}

	public ArrayList<Course> selectList(SqlSession sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("courseMapper.selectList", null, rowBounds);
	}

	public List<Course> findCoursesByFilters(SqlSession sqlSession, HashMap<String, Object> filterMap) {
		return sqlSession.selectList("courseMapper.findCoursesByFilters", filterMap);

	}
	
	public Interested checkInterestedCourseStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.selectOne("memberMapper.checkInterestedCsStatus", map);
	}
    
	public int insertInterestedCourse(SqlSession sqlSession, HashMap<String, Object> map) {
		return sqlSession.insert("memberMapper.insertInterestedCs", map);
	}
	
    public int updateInterestedCourseStatus(SqlSession sqlSession, HashMap<String, Object> map) {
    	return sqlSession.update("memberMapper.updateInterestedCs", map);
    }
}
