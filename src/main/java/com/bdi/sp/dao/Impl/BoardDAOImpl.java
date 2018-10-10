package com.bdi.sp.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.BoardDAO;
import com.bdi.sp.vo.BoardInfo;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Override
	public List<BoardInfo> getBoardList(BoardInfo b) {
		return ss.selectList("SQL.BOARDINFO.selectBoardInfoList",b);
	}

	@Override
	public int deleteBoard(int binum) {
		return ss.delete("SQL.BOARDINFO.deleteBoard",binum);
	}

	@Override
	public int updateBoard(BoardInfo b) {
		return ss.update("SQL.BOARDINFO.updateBoard",b);
	}

	@Override
	public BoardInfo getBoardInfo(int binum) {
		return ss.selectOne("SQL.BOARDINFO.selectBoard",binum);
	}

	@Override
	public String insertBoard(BoardInfo bi) {
		return ss.insert("SQL.BOARDINFO.insertBoard",bi)+"";
	}

}
