package com.care.root.board.service;

import org.springframework.web.multipart.MultipartFile;

public interface BoardFileService {
	
	public String saveFile(MultipartFile imageFileName);
	
	public String IMAGE_REPO = "C:\\springimage\\image";
}
