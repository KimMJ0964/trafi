package com.skt.course.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.skt.course.model.vo.Course;
import com.skt.course.model.vo.SubCourse;
import com.skt.course.service.CourseServiceImpl;
import com.skt.course.service.CourseService;

public class courseDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public courseDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courseNo = Integer.parseInt(request.getParameter("cno"));
		
		CourseService courseService = new CourseServiceImpl();
		
		ArrayList<Course> courseDetailGet = courseService.selectCourseDetail(courseNo);
		ArrayList<SubCourse> courseList = courseService.selectSubCourse(courseNo);
		
		System.out.println(courseList);
		request.setAttribute("courseDetailGet", courseDetailGet);
		request.setAttribute("courseList", courseList);
		
		if(courseList != null) {
			request.getRequestDispatcher("views/course/sub_course_detail.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
