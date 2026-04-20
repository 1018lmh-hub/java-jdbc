package com.kh.delivery.controller;

import com.kh.delivery.dto.DeliMemberDto;
import com.kh.delivery.service.MemberService;

public class MemberController {
	MemberService ms = new MemberService();
	
	public boolean idCheck(String memberId) {
		return ms.idCheck(memberId);
	}
	
	public int signUp(DeliMemberDto member) {
		return ms.signUp(member);
	}
}

