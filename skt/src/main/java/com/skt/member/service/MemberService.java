package com.skt.member.service;

import java.util.ArrayList;

import com.skt.board.model.vo.Board;
import com.skt.board.model.vo.BoardComment;
import com.skt.course.model.vo.Course;
import com.skt.festival.model.vo.Festival;
import com.skt.member.model.vo.Interested;
import com.skt.member.model.vo.Member;
import com.skt.member.model.vo.MemberProfileImg;
import com.skt.tourist.model.vo.Tourist;

public interface MemberService {
	
	int updateMember(Member member);

    int updatePassword(Member member);

    String selectPasswordByMemId(String memId);

    ArrayList<Board> myPageBoard(String memId);

    ArrayList<BoardComment> myPageComment(String memId);

    ArrayList<Festival> myPageInterested(String memId);

    ArrayList<Tourist> myPageInterestedTwo(String memId);
    
    ArrayList<Course> myPageInterestedThree(String memId);

    Member getMemberById(String memId);

    int deleteMember(String memId);

    Member myPageInfo(String loginValue);

    Member loginMember(Member m);

    String searchByEmailOrPhone(String input);

    String searchPassword(String memId, String email);

    int insertMember(Member m);

    int checkId(String checkId);

    MemberProfileImg selectProfileImage(String loginValue);

    int saveProfileImage(String userId, String fileName, String filePath);

    MemberProfileImg getProfileImg(String memId);

    int deleteInterestedFestival(Interested interested);

    int deleteInterestedTour(Interested interested);
    
    int deleteInterestedCourse(Interested interested);
}
