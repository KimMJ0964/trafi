package com.skt.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.course.model.vo.Course;
import com.skt.festival.model.vo.Festival;
import com.skt.member.model.vo.Member;
import com.skt.member.model.vo.MemberProfileImg;
import com.skt.member.service.MemberService;
import com.skt.member.service.MemberServiceImpl;
import com.skt.tourist.model.vo.Tourist;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class myPageLoginSessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myPageLoginSessionTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
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
	    
		MemberService memberService = new MemberServiceImpl();
		
	    Member member = memberService.myPageInfo(loginValue);
	    ArrayList<Board> board = memberService.myPageBoard(loginValue);
	    ArrayList<BoardComment> boardComment = memberService.myPageComment(loginValue);
	    ArrayList<Festival> interested = memberService.myPageInterested(loginValue);
	    ArrayList<Tourist> interestedTwo = memberService.myPageInterestedTwo(loginValue);
	    ArrayList<Course> interestedThree = memberService.myPageInterestedThree(loginValue);
	    MemberProfileImg profileImg = memberService.selectProfileImage(loginValue);

	    System.out.println("내 코스 : " + interestedThree);
	    request.setAttribute("member", member);
	    System.out.println(member);
	    
	    // board 값이 null이 아니고 빈 리스트가 아닐 경우에만 설정
	    if (board != null && !board.isEmpty()) {
	        request.setAttribute("communityList", board);
	    }

	    // boardComment 값이 null이 아니고 빈 리스트가 아닐 경우에만 설정
	    if (boardComment != null && !boardComment.isEmpty()) {
	        request.setAttribute("userCommentsList", boardComment);
	    }
	    
	    if (interested != null && !interested.isEmpty()) {
	        request.setAttribute("interestedList", interested);
	    }
	    
	    if (interestedTwo != null && !interestedTwo.isEmpty()) {
	        request.setAttribute("interestedListTwo", interestedTwo);
	    }
	    
	    if (interestedThree != null && !interestedThree.isEmpty()) {
	        request.setAttribute("interestedListThree", interestedThree);
	    }
	    
	    if (profileImg != null) {
	    	request.setAttribute("profileImg", profileImg);
	    }
	    
		request.getRequestDispatcher("views/myPage/myPage.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
