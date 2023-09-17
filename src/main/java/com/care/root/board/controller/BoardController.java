package com.care.root.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardService bs;
	@Autowired BoardFileService fs;
	
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "board/writeForm";
	}
	
	@GetMapping("boardAllList")
	public String boardAllList(Model model) {
		model.addAttribute("list",bs.getList());
		return "board/boardAllList";
	}
	
	@PostMapping("writeSave")
	public String wirteSave(BoardDTO dto,@RequestParam MultipartFile imageFileName) {
		System.out.println(imageFileName);
		bs.writeSave(dto,imageFileName);
		return "redirect:boardAllList";
	}
	
	@GetMapping("contentView")
	public String contentView(@RequestParam String title,Model model) {
		model.addAttribute("content",bs.contentView(title));
		return "board/contentView";
	}
}
