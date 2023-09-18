package com.care.root.board.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardFileServiceImpl implements BoardFileService {
	@Autowired BoardMapper mapper;
	public String saveFile(MultipartFile imageFileName) {
		SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
		String sysFile = fo.format(new Date());
		sysFile += imageFileName.getOriginalFilename();
		File sysSaveFile = new File(IMAGE_REPO + "/" + sysFile);
		try {
			imageFileName.transferTo(sysSaveFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysFile;
		
	}
	
}

