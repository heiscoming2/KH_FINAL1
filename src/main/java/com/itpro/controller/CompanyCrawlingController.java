package com.itpro.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.CompanyCrawlingBiz;
import com.itpro.model.bizImpl.CompanyCrawlingBizImpl;
import com.itpro.model.dto.CompanyCrawlingDto;
import com.itpro.model.dto.CompanyCrawlingSearchDto;
import com.itpro.util.CompanyCrawler;
import com.itpro.util.PageProcessing;

@Controller
public class CompanyCrawlingController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyCrawlingController.class);
	
	@Autowired
	private CompanyCrawlingBiz companyCrawlingBizImpl;
	
	//채용정보 list를 가져와서 뿌려주는 컨트롤러
	//매개변수로 model, 이동할 페이지, 검색정보가 담긴 dto를 받아서 처리한다.
	@RequestMapping(value="/companycrawlinglist.do")
	public String companyCrawlingList
		(Model model, 
		 @RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		//페이징 처리를 위해 게시글의 총 갯수를 가지고 온다.
		int companyCrawlingContentCnt = companyCrawlingBizImpl.getCompanyCrawlingContentCnt();
		
		//페이징 처리를 위한 class, 총 게시물 수와 보여줄 페이지를 매개변수로 주어 필요한 값들을 계산한다. 
		PageProcessing pageProcessing = new PageProcessing(companyCrawlingContentCnt,page);
		
		//LIST를 가져오는데 page를 주어 해당 page의 게시물을 들고오도록 한다.
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingBizImpl.selectList(page);
		
		//받아온 페이지 정보를 model에 담아둔다.
		model.addAttribute("pageProcessing",pageProcessing);
		
		//받아온 list를 model에 담아준다.
		model.addAttribute("companyCrawlingList",companyCrawlingList);
		
		//채용정보 눌렀을때 url 정보의 앞부분을 가져온다.
		model.addAttribute("companydetailurl",new CompanyCrawler().getDetail_URL());
		
		return "companycrawling/companycrawlinglist";
	}

	
	@RequestMapping(value="/companycrawlingupdate.do")
	public String companyCrawlingInsert(Model model) {
		
		//채용정보 크롤링을 위해 CompanyCrawler 생성
		CompanyCrawler companyCralwer = new CompanyCrawler();
		
		//받아온 채용정보를 list형태로 저장
		List<CompanyCrawlingDto> companyCrawlingList = companyCralwer.getCompanyCrawlingList();
		
		//list를 테이블에 저장
		companyCrawlingBizImpl.updatelist(companyCrawlingList);
		
		//companycrawlinglist 화면으로 가는 컨트롤러한테 보냄
		//나중에 insert 결과값(성공 실패 여부)에 따라 return 및 alert 출력할수 있게 수정하기
		return "redirect:companycrawlinglist.do";
	}
	
	@RequestMapping(value="/companycrawlingdelete.do")
	public String companyCrawlingDelete(HttpServletResponse response) {
		//나중에 결과값(성공 실패 여부)에 따라 return 및 alert 출력할수 있게 수정하기
		companyCrawlingBizImpl.deletelist();
		return "companycrawling/companycrawlinglist";
		
	}
	

}
