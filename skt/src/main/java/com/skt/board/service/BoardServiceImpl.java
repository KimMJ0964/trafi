package com.skt.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.dao.BoardDao;
import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.board.model.vo.BoardFile;
import com.skt.board.model.vo.BoardLike;

import common.PageInfo;
import common.Template;
import jakarta.servlet.http.HttpServletRequest;


public class BoardServiceImpl implements BoardService{
	private BoardDao bDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = bDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount;
	}
	
	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public Board increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = bDao.increaseCount(sqlSession, boardNo);
		
		Board b = null;
		if (result > 0) {
			sqlSession.commit();
			b = bDao.selectBoard(sqlSession, boardNo);
		} else {
			sqlSession.rollback();
		}
		
		return b;
	}
	
	@Override
	public ArrayList<Board> selectMyPageBoardList(String loginId) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = bDao.selectMyPageBoardList(sqlSession, loginId);
		
		sqlSession.close();
		
		return list;
		
	}
	
	public int insertBoard(Board b, List<BoardFile> bfList) {
	    SqlSession sqlSession = Template.getSqlSession();

	    int result1 = bDao.insertBoard(sqlSession, b);
	    int result2 = 1;

	    if (bfList != null && !bfList.isEmpty()) {
	        for (BoardFile bf : bfList) {
	            result2 *= bDao.insertBoardFile(sqlSession, bf);
	        }
	    }

	    if (result1 > 0 && result2 > 0) {
	        sqlSession.commit();
	    } else {
	        sqlSession.rollback();
	    }

	    sqlSession.close();
	    return result1 * result2;
	}
	
	@Override
	public int insertComment(BoardComment boardComment) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bDao.insertComment(sqlSession, boardComment);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int deleteBoard(HttpServletRequest request, int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bDao.deleteBoard(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int updateBoard(Board b, BoardFile bf) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result1 = bDao.updateBoard(sqlSession, b);
		int result2 = 1;
		
		if(bf != null) {
			result2 = bDao.updateBoardFile(sqlSession, bf);
		}
		
		if(result1 > 0 && result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result1 *  result2;
	}
	
	public ArrayList<BoardComment> commentList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<BoardComment> list = bDao.commentList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return list;
	}
	
	public ArrayList<BoardComment> replyList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<BoardComment> list = bDao.replyList(sqlSession, boardNo);
		
		sqlSession.close();
		
		return list;
	}
	
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int searchCount = bDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		return searchCount;
	}
	
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Board> list = bDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		return list;
	}
	
	public List<BoardFile> filePath(int boardNo) {
	    SqlSession sqlSession = Template.getSqlSession();
	    List<BoardFile> bfList = bDao.filePath(sqlSession, boardNo);
	    sqlSession.close();
	    return bfList;
	}
	
	public int boardLike(HashMap<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int likeCount = 0;
		
		BoardLike tempStatus = bDao.checkLikeStatus(sqlSession, map);  // Integer 타입으로 임시 변수 선언

		int currentStatus = 0;  // 기본값 0으로 초기화
		if (tempStatus != null) {
		    currentStatus = 1;  // tempStatus가 null이 아닐 경우에만 할당
		}
		
		System.out.println(currentStatus);
        if (currentStatus == 0) {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 행이 없으면 처음 좋아요하는 경우이므로 행을 생성
            bDao.insertLike(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 1; // 좋아요 추가
        } else {
        	likeCount = 1;
        	map.put("likeCount", likeCount);
            // 좋아요 상태 -> 좋아요 취소
            bDao.updateLikeStatus(sqlSession, map);
            sqlSession.commit();
            sqlSession.close();
            return 0; // 좋아요 취소
        }
	}
	
	public int insertReply(BoardComment boardReply) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bDao.insertReply(sqlSession, boardReply);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int deleteComment(BoardComment boardComment) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bDao.deleteComment(sqlSession, boardComment);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int likeCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = bDao.likeCount(sqlSession, boardNo);
		
		sqlSession.close();
		
		return result;
	}

	public int insertBoard(Board b, BoardFile bf) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Board boardUpdatePage(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Board result = bDao.boardUpdatePage(sqlSession, boardNo);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public ArrayList<BoardFile> boardUpdatePageFile(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<BoardFile> result = bDao.boardUpdatePageFile(sqlSession, boardNo);
		
		sqlSession.close();
		
		return result;
	}
	
	
	// ----------------- 마이바티스 이전 ------------------------
}
