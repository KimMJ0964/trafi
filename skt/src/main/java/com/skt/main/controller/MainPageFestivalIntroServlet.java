package com.skt.main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.skt.festival.model.vo.Festival;
import com.skt.main.service.MainPageService;
import com.skt.main.service.MainPageServiceImpl;
import com.skt.tourist.model.vo.Tourist;

/**
 * Servlet implementation class MainPageFestivalIntroServlet
 */
public class MainPageFestivalIntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainPageFestivalIntroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MainPageService mainpageService = new MainPageServiceImpl();
        List<Festival> festivalList = mainpageService.getFestivalIntro();

		// JSON 형식으로 변환
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(festivalList);

		// 응답 설정
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(jsonResponse); // JSON 응답 전송
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
