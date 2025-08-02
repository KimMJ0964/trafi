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

public class MainPageTouristRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainPageTouristRankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MainPageService touristService = new MainPageServiceImpl();
        List<Tourist> topTourists = touristService.getTopTourists();
        System.out.println("테스트");
        System.out.println(topTourists);
        // JSON 형태로 응답을 보내기 위한 설정
        response.setContentType("application/json; charset=UTF-8");
        new Gson().toJson(topTourists, response.getWriter());
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String testValue = request.getParameter("test");

	        // 받은 값을 콘솔에 출력 (서버 로그에서 확인 가능)
	        System.out.println("Received test value: " + testValue);

	        // 응답을 클라이언트로 전송 (필요시)
	        response.getWriter().write("Received: " + testValue);
	}

}
