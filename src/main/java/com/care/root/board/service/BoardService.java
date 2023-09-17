package com.care.root.board.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;

public interface BoardService {
	
	public void writeSave(BoardDTO dto, MultipartFile imageFileName);
	
	public ArrayList<BoardDTO> getList();
	
	public BoardDTO contentView(String title);
	
	public String IMAGE_REPO = "C:\\springimage\\image";
}
