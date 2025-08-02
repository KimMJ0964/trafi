package com.skt.member.model.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.course.model.vo.Course;
import com.skt.festival.model.vo.Festival;
import com.skt.member.model.vo.Interested;
import com.skt.member.model.vo.Member;
import com.skt.member.model.vo.MemberProfileImg;
import com.skt.tourist.model.vo.Tourist;

public class MemberDao {

	public int updateMember(SqlSession sqlSession, Member member) {
		System.out.println("UpdateDaoResult member : " + member);
		int UpdateDaoResult = sqlSession.update("memberMapper.updateMember", member);
		System.out.println("UpdateDaoResult : " + UpdateDaoResult);
		
		return UpdateDaoResult;
    }
    
    // 비밀번호 변경
    public int updatePassword(SqlSession sqlSession, Member member) {
    	return sqlSession.update("memberMapper.updatePassword", member);
    }
    
    public String selectPasswordByMemId(SqlSession sqlSession, String memId){
    	return sqlSession.selectOne("memberMapper.selectPasswordByMemId", memId);
    }
    
    public ArrayList<Board> myPageBoard(SqlSession sqlSession, String memId){
    	return (ArrayList)sqlSession.selectList("boardMapper.myPageBoard", memId);
    }
    
    public ArrayList<BoardComment> myPageComment(SqlSession sqlSession, String memId) {
    	return (ArrayList)sqlSession.selectList("boardMapper.myPageComment", memId);
    }
    
    public ArrayList<Festival> myPageInterested(SqlSession sqlSession, String memId) {
    	return (ArrayList)sqlSession.selectList("memberMapper.myPageInterested", memId);
    }
    
    public ArrayList<Tourist> myPageInterestedTwo(SqlSession sqlSession, String memId) {
    	return (ArrayList)sqlSession.selectList("memberMapper.myPageInterestedTwo", memId);
    }
    
    public ArrayList<Course> myPageInterestedThree(SqlSession sqlSession, String memId) {
    	return (ArrayList)sqlSession.selectList("memberMapper.myPageInterestedThree", memId);
    }
    
    public Member getMemberById(SqlSession session, String memId) {
        return session.selectOne("memberMapper.selectMemberById", memId);
    }
    
    public int deleteMember(SqlSession session, String memId) {
        return session.update("memberMapper.deleteMember", memId);
    }
    
    public Member myPageInfo(SqlSession sqlSession, String loginValue) {
    	return sqlSession.selectOne("memberMapper.myPageInfo", loginValue);
    }
    
    public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember",m);
	}

	public String searchByEmailOrPhone(SqlSession sqlSession, String input) {
		System.out.println("전달된 입력 값: " + input); 
	    return sqlSession.selectOne("memberMapper.searchByEmailOrPhone", input);
	}

	public String searchPassword(SqlSession sqlSession, String memId, String email) {
		Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("memId", memId);
	    paramMap.put("email", email);

	    return sqlSession.selectOne("memberMapper.searchPwd", paramMap);
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	public int insertMemberImg(SqlSession sqlSession, String memId) {
		return sqlSession.insert("memberMapper.insertProfileImage", memId);
	}
	
	public int checkId(SqlSession sqlSession, String checkId) {
        return sqlSession.selectOne("memberMapper.checkId", checkId);
    }
	
	 public int updateProfileImage(SqlSession sqlSession, String userId, String fileName, String filePath) {
	        Map<String, Object> params = new HashMap<>();
	        params.put("userId", userId);
	        params.put("fileName", fileName);
	        params.put("filePath", filePath);

	        int result = sqlSession.update("memberMapper.updateProfileImage", params);
	        return result;
	    }
	 
	 public MemberProfileImg selectProfileImage(SqlSession sqlSession, String memId) {
		 return sqlSession.selectOne("memberMapper.selectProfileImage", memId);
	 }
	 
	 public int saveProfileImage(SqlSession sqlSession, MemberProfileImg mbfi) {
		 return sqlSession.update("memberMapper.saveProfileImage", mbfi);
	 }
	 
	 public MemberProfileImg getProfileImg(SqlSession sqlSession, String memId) {
		 return sqlSession.selectOne("memberMapper.selectProfileImage", memId);
	 }
	 
	 public int deleteInterestedFestival(SqlSession sqlSession, Interested interested) {
		 return sqlSession.delete("memberMapper.deleteInterestedFestival", interested);
	 }
	 
	 public int deleteInterestedTour(SqlSession sqlSession, Interested interested) {
		 return sqlSession.delete("memberMapper.deleteInterestedTour", interested);
	 }
	 
	 public int deleteInterestedCourse(SqlSession sqlSession, Interested interested) {
		 return sqlSession.delete("memberMapper.deleteInterestedCourse", interested);
	 }
}