package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.biz.StudyBiz;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.LoginDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

@Controller
public class StudyController {
	
	private Logger logger = LoggerFactory.getLogger(StudyController.class);
	
	@Autowired
	private StudyBiz studyBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Autowired
	private BoardBiz boardBiz;
	
	@Autowired
	private LikeBiz likeBiz;
	
	@RequestMapping(value="/studylist.do")
	public String studyList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page,HttpSession session) {
		logger.info("STUDY LIST");
		if(session.getAttribute("login")!=null) {
			LoginDto login = (LoginDto) session.getAttribute("login");
		}
		
		//페이징을 위해 총 게시물수 count
		int studyListCnt = studyBiz.getStudyListCnt();
		
		//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
		PageProcessing pageProcessing = new PageProcessing(studyListCnt,page);
		
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
	public String studyDetail(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="bd_no") int bd_no, HttpSession session) {
		logger.info("STUDY DETAIL");
		
		//로그인 세션이있으면 회원번호를 꺼내서 해당 게시물 추천여부를 model에 담아준다. 
		if(session.getAttribute("login")!=null) {
			LoginDto loginDto = (LoginDto) session.getAttribute("login");
			int m_no = loginDto.getM_no();
			LikeDto likeDto = new LikeDto();
			likeDto.setBd_no(bd_no);
			likeDto.setM_no(m_no);
			int res = likeBiz.like_check(likeDto);
			model.addAttribute("likecheck",res);
		}
		
		//조회수 증가 실행 (중복 카운트 방지를 위해 쿠키에 값이 없는 경우에만 증가)
		if(new ViewCount().viewCount(request, response, bd_no)) {
			boardBiz.updateviewcount(bd_no);
		}
		
		
		//스터디 selectone해서 model에 담아준다.
		StudyDetailDto studyDetailDto = studyBiz.selectOne(bd_no);
		model.addAttribute("dto",studyDetailDto);
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
	public String studyDelete(Model model, int bd_no,HttpServletResponse response) throws IOException {
		logger.info("STUDY DELETE");
		//PrintWriter 공통으로 만들기
		int studyDeleteRes = studyBiz.delete(bd_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('삭제 되었습니다.');");
		out.print("location.href='studylist.do';");
		out.print("</script>");
		return null;
	}
	

	@RequestMapping(value="/studysearch.do")
	public String studySearch(Model model, StudySearchDto studySearchDto) {
		logger.info("STUDY SEARCH");
		
		//페이징 처리를 위해 갯수를 얻어온다.
		int studySearchListCnt = studyBiz.getStudyListSearchCnt(studySearchDto);
		
		//갯수와 페이지 번호로 페이지 정보를 가져온다.
		PageProcessing pageProcessing = new PageProcessing(studySearchListCnt,studySearchDto.getPage());
		
		//start와 end값, 검색 값으로 list를 가져오는데 map에 담아서 처리해준다.
		Map<String,Object> studySearchMap = new HashMap<String,Object>();
		studySearchMap.put("start", pageProcessing.getStartIndex());
		studySearchMap.put("end", pageProcessing.getEndIndex());
		studySearchMap.put("studySearchDto", studySearchDto);
		List<StudyListDto> studyList = studyBiz.selectSearchList(studySearchMap);
		
		model.addAttribute("studyList",studyList);
		model.addAttribute("pageProcessing",pageProcessing);
		model.addAttribute("studySearchDto",studySearchDto);
		
		return "studyboard/studylist";
	}	
	
	@RequestMapping(value="/studystatchange.do")
	@ResponseBody
	public boolean studyStatchange(@RequestBody Map<String,Object> map) {
		System.out.println("studychange");
		int bd_no = Integer.parseInt(map.get("bd_no").toString());
		System.out.println(bd_no);
		int res = studyBiz.updatestatus(bd_no);
		System.out.println(res);
		System.out.println("test");
		return res>0?true:false;
	}
	
	
	
	
}
