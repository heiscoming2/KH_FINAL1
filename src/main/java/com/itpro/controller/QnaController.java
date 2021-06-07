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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.QnaBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaListDto;
import com.itpro.model.dto.qna.QnaSearchDto;
import com.itpro.model.dto.qna.QnaUpdateDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

@Controller
public class QnaController {

private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaBiz qnaBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Autowired
	private BoardBiz boardBiz;
	
	@Autowired
	private LikeBiz likeBiz;
	
	@RequestMapping(value="/qnalist.do")
		public String qnaList(Model model, 
				@RequestParam(value="page", required=false, defaultValue="1") int page, 
				@RequestParam(value="key", required=false, defaultValue="") String key,
				HttpSession session) {
		
			logger.info("QNA LIST");
			if(session.getAttribute("login")!=null) {
				MemberDto login = (MemberDto) session.getAttribute("login");
			}
			Map<String,Object> qnaPageMap = new HashMap<String,Object>();
			qnaPageMap.put("key",key);
			
			//페이징을 위해 총 게시물수 count
			int qnaListCnt = qnaBiz.getQnaListCnt(qnaPageMap);
			System.out.println("qnaListCnt : "+ qnaListCnt);
			
			//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
			PageProcessing pageProcessing = new PageProcessing(qnaListCnt,page);
				
			//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
			qnaPageMap.put("start", pageProcessing.getStartIndex());
			qnaPageMap.put("end", pageProcessing.getEndIndex());
			System.out.println(pageProcessing.getStartIndex());
			System.out.println(pageProcessing.getEndIndex());
			List<QnaListDto> qnaList = qnaBiz.selectList(qnaPageMap);
			
			//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
			model.addAttribute("pageProcessing",pageProcessing);
				
			//qna 글 목록을 받아 model에 담아준다.
			model.addAttribute("qnaList", qnaList);
			
			
			//검색값
			model.addAttribute("key",key);
			
			return "qna/qnalist";
		}
		
	
	@RequestMapping(value="/qnainsertform.do")
	public String qnaInsertForm() {
		logger.info("QNA INSERT FORM");
		return "qna/qnainsertform";
	}
	
	@RequestMapping(value="/qnainsert.do", method=RequestMethod.POST)
	public String qnaInsert(HttpServletRequest request, HttpServletResponse response, QnaInsertDto qnaDto) {
		logger.info("QNA INSERT");
		logger.info(qnaDto.toString());
		//ClientInfo의 getClientIp에 request를 전달하여 ip 정보를 얻어와 qnaDto에 저장
		qnaDto.setBd_writerip(new ClientInfo().getClientIp(request));
		int res = qnaBiz.qnaInsert(qnaDto);
		System.out.println("res:"+res);
		return "redirect:qnalist.do";

	}	
	
	
	@RequestMapping(value="/qnadetail.do")
	public String qnaDetail(HttpServletRequest request,  HttpServletResponse response, Model model, @RequestParam(value="bd_no") int bd_no, HttpSession session) {
		logger.info("QNA DETAIL");
		
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
		
		
		//selectOne 해서 model에 담아준다.
		QnaDetailDto qnaDetailDto = qnaBiz.selectOne(bd_no);
		model.addAttribute("dto",qnaDetailDto);
		//댓글 list받아와 model에 담아준다.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto",replyListDto);
		
		//댓글 총 갯수를 받아와 model에 담아준다.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt", replyCnt);
		
		return "qna/qnadetail";
	}
	
	@RequestMapping(value="/qnaupdateform.do")
	public String qnaUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		logger.info("QNA UPDATE FORM");
		QnaDetailDto qnaDetailDto = qnaBiz.selectOne(bd_no);
		model.addAttribute("qnaDetailDto", qnaDetailDto);
		return "qna/qnaupdateform";
	}
	
	@RequestMapping(value="/qnaupdate.do")
	public String qnaUpdate(Model model, QnaUpdateDto qnaUpdateDto, BoardUpdateDto boardUpdateDto) {
		logger.info("QNA UPDATE");
		
		int qnaUpdateRes = qnaBiz.update(qnaUpdateDto, boardUpdateDto);
		logger.info(Integer.toString(qnaUpdateRes));
		if(qnaUpdateRes>0) {
			int bd_no = qnaUpdateDto.getBd_no();
			return "redirect:qnadetail.do?bd_no="+bd_no;
		}
		
		QnaDetailDto qnaDetailDto = qnaBiz.selectOne(qnaUpdateDto.getBd_no()); 
		qnaDetailDto.setBd_title(boardUpdateDto.getBd_title());
		qnaDetailDto.setBd_content(boardUpdateDto.getBd_content());
		/* qnaDetailDto.setBf_originname(boardUpdateDto.getBf_originname()); */
		
		model.addAttribute("qnaDetailDto", qnaDetailDto);
		logger.info("업데이트 실패");
		return "qna/qnaupdateform";
	}	
	
	@RequestMapping(value="/qnadelete.do")
	public String qnaDelete(Model model, int bd_no,HttpServletResponse response) throws IOException {
		logger.info("QNA DELETE");
		int qnaDeleteRes = qnaBiz.delete(bd_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('삭제 되었습니다.');");
		out.print("location.href='qnalist.do';");
		out.print("</script>");
		return null;
	}
	
	// qna 삭제 ajax
	@RequestMapping(value="/qnadeleteAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public int qnaDeleteAjax(int bd_no) {
		logger.info("QNA DELETE AJAX");

		int res = qnaBiz.delete(bd_no);
		return res; 
	}
	
	/*
	 * @RequestMapping(value="/qnasearch.do") public String qnaSearch(Model model,
	 * QnaSearchDto qnaSearchDto) { logger.info("QNA SEARCH");
	 * 
	 * //페이징 처리를 위해 갯수를 얻어온다. int qnaSearchListCnt =
	 * qnaBiz.getQnaListSearchCnt(qnaSearchDto);
	 * 
	 * //갯수와 페이지 번호로 페이지 정보를 가져온다. PageProcessing pageProcessing = new
	 * PageProcessing(qnaSearchListCnt, qnaSearchDto.getPage());
	 * 
	 * //start와 end값, 검색 값으로 list를 가져오는데 map에 담아서 처리해준다. Map<String,Object>
	 * qnaSearchMap = new HashMap<String,Object>(); qnaSearchMap.put("start",
	 * pageProcessing.getStartIndex()); qnaSearchMap.put("end",
	 * pageProcessing.getEndIndex()); qnaSearchMap.put("qnaSearchDto",
	 * qnaSearchDto); List<QnaListDto> qnaList =
	 * qnaBiz.selectSearchList(qnaSearchMap);
	 * 
	 * model.addAttribute("qnaList",qnaList);
	 * model.addAttribute("pageProcessing",pageProcessing);
	 * model.addAttribute("qnaSearchDto",qnaSearchDto);
	 * 
	 * return "qna/qnalist"; }
	 */
	
}
