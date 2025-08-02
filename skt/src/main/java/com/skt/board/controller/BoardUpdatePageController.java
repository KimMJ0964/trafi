package com.skt.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardFile;
import com.skt.board.service.BoardService;
import com.skt.board.service.BoardServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardUpdatePageController
 */
public class BoardUpdatePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardUpdatePageController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardNo = (int) request.getSession().getAttribute("bno");

		Board b = new Board();
		ArrayList<BoardFile> bf = new ArrayList<>();

		BoardService boardService = new BoardServiceImpl();
		
		b = boardService.boardUpdatePage(boardNo);
		bf = boardService.boardUpdatePageFile(boardNo);
		
		if (b != null) {
			request.setAttribute("boardContentList", b);
			request.setAttribute("boardContentListFile", bf);
			request.getRequestDispatcher("views/board/updateBoard.jsp?bno=" + boardNo).forward(request, response);
		} else {
			request.setAttribute("errorMsg", "상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
