package com.itpro.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.itpro.model.dto.crawling.CompanyCrawlingDto;
import com.itpro.model.dto.crawling.CompanyCrawlingSearchDto;
import com.itpro.util.CompanyCrawler;
import com.itpro.util.PageProcessing;

@Controller
public class CompanyCrawlingController {
	
	private static final Logger logger = LoggerFactory.getLogger(CompanyCrawlingController.class);
	
	@Autowired
	private CompanyCrawlingBiz companyCrawlingBiz;
	
	//채용정보 list를 가져와서 뿌려주는 컨트롤러
	//매개변수로 model, 이동할 페이지, 검색정보가 담긴 dto를 받아서 처리한다.
	@RequestMapping(value="/companycrawlinglist.do")
	public String companyCrawlingList
		(Model model, 
		 @RequestParam(value="page", required=false, defaultValue="1") int page
		 ) {
		
		logger.info("companycrawlinglist 컨트롤러");
		
		//페이징 처리를 위해 게시글의 총 갯수를 가지고 온다.
		int companyCrawlingListCnt = companyCrawlingBiz.getCompanyCrawlingListCnt();
		
		//페이징 처리를 위한 class, 총 게시물 수와 보여줄 페이지를 매개변수로 주어 필요한 값들을 계산한다. 
		PageProcessing pageProcessing = new PageProcessing(companyCrawlingListCnt,page);
		
		//LIST를 가져오는데 페이지의 시작할 글번호와 마지막 글 번호를 map에 담아서 (mapper에서 매개변수를 여러개 못 주겠어서 map에 담음)
		//전달해준다.
		Map<String,Object> companyCrawlingPageMap = new HashMap<String,Object>();
		companyCrawlingPageMap.put("start", pageProcessing.getStartIndex());
		companyCrawlingPageMap.put("end", pageProcessing.getEndIndex());
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingBiz.selectList(companyCrawlingPageMap);
		
		//받아온 페이지 정보를 model에 담아둔다.
		model.addAttribute("pageProcessing",pageProcessing);
		
		//받아온 list를 model에 담아준다.
		model.addAttribute("companyCrawlingList",companyCrawlingList);
		
		//채용정보 눌렀을때 url 정보의 앞부분을 가져온다.
		model.addAttribute("companydetailurl",new CompanyCrawler().getDetail_URL());
		
		return "companycrawling/companycrawlinglist";
	}
	
	
	//검색 조건이 있을 경우 이 쪽으로 타고와서 list를 뿌려준다.
	@RequestMapping(value="/companycrawlinglistandsearch.do")
	public String companyCrawlingList
		(Model model, 
		 @RequestParam(value="page", required=false, defaultValue="1") int page,
		 CompanyCrawlingSearchDto companyCrawlingSearchDto) {
		
		logger.info("companycrawsearchlinglist 컨트롤러");
		
		//페이징 처리를 위해 게시글 조건에 맞는 총 갯수를 가지고 온다.
		int companycrawlingsearchcnt = companyCrawlingBiz.getCompanyCrawlingSearchCnt(companyCrawlingSearchDto);
		logger.info("companyCrawlingContentCnt : " + companycrawlingsearchcnt);
		
		//페이징 처리를 위한 class, 총 게시물 수와 보여줄 페이지를 매개변수로 주어 필요한 값들을 계산한다. 
		PageProcessing pageProcessing = new PageProcessing(companycrawlingsearchcnt,page);
	    
		//LIST를 가져오는데 이동할 페이지의 시작 글 번호, 마지막 글 번호, 검색 정보를 map에 담아 매개변수로 전달한다.
		Map<String,Object> companyCrawlingMap = new HashMap<String,Object>();
		companyCrawlingMap.put("start", pageProcessing.getStartIndex());
		companyCrawlingMap.put("end", pageProcessing.getEndIndex());
		companyCrawlingMap.put("companyCrawlingSearchDto", companyCrawlingSearchDto);
		List<CompanyCrawlingDto> companyCrawlingList = companyCrawlingBiz.selectschList(companyCrawlingMap);
		
		//검색 정보를 list에 되돌려주기 위해 model에 담아준다.
		model.addAttribute("companyCrawlingSearchDto",companyCrawlingSearchDto);
		
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
		companyCrawlingBiz.updatelist(companyCrawlingList);
		
		//companycrawlinglist 화면으로 가는 컨트롤러한테 보냄
		//나중에 insert 결과값(성공 실패 여부)에 따라 return 및 alert 출력할수 있게 수정하기
		return "redirect:companycrawlinglist.do";
	}
	
	@RequestMapping(value="/companycrawlingdelete.do")
	public String companyCrawlingDelete(HttpServletResponse response) {
		companyCrawlingBiz.deletelist();
		return "companycrawling/companycrawlinglist";
		
	}
	
	@RequestMapping(value="/companycrawlingwating.do")
	public String companyCrawlingWating() {
		return "companycrawling/companycrawlingwating";
	}
	

}
