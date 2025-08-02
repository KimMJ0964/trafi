package com.skt.course.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.skt.course.service.CourseService;
import com.skt.course.service.CourseServiceImpl;
import com.skt.member.model.vo.Member;
import com.skt.tourfestival.service.TourFestivalService;
import com.skt.tourfestival.service.TourFestivalServiceImpl;

public class CourseInterestedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseInterestedController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseNo = request.getParameter("courseNo");
		
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		String loginValue = null;
		if (loginUser == null) {
		    // 로그인 세션이 없을 경우 에러 처리
		    request.setAttribute("errorMsg", "로그인이 필요합니다.");
		    request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		    return; // 이후 코드를 실행하지 않도록 return
		} else {
		    loginValue = loginUser.getMemId();
		    System.out.println("Session login value: " + loginValue);
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("login", loginValue);
		map.put("courseNo", courseNo);
		
		System.out.println(map);
		CourseService cs = new CourseServiceImpl();
		int result = cs.tourInterested(map);

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		request.getRequestDispatcher("courseDetail.cs?cno=" + courseNo).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
