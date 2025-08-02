package com.skt.course.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.skt.course.model.vo.Course;
import com.skt.course.model.vo.SubCourse;

import common.PageInfo;

public interface CourseService {
	ArrayList<SubCourse> selectSubCourse(int courseNo);
	
	ArrayList<Course> selectCourseDetail(int courseNo);
	
	int selectListCount();
	
    ArrayList<Course> selectList(PageInfo pi);
    
    List<Course> getFilteredCourses(HashMap<String, Object> filterMap);
    
    int tourInterested(HashMap<String, Object> map);
    
}
