package com.skt.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import com.skt.board.service.BoardService;
import com.skt.board.service.BoardServiceImpl;
import com.skt.member.model.vo.Member;

/**
 * Servlet implementation class BoardLikeController
 */
public class BoardLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardLikeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
        String memId = loginUser.getMemId();
		int commNo = (int) request.getSession().getAttribute("bno");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("login", memId);
		map.put("bno", commNo);
		
		System.out.println(map);
		BoardService boardService = new BoardServiceImpl();
		int result = boardService.boardLike(map);

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(result);
		request.getRequestDispatcher("detail.bo?bno=" + commNo).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
