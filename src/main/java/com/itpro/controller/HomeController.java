package com.itpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.dto.board.SearchListDto;
import com.itpro.model.dto.member.PostLookupDto;
import com.itpro.util.PageProcessing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private BoardBiz boardBiz;
	
	@RequestMapping(value="/main.do")
	public String getMain(Model model,HttpServletRequest request) {
		log.info("main.do");
		return "main";
	}
	
	@RequestMapping(value="/searchlist.do")
	public String getMain(Model model,
			@RequestParam("keyword") String keyword,
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value="category", required=false, defaultValue="0") int category) {
		log.info("searchlist.do");
		Map<String,Object> searchlistMap = new HashMap<String,Object>();
		searchlistMap.put("keyword", keyword);
		searchlistMap.put("category",category);
		
		//게시물 총 갯수를 받아온다.
		int searchlistcnt = boardBiz.selectListCnt(searchlistMap);
		System.out.println(searchlistcnt);
		
		PageProcessing pageProcessing = new PageProcessing(searchlistcnt,page);
		searchlistMap.put("start", pageProcessing.getStartIndex());
		searchlistMap.put("end", pageProcessing.getEndIndex());
		List<SearchListDto> searchList = boardBiz.selectSearchList(searchlistMap);
		
		
		//총 게시물 수
		model.addAttribute("searchlistcnt",searchlistcnt);
		//게시물 list
		model.addAttribute("searchList",searchList);
		//페이징 정보
		model.addAttribute("pageProcessing",pageProcessing);
		//카테고리 정보 (하이라이트 효과 위해서)
		model.addAttribute("category",category);
		//검색어
		model.addAttribute("keyword",keyword);
		
		return "searchlist";
	}	
	
	
	
}
