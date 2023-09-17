package com.care.root.member.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public int loginCk(String id,String pw);
	
	public MemberDTO info(String id);
	
	public void join(MemberDTO dto);
	
	public void del(String id);
	
	public void modify(MemberDTO dto);
	
}
