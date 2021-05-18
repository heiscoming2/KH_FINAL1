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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.NoticeBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.notice.NoticeDto;
import com.itpro.model.dto.notice.NoticeSearchDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

@Controller
public class NoticeController {
	
	private Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeBiz noticeBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Autowired
	private BoardBiz boardBiz;
	
	@Autowired
	private LikeBiz likeBiz;
	
	
	@RequestMapping(value="/noticelist.do")
	public String noticeList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		logger.info("NOTICE LIST");
		
		//페이징을 위해 총 게시물수 count
		int noticeListCnt = noticeBiz.getNoticeListCnt();
		
		//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
		PageProcessing pageProcessing = new PageProcessing(noticeListCnt,page);
		
		//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
		//(이 부분은 나중에 PageProcessing 클래스에서 map을 바로 리턴받는 형태로 변경하는게 나을듯)
		Map<String,Object> noticePageMap = new HashMap<String,Object>();
		noticePageMap.put("start", pageProcessing.getStartIndex());
		noticePageMap.put("end", pageProcessing.getEndIndex());
		List<NoticeDto> noticeList = noticeBiz.selectList(noticePageMap);
		
		//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
		model.addAttribute("pageProcessing",pageProcessing);
		//스터디 글 목록을 받아 model에 담아준다.
		model.addAttribute("noticeList",noticeList);
		return "notice/noticelist";
	}
	
	@RequestMapping(value="/noticeinsertform.do")
	public String noticeInsertForm() {
		logger.info("NOTICE INSERT FORM");
		return "notice/noticeinsertform";
	}
	
	@RequestMapping(value="/noticeinsert.do")
	public String noticeInsert(HttpServletRequest request, HttpServletResponse response, NoticeDto noticeDto) {
		logger.info("NOTICE INSERT");
		//ClientInfo의 getClientIp에 request를 전달하여 ip 정보를 얻어와 NoticeDto에 저장
		noticeDto.setBd_writerip(new ClientInfo().getClientIp(request));
		noticeBiz.noticeInsert(noticeDto);
		return "redirect:noticelist.do";
	}	
	
	@RequestMapping(value="/noticedetail.do")
	public String noticeDetail(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="bd_no") int bd_no,HttpSession session) {
		logger.info("NOTICE DETAIL");
		
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
		
		//공지 selectone해서 model에 담아준다.
		NoticeDto noticeDto = noticeBiz.selectOne(bd_no);
		model.addAttribute("dto",noticeDto);
		//댓글 list받아와 model에 담아준다.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto",replyListDto);
		
		//댓글 총 갯수를 받아와 model에 담아준다.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt",replyCnt);
		
		return "notice/noticedetail";
	}
	
	@RequestMapping(value="/noticeupdateform.do")
	public String noticeUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		logger.info("NOTICE UPDATE FORM");
		NoticeDto noticeDto = noticeBiz.selectOne(bd_no);
		model.addAttribute("NoticeDto",noticeDto);
		return "notice/noticeupdateform";
	}
	
	@RequestMapping(value="/noticeupdate.do")
	public String noticeUpdate(Model model, NoticeDto noticeDto, BoardUpdateDto boardUpdateDto) {
		logger.info("NOTICE UPDATE");
		
		int noticeUpdateRes = noticeBiz.update(noticeDto,boardUpdateDto);
		logger.info(Integer.toString(noticeUpdateRes));
		if(noticeUpdateRes>0) {
			int bd_no = noticeDto.getBd_no();
			return "redirect:noticedetail.do?bd_no="+bd_no;
		}
		
		//실패시 updateDto에 작성했던 수정 정보를 
		//수정폼에서 사용하는 detailDto로 옮겨 담아주고
		//그걸 model에 담아서 수정폼으로 return 시켜준다.
		noticeDto = noticeBiz.selectOne(noticeDto.getBd_no()); 
		noticeDto.setBd_title(boardUpdateDto.getBd_title());
		noticeDto.setBd_content(boardUpdateDto.getBd_content());
		model.addAttribute("noticeDto",noticeDto);
		logger.info("업데이트 실패");
		return "notice/noticeupdateform";
	}	
	
	@RequestMapping(value="/noticedelete.do")
	public String noticeDelete(Model model, int bd_no,HttpServletResponse response) throws IOException {
		logger.info("NOTICE DELETE");
		//PrintWriter 공통으로 만들기
		int noticeDeleteRes = noticeBiz.delete(bd_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('삭제 되었습니다.');");
		out.print("location.href='studylist.do';");
		out.print("</script>");
		return null;
	}
	

	@RequestMapping(value="/noticesearch.do")
	public String noticeSearch(Model model, NoticeSearchDto noticeSearchDto) {
		logger.info("NOTICE SEARCH");
		
		//페이징 처리를 위해 갯수를 얻어온다.
		int noticeSearchListCnt = noticeBiz.getNoticeListSearchCnt(noticeSearchDto);
		
		//갯수와 페이지 번호로 페이지 정보를 가져온다.
		PageProcessing pageProcessing = new PageProcessing(noticeSearchListCnt,noticeSearchDto.getPage());
		
		//start와 end값, 검색 값으로 list를 가져오는데 map에 담아서 처리해준다.
		Map<String,Object> noticeSearchMap = new HashMap<String,Object>();
		noticeSearchMap.put("start", pageProcessing.getStartIndex());
		noticeSearchMap.put("end", pageProcessing.getEndIndex());
		noticeSearchMap.put("noticeSearchDto", noticeSearchDto);
		List<NoticeDto> noticeList = noticeBiz.selectSearchList(noticeSearchMap);
		
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("pageProcessing",pageProcessing);
		model.addAttribute("noticeSearchDto",noticeSearchDto);
		
		return "notice/noticelist";
	}	
	
	
}
