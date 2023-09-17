package com.care.root.mybatis.member;

import com.care.root.member.dto.MemberDTO;

public interface MemberMapper {
	public MemberDTO loginCk(String id);
	
	public MemberDTO info(String id);
	
	public void join(MemberDTO dto);
	
	public void del(String id);
	
	public void modify(MemberDTO dto);
	
}
