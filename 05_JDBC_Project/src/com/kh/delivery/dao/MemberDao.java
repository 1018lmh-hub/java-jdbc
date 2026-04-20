package com.kh.delivery.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.dto.DeliMemberDto;

public class MemberDao {
	public int signUp(SqlSession session, DeliMemberDto member) {
		return session.insert("memberMapper.signUp", member);
	}
}
