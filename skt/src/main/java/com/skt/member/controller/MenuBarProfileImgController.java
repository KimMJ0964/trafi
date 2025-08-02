package com.skt.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

import com.skt.member.model.vo.Member;
import com.skt.member.model.vo.MemberProfileImg;
import com.skt.member.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MenuBarProfileImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuBarProfileImgController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		String memId = loginUser.getMemId();

		MemberProfileImg mpi = new MemberServiceImpl().getProfileImg(memId);

		response.setContentType("application/json; charset=UTF-8");
	    response.getWriter().write("{\"filePath\":\"" + mpi.getFilePath() + "\", \"changeName\":\"" + mpi.getChangeName() + "\"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
