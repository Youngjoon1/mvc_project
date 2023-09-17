package com.care.root.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.care.root.member.dto.MemberDTO;
import com.care.root.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired MemberMapper mapper;
	
	BCryptPasswordEncoder encoder;
	public MemberServiceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	
	public int loginCk(String id,String pw) {
		MemberDTO dto = mapper.loginCk(id);
		
		if(dto != null) {
			if(encoder.matches(pw, dto.getPw())) {
				return 1;
			}
		}
		return 0;
	}
	
	public MemberDTO info(String id) {
		MemberDTO dto = null;
		try {
			dto = mapper.info(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void join(MemberDTO dto) {
		dto.setPw(encoder.encode(dto.getPw()));
		try {
			mapper.join(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void del(String id) {
		try {
			mapper.del(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void modify(MemberDTO dto) {
		dto.setPw(encoder.encode(dto.getPw()));
		
		try {
			mapper.modify(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
