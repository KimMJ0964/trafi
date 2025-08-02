package com.skt.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.skt.board.model.vo.Board;
import com.skt.board.service.BoardService;
import com.skt.board.service.BoardServiceImpl;
import common.PageInfo;
import common.Template;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition"); // writer | title | content
		String keyword = request.getParameter("keyword"); //사용자가 입력한 키워드값
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		BoardService bService = new BoardServiceImpl();
		
		int cuurentPage = Integer.parseInt(request.getParameter("cpage"));
		int searchCount = bService.selectSearchCount(map);
		
		PageInfo pi = Template.getPageInfo(searchCount, cuurentPage, 10, 5);
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("views/board/boardMainPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
