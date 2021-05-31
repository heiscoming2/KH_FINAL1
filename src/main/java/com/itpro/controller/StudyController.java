package com.itpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.study.StudyDetailDto;
import com.itpro.model.dto.study.StudyInsertDto;
import com.itpro.model.dto.study.StudyJoinInfoDto;
import com.itpro.model.dto.study.StudyListDto;
import com.itpro.model.dto.study.StudySearchDto;
import com.itpro.model.dto.study.StudyUpdateDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.JavaScriptResponse;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudyController {
	
	
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
		log.info("STUDY LIST");
		if(session.getAttribute("login")!=null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
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
		log.info("STUDY INSERT FORM");
		return "studyboard/studyinsertform";
	}
	
	@RequestMapping(value="/studyinsert.do")
	public String studyInsert(HttpServletRequest request, HttpServletResponse response, StudyInsertDto studyDto) {
		log.info("STUDY INSERT");
		//ClientInfo의 getClientIp에 request를 전달하여 ip 정보를 얻어와 StudyDto에 저장
		studyDto.setBd_writerip(new ClientInfo().getClientIp(request));
		studyBiz.studyInsert(studyDto);
		return "redirect:studylist.do";
	}	
	
	@RequestMapping(value="/studydetail.do")
	public String studyDetail(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="bd_no") int bd_no, HttpSession session) {
		log.info("STUDY DETAIL");
		
		//로그인 세션이있으면 회원번호를 꺼내서 해당 게시물 추천여부를 model에 담아준다. 
		if(session.getAttribute("login")!=null) {
			MemberDto loginDto = (MemberDto) session.getAttribute("login");
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
		model.addAttribute("replyCnt", replyCnt);
		
		//이 부분 나중에 num 받아올때 깔끔하게 변경좀 해주어야한다. 
		//스터디 참여 정보를 모두 받아와 model에 담아준다.
		List<StudyJoinInfoDto> studyJoinInfoList = studyBiz.studyJoinInfoSelectList(bd_no);
		//스터디 참여 정보 list를 돌면서
		//참여 중인 인원수와 참여 대기 중인 인원수를 뽑은 후에
		//model에 담아준다.
		int joinnednum = 0; //스터디 참여 중인 인원수
		int applynum = 0; //스터디 참여 대기 중인 인원수
		for(StudyJoinInfoDto dto : studyJoinInfoList) {
			if(dto.getSj_isjoin().equals("y")) {
				joinnednum++;
			} else {
				applynum++;
			}
		}
		log.info("joinnednum : "+Integer.toString(joinnednum));
		log.info("applynum : "+Integer.toString(applynum));
		model.addAttribute("joinnednum",joinnednum);
		model.addAttribute("applynum",applynum);
		return "studyboard/studydetail";
	}
	
	@RequestMapping(value="/studyjoininfolist.do")
	@ResponseBody
	public List<StudyJoinInfoDto> studyJoinInfoList(@RequestBody StudyJoinInfoDto studyJoinInfodto) {
		List<StudyJoinInfoDto> studyJoinInfoList = studyBiz.studyJoinInfoSelectList(studyJoinInfodto);
		for(StudyJoinInfoDto dto : studyJoinInfoList) {
			log.info(dto.toString());
		}
		return studyJoinInfoList;
	}
	
	@RequestMapping(value="/studyupdateform.do")
	public String studyUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		log.info("STUDY UPDATE FORM");
		StudyDetailDto studyDetailDto = studyBiz.selectOne(bd_no);
		model.addAttribute("studyDetailDto",studyDetailDto);
		return "studyboard/studyupdateform";
	}
	
	@RequestMapping(value="/studyupdate.do")
	public String studyUpdate(Model model, StudyUpdateDto studyUpdateDto, BoardUpdateDto boardUpdateDto) {
		log.info("STUDY UPDATE");
		
		int studyUpdateRes = studyBiz.update(studyUpdateDto,boardUpdateDto);
		log.info(Integer.toString(studyUpdateRes));
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
		log.info("업데이트 실패");
		return "studyboard/studyupdateform";
	}	
	
	@RequestMapping(value="/studydelete.do")
	public void studyDelete(Model model, int bd_no,HttpServletResponse response) throws IOException {
		log.info("STUDY DELETE");
		int studyDeleteRes = studyBiz.delete(bd_no);
		if(studyDeleteRes>0) {
			new JavaScriptResponse().jsResponse(response, "삭제 되었습니다.", "studylist.do");
		} else {
			new JavaScriptResponse().jsResponse(response, "삭제 실패하였습니다", "studydetail.do?bd_no="+bd_no);
		}
	}
	

	@RequestMapping(value="/studysearch.do")
	public String studySearch(Model model, StudySearchDto studySearchDto) {
		log.info("STUDY SEARCH");
		
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
		log.info("studychange");
		int bd_no = Integer.parseInt(map.get("bd_no").toString());
		int res = studyBiz.updatestatus(bd_no);
		return res>0?true:false;
	}
	
	@RequestMapping(value="/studyjoinapply.do")
	@ResponseBody
	public Map<String,Object> studyJoinApply(@RequestBody StudyJoinInfoDto studyJoinInfoDto) {
		//참여신청 이력이 있는지 먼저 조회한다.
		//없는경우 참여신청 insert
		//이미 있는 경우 쿼리 수행 없이 return
		Map<String,Object> map = new HashMap<String, Object>();
		int res1 = studyBiz.studyJoinApplySelectOne(studyJoinInfoDto);
		if(res1==1) {
			map.put("msg", "이미 참여 중 or 참여 신청한 스터디 입니다.");
		} else {
			int res = studyBiz.studyJoinApplyInsert(studyJoinInfoDto);
			map.put("msg","참여 신청하였습니다.");
			map.put("stat", ".");
		}
		return map;
		
	}	
	
	@RequestMapping(value="/studyjoindrop.do")
	@ResponseBody
	public Map<String,Object> studyJoinDrop(@RequestBody StudyJoinInfoDto studyJoinInfoDto) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		int res = studyBiz.studyJoinDelete(studyJoinInfoDto);
		if(res>0) {
			map.put("stat", ".");
		} 
		return map;
	}	
	
	@RequestMapping(value="/studyjoinaccept.do")
	@ResponseBody
	public Map<String,Object> studyJoinAccept(@RequestBody StudyJoinInfoDto studyJoinInfoDto) {
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		int res = studyBiz.studyJoinAccept(studyJoinInfoDto);
		if(res>0) {
			map.put("stat", ".");
		} 
		return map;
	}		
}
