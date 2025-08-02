package com.skt.tourfestival.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.skt.festival.model.vo.Festival;
import com.skt.tourfestival.service.TourFestivalService;
import com.skt.tourfestival.service.TourFestivalServiceImpl;
import com.skt.tourist.model.vo.Tourist;

import common.PageInfo;
import common.Template;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TourFestivalListController
 */
public class TourFestivalListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // TourFestivalService 객체를 멤버 변수로 선언
    private TourFestivalService tourFestivalService;

    // 생성자에서 Service 객체를 초기화
    public TourFestivalListController() {
        super();
        this.tourFestivalService = new TourFestivalServiceImpl(); // 구현체 사용
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TourFestivalService tfService = new TourFestivalServiceImpl();
        
        //페이징 처리
        int currentPage = Integer.parseInt(request.getParameter("cpage"));
        int listCount = tfService.selectListCount(); //총 게시글 수
        
        PageInfo pi = Template.getPageInfo(listCount, currentPage, 3, 61);
        
        //관광지 리스트
        ArrayList<Tourist> Tlist = tfService.selectList(pi);
        System.out.println(Tlist);
        request.setAttribute("Tlist", Tlist);
        request.setAttribute("pi", pi);
        
        //축제 리스트
        ArrayList<Festival> Flist = tfService.selectFList(pi);
        System.out.println(Flist);
        request.setAttribute("Flist", Flist);
        request.setAttribute("pi", pi);
        
        request.getRequestDispatcher("views/sub2_TF/TourFestivalList.jsp").forward(request, response);
        
     
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
    	TourFestivalService tfService = new TourFestivalServiceImpl();
    	
    	//AJAX요청에서 action, tourNo 파라미터 가져오기
    	String action = request.getParameter("action");
    	int tourNo = Integer.parseInt(request.getParameter("tourNo"));
    	
    	//좋아요 기능
    	if("like".equals(action)) {
    		tfService.likeTour(tourNo); // TOUR_LIKE 증가
    	} else if("unlike".equals(action)){
    		tfService.unlikeTour(tourNo); //TOUR_LIKE 감소
    	}
    	
    	//JSON 응답 전송
    	response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
    	response.getWriter().write("{ \"result\": \"success\" }");
    }
}