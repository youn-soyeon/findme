package com.findme.model.dao;

import com.findme.model.vo.Member;

public interface MemberDAO {
	// C
	public boolean join(Member member);

	// R
	public Member searchMember(String memId);

	public Member login(String memId, String password);

	// U
	public int update(String memId);

	// D
	public int delete(String memId);
}
