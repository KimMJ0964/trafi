package com.skt.board.model.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.board.model.vo.BoardFile;
import com.skt.board.model.vo.BoardLike;

import common.PageInfo;

public class BoardDao {
private Properties prop = new Properties();
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
		// 업데이트되면 1출력
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Board> selectMyPageBoardList(SqlSession sqlSession, String loginId) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectMyPageBoardList", loginId);
	}
	
	public int insertBoard(SqlSession sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoard", b);
	}
	
	public int insertBoardFile(SqlSession sqlSession, BoardFile bf) {
		return sqlSession.insert("boardMapper.insertBoardFile", bf);
	}
	
	public int insertComment(SqlSession sqlSession, BoardComment boardComment) {
		return sqlSession.insert("boardMapper.insertComment", boardComment);
	}
	
	public int deleteBoard(SqlSession sqlSession, int boardNo ) {
		return sqlSession.update("boardMapper.deleteBoard", boardNo); 
	}
	
	public int updateBoard(SqlSession sqlSession, Board b) {
		System.out.println("updateBoard" + b);
		return sqlSession.update("boardMapper.updateBoard", b);
	}
	
	public int updateBoardFile(SqlSession sqlSession, BoardFile bf) {
		System.out.println("updateBoardFile" + bf);
		return sqlSession.update("boardMapper.updateBoardFile", bf);
	}
	
	public ArrayList<BoardComment> commentList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.commentList", boardNo);
	}
	
	public ArrayList<BoardComment> replyList(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.replyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}
	
	public List<BoardFile> filePath(SqlSession sqlSession, int boardNo) {
	    return sqlSession.selectList("boardMapper.filePath", boardNo);
	}
	
	public BoardLike checkLikeStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println("checkLikeStatus : " + map);
		return sqlSession.selectOne("boardMapper.checkLikeStatus", map);
	}

	public int insertLike(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println("insertLike : " + map);
		return sqlSession.insert("boardMapper.insertLike", map);
	}

	public int updateLikeStatus(SqlSession sqlSession, HashMap<String, Object> map) {
		System.out.println("updateLikeStatus : " + map);
		return sqlSession.update("boardMapper.updateLike", map);
	}
	
	public int insertReply(SqlSession sqlSession, BoardComment boardReply) {
		return sqlSession.insert("boardMapper.insertReply", boardReply);
	}
	
	public int deleteComment(SqlSession sqlSession, BoardComment boardComment) {
		return sqlSession.update("boardMapper.deleteComment", boardComment);
	}
	
	public int likeCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.likeCount", boardNo);
	}
	
	public Board boardUpdatePage(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.boardUpdatePage", boardNo);
	}
	
	public ArrayList<BoardFile> boardUpdatePageFile(SqlSession sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.boardUpdatePageFile", boardNo);
	}
	
	public int deleteSelectedFiles(SqlSession sqlSession, int fileNo) {
		System.out.println("게시글 수정 파일 삭제 파일 오리진 이름 : " + fileNo);
		return sqlSession.delete("boardMapper.deleteSelectedFiles", fileNo);
	}
	// ---------------------- 마이바티스 --------------------------------------------
}
