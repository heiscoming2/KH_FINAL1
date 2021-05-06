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
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudyUpdateDto;
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
	public String studyInsert(HttpServletRequest request, HttpServletResponse response, StudyInsertDto studyDto) {
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
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto",replyListDto);
		
		//댓글 총 갯수를 받아와 model에 담아준다.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt",replyCnt);
		return "studyboard/studydetail";
	}
	
	@RequestMapping(value="/studyupdateform.do")
	public String studyUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		logger.info("STUDY UPDATE FORM");
		StudyDetailDto studyDetailDto = studyBiz.selectOne(bd_no);
		model.addAttribute("studyDetailDto",studyDetailDto);
		return "studyboard/studyupdateform";
	}
	
	@RequestMapping(value="/studyupdate.do")
	public String studyUpdate(Model model, StudyUpdateDto studyUpdateDto, BoardUpdateDto boardUpdateDto) {
		logger.info("STUDY UPDATE");
		logger.info(Integer.toString(studyUpdateDto.getBd_no()));
		logger.info(Integer.toString(studyUpdateDto.getSt_closeperson()));
		logger.info(Integer.toString(studyUpdateDto.getSt_nowperson()));
		logger.info(boardUpdateDto.getBd_title());
		logger.info(Integer.toString(boardUpdateDto.getBd_no()));
		
		int studyUpdateRes = studyBiz.update(studyUpdateDto,boardUpdateDto);
		logger.info(Integer.toString(studyUpdateRes));
		if(studyUpdateRes>0) {
			int bd_no = studyUpdateDto.getBd_no();
			return "redirect:studydetail.do?bd_no="+bd_no;
		}
		
		//실패시 updateDto에 작성했던 수정 정보를 
		//수정폼에서 사용하는 detailDto로 옮겨 담아주고
		//그걸 model에 담아서 수정폼으로 return 시켜준다.
		StudyDetailDto studyDetailDto = studyBiz.selectOne(studyUpdateDto.getBd_no()); 
		studyDetailDto.setBd_title(boardUpdateDto.getBd_title());
		studyDetailDto.setSt_nowperson(studyUpdateDto.getSt_nowperson());
		studyDetailDto.setSt_closeperson(studyUpdateDto.getSt_closeperson());
		studyDetailDto.setSt_addr1(studyUpdateDto.getSt_addr1());
		studyDetailDto.setSt_addr2(studyUpdateDto.getSt_addr2());
		studyDetailDto.setSt_addrdetail(studyUpdateDto.getSt_addrdetail());
		studyDetailDto.setBd_content(boardUpdateDto.getBd_content());
		model.addAttribute("studyDetailDto",studyDetailDto);
		logger.info("업데이트 실패");
		return "studyboard/studyupdateform";
	}	
	
	@RequestMapping(value="/studydelete.do")
	public String studyDelete(Model model, int bd_no) {
		logger.info("STUDY DELETE");
		int studyDeleteRes = studyBiz.delete(bd_no);
		//나중에 int값으로 실패시 alert 처리
		return "redirect:studylist.do";
	}
	
		
}
