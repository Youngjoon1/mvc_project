package com.care.root.board.controller;


import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.board.service.BoardFileService;
import com.care.root.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired BoardService bs;
	
	
	
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
	public String wirteSave(BoardDTO dto,@RequestParam MultipartFile imgFileName) {
		bs.writeSave(dto,imgFileName);
		return "redirect:boardAllList";
	}
	
	@GetMapping("contentView")
	public String contentView(@RequestParam int number,Model model) {
		model.addAttribute("content",bs.contentView(number));
		return "board/contentView";
	}
	
	@GetMapping("download")
	public void download(@RequestParam String name,HttpServletResponse res) throws Exception {
		res.addHeader("Content-disposition","attachment; fileName=" + URLEncoder.encode(name,"utf-8"));
		File file = new File(BoardFileService.IMAGE_REPO+"/"+name);
		FileInputStream in = new FileInputStream(file);
		FileCopyUtils.copy(in, res.getOutputStream());
		in.close();
	}
}
