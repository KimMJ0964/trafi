package com.skt.course.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.skt.course.model.vo.Course;
import com.skt.course.service.CourseService;
import com.skt.course.service.CourseServiceImpl;

import common.PageInfo;
import common.Template;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseSearchController
 */
public class CourseSearchController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   private CourseService CourseService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSearchController() {
        super();
        this.CourseService = new CourseServiceImpl(); // 구현체 사용
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String[] selectedAreas = request.getParameterValues("area");
        String[] selectedThemes = request.getParameterValues("theme");
        
     // HashMap에 필터 조건 추가
        HashMap<String, Object> filterMap = new HashMap<>();
        filterMap.put("areas", selectedAreas);
        filterMap.put("themes", selectedThemes);
        
        
        // 서비스 레이어에 필터링 조건을 전달하여 필터링된 코스 리스트를 가져옴
        List<Course> courses = CourseService.getFilteredCourses(filterMap);
        
        // JSP로 전달할 데이터 모델에 추가
        request.setAttribute("list", courses);

        // 결과 페이지로 이동
        request.getRequestDispatcher("/views/course/sub_course_main.jsp").forward(request, response);
    
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}
