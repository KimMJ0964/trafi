package com.skt.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.skt.member.service.MemberService;
import com.skt.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberSearchPwdController
 */
public class MemberSearchPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    MemberService memberService = new MemberServiceImpl();
	    String memId = request.getParameter("memId");
	    String email = request.getParameter("email");
	    
	    System.out.println("입력값1: " + memId);
	    System.out.println("입력값2: " + email);
	    
	    String searchPwd = memberService.searchPassword(memId, email);
	    
	    if (searchPwd != null) {
	        request.getSession().setAttribute("searchPwd", searchPwd);
	        request.getRequestDispatcher("views/login/searchPwdResult.jsp").forward(request, response);
	    } else {
	        request.setAttribute("errorMsg", "일치하는 아이디가 없습니다.");
	        request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
