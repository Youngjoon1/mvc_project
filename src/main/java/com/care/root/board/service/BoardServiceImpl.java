package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;
	
	public void writeSave(BoardDTO dto, MultipartFile imageFileName) {
		
		if(!imageFileName.isEmpty() ) {
			dto.setImageFileName(bfs.saveFile(imageFileName));
		}else {
			dto.setImageFileName("nan");
		}
		
		try {
			mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<BoardDTO> getList() {
		ArrayList<BoardDTO> list = null;
		try {
			list = mapper.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardDTO contentView(int number) {
		BoardDTO dto = mapper.contentView(number);
		return dto;
	}
}
