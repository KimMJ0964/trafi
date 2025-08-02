package com.skt.tourfestival.controller;

import java.io.IOException;

import com.skt.tourfestival.service.TourFestivalService;
import com.skt.tourfestival.service.TourFestivalServiceImpl;
import com.skt.tourist.model.vo.Tourist;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TourFestivalDetailController
 */
public class TourFestivalDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourFestivalDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TourFestivalService tfService = new TourFestivalServiceImpl();
		
		//관광지
		int tourNo = Integer.parseInt(request.getParameter("tno"));
		
		Tourist t = tfService.increaseCount(tourNo);
		
		if(t != null) {
			request.setAttribute("t", t);
			request.getRequestDispatcher("views/sub2_TF/TourFestivalDetail.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMsg", "상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
