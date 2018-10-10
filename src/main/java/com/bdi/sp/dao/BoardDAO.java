package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.BoardInfo;

public interface BoardDAO {

	public List<BoardInfo> getBoardList(BoardInfo b);
	
	public int deleteBoard(int binum);
	
	public int updateBoard(BoardInfo b);
	
	public BoardInfo getBoardInfo(int binum);
	
	public String insertBoard(BoardInfo bi);
}
