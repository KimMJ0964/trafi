package com.skt.main.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.skt.main.service.MainPageService;
import com.skt.main.service.MainPageServiceImpl;
import com.skt.tourist.model.vo.Tourist;

/**
 * Servlet implementation class MainPageTouristRankTwoServlet
 */
public class MainPageTouristRankTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageTouristRankTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MainPageService touristService = new MainPageServiceImpl();
        List<Tourist> topTourists = touristService.getTopTouristsTwo();
        System.out.println("테스트");
        System.out.println(topTourists);
        // JSON 형태로 응답을 보내기 위한 설정
        response.setContentType("application/json; charset=UTF-8");
        new Gson().toJson(topTourists, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
