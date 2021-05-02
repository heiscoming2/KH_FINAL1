package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dto.ReplyDto;
import com.itpro.model.dto.StudyDetailDto;
import com.itpro.model.dto.StudyDto;
import com.itpro.model.dto.StudyListDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;

@Controller
public class StudyController {
	
	private Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Autowired
	private StudyBiz studyBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@RequestMapping(value="/studylist.do")
	public String studyList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		logger.info("STUDY LIST");
		
		//페이징을 위해 총 게시물수 count
		int studyListCnt = studyBiz.getStudyListCnt();
		
		//테스트 훟 삭제
		logger.info("studyListCnt : "+studyListCnt);
		
		//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
		PageProcessing pageProcessing = new PageProcessing(studyListCnt,page);
		
		//테스트 훟 삭제
		logger.info(Integer.toString(pageProcessing.getCurPage()));
		logger.info(Integer.toString(pageProcessing.getCurRange()));
		logger.info(Integer.toString(pageProcessing.getEndPage()));
		logger.info(Integer.toString(pageProcessing.getPageSize()));
		logger.info(Integer.toString(pageProcessing.getEndIndex()));
		
		//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
		//(이 부분은 나중에 PageProcessing 클래스에서 map을 바로 리턴받는 형태로 변경하는게 나을듯)
		Map<String,Object> studyPageMap = new HashMap<String,Object>();
		studyPageMap.put("start", pageProcessing.getStartIndex());
		studyPageMap.put("end", pageProcessing.getEndIndex());
		List<StudyListDto> studyList = studyBiz.selectList(studyPageMap);
		
		//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
		model.addAttribute("pageProcessing",pageProcessing);
		//스터디 글 목록을 받아 model에 담아준다.
		model.addAttribute("studyList",studyList);
		return "studyboard/studylist";
	}
	
	@RequestMapping(value="/studyinsertform.do")
	public String studyInsertForm() {
		logger.info("STUDY INSERT FORM");
		return "studyboard/studyinsertform";
	}
	
	@RequestMapping(value="/studyinsert.do")
	public String studyInsert(HttpServletRequest request, HttpServletResponse response, StudyDto studyDto) {
		logger.info("STUDY INSERT");
		//ClientInfo의 getClientIp에 request를 전달하여 ip 정보를 얻어와 StudyDto에 저장
		studyDto.setBd_writerip(new ClientInfo().getClientIp(request));
		studyBiz.studyInsert(studyDto);
		return "redirect:studylist.do";
	}	
	
	@RequestMapping(value="/studydetail.do")
	public String studyDetail(Model model, @RequestParam(value="bd_no") int bd_no) {
		logger.info("STUDY DETAIL");
		
		//조회수 중복 카운트 방지를 위해 쿠기 사용
		//bd_no가 쿠키에 있는 경우 조회수 증가, 그렇지 않은 경우 조회수 유지
		//
		
		//스터디 selectone해서 model에 담아준다.
		StudyDetailDto studyDetailDto = studyBiz.selectOne(bd_no);
		
		model.addAttribute("studyDetailDto",studyDetailDto);
		
		//댓글 list받아와 model에 담아준다.
		List<ReplyDto> replyList = replyBiz.selectList();
		model.addAttribute("replyList",replyList);
		
		return "studyboard/studydetail";
	}
	
	@RequestMapping(value="/studyupdate.do")
	public String studyUpdate(Model model) {
		
		logger.info("STUDY UPDATE");
		return "studyboard/studyupdate";
	}
		
}
