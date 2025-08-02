package com.skt.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.skt.board.model.vo.BoardComment;
import com.skt.board.service.BoardService;
import com.skt.board.service.BoardServiceImpl;
import com.skt.member.model.vo.Member;

public class BoardInsertReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertReplyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");

		 int parentCommentNo = Integer.parseInt(request.getParameter("parentCommentNo"));
	     String commentContent = request.getParameter("replyContent");
	     Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	        String memId = loginUser.getMemId();
	     int commNo = (int)request.getSession().getAttribute("bno");
	
	     BoardComment boardComment = new BoardComment(parentCommentNo, memId, commentContent, commNo);
	        System.out.println(boardComment);
	        
	        // 서비스 호출하여 댓글 저장
	        BoardService boardService = new BoardServiceImpl();
	        int result = boardService.insertReply(boardComment);

	        if(result > 0) {
	            response.getWriter().print("success");
	            request.getRequestDispatcher("detail.bo?bno=" + commNo).forward(request, response);
	        } else {
	            response.getWriter().print("fail");
	        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
