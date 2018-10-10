package com.bdi.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.dao.BoardDAO;
import com.bdi.sp.vo.BoardInfo;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO bdao;
	
	@RequestMapping(value="/boardInfo",method=RequestMethod.GET)
	public @ResponseBody List<BoardInfo> BoardList(@ModelAttribute BoardInfo bi){
		return bdao.getBoardList(bi); 
	}
	
	@RequestMapping(value="/boardInfo/{binum}",method=RequestMethod.GET)
	public @ResponseBody BoardInfo boardinfo(@PathVariable int binum){
		return bdao.getBoardInfo(binum); 
	}
	
	@RequestMapping(value="/boardInfo",method=RequestMethod.PUT)
	public @ResponseBody String updateBoard(@RequestBody BoardInfo bi){
		System.out.println(bi);
		return bdao.updateBoard(bi)+""; 
	}
	
	@RequestMapping(value="/boardInfo",method=RequestMethod.POST)
	public @ResponseBody String insertBoard(@RequestBody BoardInfo bi){
		return bdao.insertBoard(bi)+""; 
	}
	
	@RequestMapping(value="/boardInfo/{binum}",method=RequestMethod.DELETE)
	public @ResponseBody String deleteBoard(@PathVariable int binum){
		return bdao.deleteBoard(binum)+""; 
	}
}
