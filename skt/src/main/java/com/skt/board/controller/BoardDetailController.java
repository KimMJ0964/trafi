package com.skt.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.board.model.vo.BoardFile;
import com.skt.board.service.BoardService;
import com.skt.board.service.BoardServiceImpl;
import com.skt.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		HttpSession session = request.getSession();
        session.setAttribute("bno", boardNo);
		BoardService bService = new BoardServiceImpl();
		String contextPath = request.getContextPath();
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		String memId = (loginUser != null) ? loginUser.getMemId() : "";
		//조회수 증가 + 상세조회
        
		Board b = bService.increaseCount(boardNo);
		List<BoardFile> bfList = bService.filePath(boardNo);
		List<String> downloadLinks = new ArrayList<>();
		List<String> imageLinks = new ArrayList<>();
		List<String> originalFileNames = new ArrayList<>();
		int boardLike = bService.likeCount(boardNo);
		
		System.out.println(boardLike);
		
		if (bfList != null && !bfList.isEmpty()) {
		    for (BoardFile bf : bfList) {
		        String fileExtension = bf.getChangeName().substring(bf.getChangeName().lastIndexOf(".") + 1).toLowerCase();
		        String fileLink = contextPath + "/" + bf.getFilePath() + bf.getChangeName();
		        
		        // 이미지 파일이면 이미지 링크 리스트에 추가
		        if (fileExtension.equals("png") || fileExtension.equals("jpg") || fileExtension.equals("jpeg")) {
		            imageLinks.add(fileLink);
		        } else {  // 그 외 파일은 다운로드 링크 리스트에 추가
		            downloadLinks.add(fileLink);
		            originalFileNames.add(bf.getOriginName());
		        }
		    }
		    request.setAttribute("downloadLinks", downloadLinks);  // 다운로드 링크들
		    request.setAttribute("imageLinks", imageLinks);  // 이미지 링크들
		    request.setAttribute("originalFileNames", originalFileNames);
		}
		
		ArrayList<BoardComment> commentList = bService.commentList(boardNo);
		ArrayList<BoardComment> replyList = bService.replyList(boardNo);

	        // 댓글 목록을 request에 담아서 JSP로 전달
	    request.setAttribute("commentList", commentList);
	    request.setAttribute("replyList", replyList);
	    request.setAttribute("boardLike", boardLike);
	    request.setAttribute("testLoginSession", memId);
	    
	    
		if(b != null) {
			request.setAttribute("b", b);
			request.getRequestDispatcher("views/board/boardView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "상세조회 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
