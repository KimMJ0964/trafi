package com.skt.sub.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.skt.festival.model.vo.Festival;
import com.skt.member.model.vo.Member;
import com.skt.member.model.vo.MemberProfileImg;
import com.skt.member.service.MemberServiceImpl;
import com.skt.tourist.model.vo.Tourist;

public class createMyCourseToPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public createMyCourseToPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Member loginUser = (Member) request.getSession().getAttribute("loginUser");
			String loginValue = null;
			if (loginUser == null) {
			    // 로그인 세션이 없을 경우 에러 처리
				request.getRequestDispatcher("views/sub/sub_mycourse2.jsp").forward(request, response);
			    return; // 이후 코드를 실행하지 않도록 return
			} else {
			    loginValue = loginUser.getMemId();
			    System.out.println("Session login value: " + loginValue);
			}
			
			ArrayList<Festival> interested = new MemberServiceImpl().myPageInterested(loginValue);
		    ArrayList<Tourist> interestedTwo = new MemberServiceImpl().myPageInterestedTwo(loginValue);
		    
		    if (interested != null && !interested.isEmpty()) {
		        request.setAttribute("interestedList", interested);
		    }
		    
		    if (interestedTwo != null && !interestedTwo.isEmpty()) {
		        request.setAttribute("interestedListTwo", interestedTwo);
		    }
		    
			request.getRequestDispatcher("views/sub/sub_mycourse2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
