package com.kh.delivery.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.dao.MemberDao;
import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.exception.DuplicateMemberIdException;

public class MemberService {
	MemberDao md = new MemberDao();

	public int signUp(DeliMemberDto member) {
		SqlSession session = Template.getSqlSession();
		
		MemberDao md = new MemberDao();
		if(md.idCheck(member.getMemberId())){
			throw new DuplicateMemberIdException("중복아이디입니다.");
		}
		int result = md.signUp(session, member);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		return result;
		
	}
}
