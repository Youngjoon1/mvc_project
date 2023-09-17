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
	
public void writeSave(BoardDTO dto, MultipartFile imageFileName) {
		
		if(!imageFileName.isEmpty()) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			String sysName = fo.format(new Date());
			sysName += imageFileName.getOriginalFilename();
			File saveFile = new File(IMAGE_REPO + "/" + sysName);
			
			try {
				imageFileName.transferTo(saveFile);
				dto.setImageFileName(sysName);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		try {
			ArrayList<BoardDTO> list = mapper.getList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BoardDTO contentView(String title) {
		BoardDTO dto = mapper.contentView(title);
		return dto;
	}
}
