package com.skt.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.skt.board.model.vo.BoardComment;
import com.skt.board.service.BoardService;
import com.skt.board.service.BoardServiceImpl;
import com.skt.member.model.vo.Member;

public class BoardDeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        String memId = loginUser.getMemId();
        
        String commentMasterNo = request.getParameter("commentMasterNo");
        int commentNo = Integer.parseInt(request.getParameter("commentNo"));
        
		HttpSession session = request.getSession();
		int boardNo = (int)session.getAttribute("bno");
		
        System.out.println("유저 아이디 : " + memId + " 댓글 주인 아이디 : " + commentMasterNo + " 댓글 번호 : " + commentNo + " 게시글 번호 : " + boardNo );
        if(memId.equals(commentMasterNo)) {
        	BoardService bService = new BoardServiceImpl();
        	BoardComment boardComment = new BoardComment(memId, commentNo);
        	
        	int result = bService.deleteComment(boardComment);
        	
        	if(result > 0) {
        		request.getRequestDispatcher("detail.bo?bno=" + boardNo).forward(request, response);
        	} else {
        		request.setAttribute("errorMsg", "게시글 조회 실패");
        		request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
        	}
        } else {
        	request.setAttribute("errorMsg", "자신의 댓글만 삭제할 수 있습니다.");
    		request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
