package com.itpro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.BoardCategoryBiz;
import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.admin.ManageMemberDto_com;
import com.itpro.model.dto.member.PostLookupDto;
import com.itpro.util.PageProcessing;

@Controller
public class AdminController {
	private Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	ManageMemberBiz biz;
	
	
	@Autowired
	BoardBiz boardbiz;
	
	@Autowired
	BoardCategoryBiz categorybiz;
	
	////////////////////////////회원 관리 part/////////////////////////////////////////////////
	
	
	////개인회원 + 관리자//////////////////////
	@RequestMapping(value="/member_list.do")
	public String member_list(Model model, @RequestParam(defaultValue="all") String search_option,
							@RequestParam(value="keyword", required=false) String keyword ) {
		
		logger.info("select list");
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		
		
		//list를 얻어오는데 작성자 m_no, 받아올 페이지 정보를 map에 담아서 해당 내용을 가져온다.
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		List<ManageMemberDto> list = biz.selectList(map);
		logger.info("list size : "+Integer.toString(list.size()));
		for(ManageMemberDto dto : list) {
			logger.info(dto.toString());
		}
		
		//검색어
		model.addAttribute("keyword",keyword);
		model.addAttribute("list",list);
		return "admin/member_list";
	}
	
	

	@RequestMapping(value="/member_detail.do")
	public String member_detail(Model model, int m_no) {
		
		logger.info("member_detail");
		
		model.addAttribute("dto", biz.selectOne(m_no));
		return "admin/member_detail";
	}
	
	@RequestMapping(value="/member_updateform.do")
	public String member_updateform(Model model, int m_no) {
		
		logger.info("member_updateform");
		
		model.addAttribute("dto", biz.selectOne(m_no));
		return "admin/member_update";
	}
	
	@RequestMapping(value="/member_update.do")
	public String update(ManageMemberDto dto) {
		logger.info("member_update");
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:member_detail.do?m_no="+dto.getM_no();
		}else {
			return "redirect:updateform.do?m_no="+dto.getM_no();
		}
	}
		
		
	//// 기업회원 //////////////////////
		@RequestMapping("/member_list_com.do")
		public String member_list_com(Model model, @RequestParam(defaultValue="all") String search_option,
				@RequestParam(value="keyword", required=false) String keyword ) {
			logger.info("select list_com");
			
			Map<String,Object> map = new HashMap<String,Object>();
			
			
			//list를 얻어오는데 작성자 m_no, 받아올 페이지 정보를 map에 담아서 해당 내용을 가져온다.
			map.put("search_option", search_option);
			map.put("keyword", keyword);
			List<ManageMemberDto_com> list_com = biz.selectList_com(map);
			logger.info("list_com size : "+Integer.toString(list_com.size()));
			for(ManageMemberDto_com dto : list_com) {
				logger.info(dto.toString());
			
			}
			//검색어
			model.addAttribute("keyword",keyword);
			model.addAttribute("list_com",list_com);
			
			return "admin/member_list_com";
		
		}
		
		@RequestMapping(value="/member_detail_com.do")
		public String member_detail_com(Model model, int m_no) {
			
			logger.info("member_detail_com" );
			
			System.out.println("biz에 오는 값");
			ManageMemberDto_com manageMemberDto_com = biz.selectOne_com(m_no);
			model.addAttribute("dto", manageMemberDto_com);
			
			logger.info(manageMemberDto_com.getM_nickname());
			

			return "admin/member_detail_com";
		}
		
		@RequestMapping(value="/member_updateform_com.do")
		public String member_updateform_com(Model model, int m_no) {
			
			logger.info("member_updateform_com");
			
			model.addAttribute("dto", biz.selectOne_com(m_no));
			return "admin/member_update_com";
		}
		
		@RequestMapping(value="/member_update_com.do")
		public String update_com(ManageMemberDto_com dto) {
			logger.info("member_update_com");
			int res_com = biz.update_com(dto);
			
			if(res_com>0) {
				return "redirect:member_detail_com.do?m_no="+dto.getM_no();
			}else {
				return "redirect:member_updateform_com.do?m_no="+dto.getM_no();
			}
		
		}
		
	

		
	
}
