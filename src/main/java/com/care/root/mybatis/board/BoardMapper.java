package com.care.root.mybatis.board;

import java.util.ArrayList;

import com.care.root.board.dto.BoardDTO;

public interface BoardMapper {
	
	public void writeSave(BoardDTO dto);
	
	public ArrayList<BoardDTO> getList();
	
	public BoardDTO contentView(String title);
	
	
}
