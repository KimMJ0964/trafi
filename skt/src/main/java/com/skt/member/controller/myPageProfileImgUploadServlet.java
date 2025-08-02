package com.skt.member.controller;

import jakarta.servlet.ServletException;
import org.apache.commons.io.FilenameUtils;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.board.model.vo.BoardFile;
import com.skt.board.service.BoardServiceImpl;
import com.skt.member.model.vo.Member;
import com.skt.member.model.vo.MemberProfileImg;
import com.skt.member.service.MemberService;
import com.skt.member.service.MemberServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 15 // 15MB
)
public class myPageProfileImgUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public myPageProfileImgUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    Part filePart = request.getPart("profileImage");

	    if (filePart != null && filePart.getSize() > 0) {
	        // 고유한 파일명 생성
	        long timestamp = System.currentTimeMillis();
	        String extension = filePart.getSubmittedFileName().substring(filePart.getSubmittedFileName().lastIndexOf("."));
	        String fileName = "memberProfile_" + timestamp + extension;
	        String uploadPath = getServletContext().getRealPath("views/myPage/") + "img";

	        // 디렉토리 생성
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }

	        // 파일 저장
	        filePart.write(uploadPath + File.separator + fileName);
	        System.out.println("파일 업로드 경로: " + uploadPath + File.separator + fileName);

	        // DB에 파일 정보 저장 (서비스 호출)
	        String filePath = "views/myPage/img/" + fileName;  // 상대 경로
	        HttpSession session = request.getSession();
	        Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	        String memId = loginUser.getMemId();
	        
	        MemberService memberService = new MemberServiceImpl();
	        memberService.saveProfileImage(memId, fileName, filePath);

	        response.getWriter().println("파일 업로드 성공: " + fileName);
	        String contextPath = request.getContextPath();
	        response.sendRedirect(contextPath + "/myPageTest.me");
	    } else {
	        response.getWriter().println("파일이 선택되지 않았습니다.");
	    }
	}

}
