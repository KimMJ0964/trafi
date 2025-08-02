package com.skt.tourfestival.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.skt.festival.model.vo.Festival;
import com.skt.tourfestival.service.TourFestivalServiceImpl;
import com.skt.tourist.model.vo.Tourist;

public class TourFestivalSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TourFestivalSearchController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
	    String keyword = request.getParameter("keyword");

	    TourFestivalServiceImpl tfService = new TourFestivalServiceImpl();

	    ArrayList<Tourist> Tlist = tfService.searchTours(keyword);
	    ArrayList<Festival> Flist = tfService.searchFestivals(keyword);
	    System.out.println(Tlist);

	    if ("tour".equals(condition)) {
	        Tlist = tfService.searchTours(keyword); // 관광지 검색
	    } else if ("festival".equals(condition)) {
	        Flist = tfService.searchFestivals(keyword); // 축제 검색
	    }

	    request.setAttribute("Tlist", Tlist);
	    request.setAttribute("Flist", Flist);
	    request.setAttribute("condition", condition);
	    request.setAttribute("keyword", keyword);

	    // 결과를 보여줄 JSP 페이지로 포워딩
	    request.getRequestDispatcher("views/sub2_TF/TourFestivalList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
