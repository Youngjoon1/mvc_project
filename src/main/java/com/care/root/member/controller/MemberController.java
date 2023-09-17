package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberService ms;
	
	
	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("loginCk")
	public String loginCk(@RequestParam String id,@RequestParam String pw,HttpSession user) {
		int result = ms.loginCk(id, pw);
		if(result == 1) {
			user.setAttribute("user", id);
			return "redirect:/";
		}else {
			return "redirect:login";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession user) {
		user.invalidate();
		return "redirect:login";
	}
	
	
	@GetMapping("info")
	public String info(Model model,@RequestParam String id) {
		model.addAttribute("userInfo",ms.info(id));
		return "member/info";
	}
	
	@GetMapping("joinForm")
	public String joinForm() {
		return "member/joinForm"; 
	}
	
	@PostMapping("join")
	public String join(MemberDTO dto) {
		ms.join(dto);
		return "redirect:login";
	}
	
	@GetMapping("del")
	public String del(HttpSession user) {
		ms.del((String)user.getAttribute("user"));
		
		user.invalidate();
		return "redirect:login";
	}
	
	@GetMapping("modifyForm")
	public String modifyForm(@RequestParam String id,Model model) {
		
		
		model.addAttribute("userInfo",ms.info(id));
		
		
		return "member/modifyForm";
	}
	
	@PostMapping("modify")
	public String modify(MemberDTO dto) {
		ms.modify(dto);
		return "redirect:/";
	}
	
	
	
}
