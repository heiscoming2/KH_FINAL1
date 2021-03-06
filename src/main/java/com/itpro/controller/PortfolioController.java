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

import com.google.gson.Gson;
import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.PortfolioBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.portfolio.PortfolioDetailDto;
import com.itpro.model.dto.portfolio.PortfolioInsertDto;
import com.itpro.model.dto.portfolio.PortfolioListDto;
import com.itpro.model.dto.portfolio.PortfolioUpdateDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

@Controller
public class PortfolioController {

private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
	
	@Autowired
	private PortfolioBiz portfolioBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Autowired
	private BoardBiz boardBiz;
	
	@Autowired
	private LikeBiz likeBiz;
	
	
	@RequestMapping(value="/portfoliolist.do")
	public String portfolioList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="key", required=false, defaultValue="") String key, HttpSession session) {
		logger.info("Portfolio LIST");
		
		Map<String,Object> portfolioPageMap = new HashMap<String,Object>();
		portfolioPageMap.put("key",key);
		
		//???????????? ?????? ??? ???????????? count
		int portfolioListCnt = portfolioBiz.getPortfolioListCnt(portfolioPageMap);
		System.out.println("portfolioListCnt : "+ portfolioListCnt);
		
		//??????????????? ?????????????????? ???????????? ????????? ???????????? dto??? ????????????.
		PageProcessing pageProcessing = new PageProcessing(portfolioListCnt,page);
			
		//???????????? select ????????????, startindex??? endindex??? ??????????????? ?????? ????????????.
		portfolioPageMap.put("start", pageProcessing.getStartIndex());
		portfolioPageMap.put("end", pageProcessing.getEndIndex());
		System.out.println(pageProcessing.getStartIndex());
		System.out.println(pageProcessing.getEndIndex());
		List<PortfolioListDto> portfolioList = portfolioBiz.selectList(portfolioPageMap);
		
		//????????? ?????? model??? ????????? (_page.jspf?????? ????????? ?????????)
		model.addAttribute("pageProcessing",pageProcessing);
			
		//portfolio ??? ????????? ?????? model??? ????????????.
		model.addAttribute("portfolioList", portfolioList);
		
		model.addAttribute("key",key);
		
		return "portfolio/portfoliolist";
	}
	
	@RequestMapping(value="/portfolioinsertform.do")
	public String portfolioInsertForm(Model model, HttpSession session) {
		logger.info("PORTFOLIO INSERT FORM");
		
		MemberDto member = (MemberDto) session.getAttribute("login");
		PortfolioDetailDto portfolioDetailDto = portfolioBiz.insertForm(member.getM_no());
		
		model.addAttribute("dto", portfolioDetailDto);
		System.out.println("insertForm : " +  new Gson().toJson(portfolioDetailDto));
		
		return "portfolio/portfolioinsertform";
	}
	
	
	
	@RequestMapping(value="/portfolioinsert.do")
	public String portfolioInsert(HttpServletRequest request, HttpServletResponse response, PortfolioInsertDto portfolioDto) {
		logger.info("Portfolio INSERT");
		logger.info(portfolioDto.toString());
		//ClientInfo??? getClientIp??? request??? ???????????? ip ????????? ????????? portfolioDto??? ??????
		portfolioDto.setBd_writerip(new ClientInfo().getClientIp(request));
		int res = portfolioBiz.portfolioInsert(portfolioDto);
		System.out.println("res:"+res);
		return "redirect:portfoliolist.do";

	}	
	
	
	@RequestMapping(value="/portfoliodetail.do")
	public String portfolioDetail(HttpServletRequest request,  HttpServletResponse response, Model model, 
			@RequestParam(value="bd_no") int bd_no, @RequestParam(value="m_no") int m_no, HttpSession session) {
		logger.info("Portfolio DETAIL");
		
		//????????? ?????????????????? ??????????????? ????????? ?????? ????????? ??????????????? model??? ????????????. 
		if(session.getAttribute("login")!=null) {
			MemberDto loginDto = (MemberDto) session.getAttribute("login");
			int my_no = loginDto.getM_no();
			LikeDto likeDto = new LikeDto();
			likeDto.setBd_no(bd_no);
			likeDto.setM_no(my_no);
			int res = likeBiz.like_check(likeDto);
			model.addAttribute("likecheck",res);
		}
		
		//????????? ?????? ?????? (?????? ????????? ????????? ?????? ????????? ?????? ?????? ???????????? ??????)
		if(new ViewCount().viewCount(request, response, bd_no)) {
			boardBiz.updateviewcount(bd_no);
		}
		
		
		
		//selectOne ?????? model??? ????????????.
		PortfolioDetailDto portfolioDetailDto = portfolioBiz.selectOne(bd_no, m_no);
		model.addAttribute("dto", portfolioDetailDto);
		
		
		logger.info("portfolioDetailDto controller: " + portfolioDetailDto.toString());
		
		
		
		//?????? list????????? model??? ????????????.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto",replyListDto);
		
		//?????? ??? ????????? ????????? model??? ????????????.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt", replyCnt);
		
		return "portfolio/portfoliodetail";
	}	
	
	@RequestMapping(value="/portfolioupdateform.do")
	public String portfolioUpdateForm(Model model, @RequestParam(value="bd_no") int bd_no, @RequestParam(value="m_no") int m_no, HttpSession session) {
		logger.info("Portfolio UPDATE FORM");
//		MemberDto loginDto = (MemberDto) session.getAttribute("login");
//		int m_no = loginDto.getM_no();
		PortfolioDetailDto portfolioDetailDto = portfolioBiz.selectOne(bd_no, m_no);
		model.addAttribute("portfolioDetailDto", portfolioDetailDto);
		
		return "portfolio/portfolioupdateform";
	}
	
	@RequestMapping(value="/portfolioupdate.do")
	public String portfolioUpdate(Model model, @RequestParam(value="m_no") int m_no, PortfolioUpdateDto portfolioUpdateDto, BoardUpdateDto boardUpdateDto, HttpSession session) {
		logger.info("Portfolio UPDATE");
		
		int portfolioUpdateRes = portfolioBiz.update(portfolioUpdateDto, boardUpdateDto);
		logger.info(Integer.toString(portfolioUpdateRes));
		if(portfolioUpdateRes>0) {
			int bd_no = portfolioUpdateDto.getBd_no();
			return "redirect:portfoliodetail.do?bd_no="+bd_no+"&m_no="+m_no;
		}
//		MemberDto loginDto = (MemberDto) session.getAttribute("login");
//		int m_no = loginDto.getM_no();
		PortfolioDetailDto portfolioDetailDto = portfolioBiz.selectOne(portfolioUpdateDto.getBd_no(), m_no); 
		//portfolioDetailDto.getBoard().bd_title = (boardUpdateDto.getBd_title());
		//portfolioDetailDto.getBoard().bd_content = (boardUpdateDto.getBd_content());
		portfolioDetailDto.setBd_title(portfolioUpdateDto.getBd_title());
		portfolioDetailDto.setBd_content(portfolioUpdateDto.getBd_content());
		
		
		portfolioDetailDto.setPort_develop(portfolioUpdateDto.getPort_develop());
		portfolioDetailDto.setPort_link(portfolioUpdateDto.getPort_link());
		portfolioDetailDto.setPort_prize(portfolioUpdateDto.getPort_prize());

		model.addAttribute("portfolioDetailDto", portfolioDetailDto);
		logger.info("???????????? ??????");
		return "portfolio/portfolioupdateform";
	}	
	
	@RequestMapping(value="/portfoliodelete.do")
	public String portfolioDelete(Model model, int bd_no,HttpServletResponse response) throws IOException {
		logger.info("Portfolio DELETE");
		int portfolioDeleteRes = portfolioBiz.delete(bd_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('?????? ???????????????.');");
		out.print("location.href='portfoliolist.do';");
		out.print("</script>");
		return null;
	}
	
}
