package com.skt.member.controller;

import java.io.IOException;

import com.skt.member.service.MemberService;
import com.skt.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSearchIdController
 */
public class MemberSearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");
	    
	    String input = request.getParameter("input");
	    
	    System.out.println("입력 값: " + input);
	    
	    MemberService memberService = new MemberServiceImpl();
	    String searchId = memberService.searchByEmailOrPhone(input);
	    
	    if (searchId != null) {
	        request.getSession().setAttribute("searchId", searchId);
	        request.getRequestDispatcher("views/login/searchIdResult.jsp").forward(request, response);
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
