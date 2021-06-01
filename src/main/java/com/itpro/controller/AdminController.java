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
import org.springframework.web.servlet.ModelAndView;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.BoardCategoryBiz;
import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.admin.ManageMemberDto_com;

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
	@RequestMapping("/member_list.do")
	public ModelAndView member_list(Model model, @RequestParam(defaultValue="m_nickname") String search_option,@RequestParam(defaultValue="") String keyword ) {
		
		
		//map에 저장하기 위해 list를 만들어서 검색옵션과 키워드를 저장한다.
        List<ManageMemberDto> list = biz.selectList(search_option, keyword);
        
        ModelAndView mav = new ModelAndView();
        Map<String,Object> map = new HashMap<>();    //넘길 데이터가 많기 때문에 해쉬맵에 저장한 후에 modelandview로 값을 넣고 페이지를 지정
		
        map.put("search_option", search_option);
        map.put("keyword", keyword);
        mav.addObject("map", map);                    //modelandview에 map를 저장
		
        System.out.println("map : "+map);
        mav.setViewName("admin/member_list");                //자료를 넘길 뷰의 이름
        
		logger.info("select list");
		//model.addAttribute("list",biz.selectList());
		return mav;
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
		public String member_list_com(Model model ) {
			logger.info("select list_com");
			model.addAttribute("list_com",biz.selectList_com());
			
			
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
