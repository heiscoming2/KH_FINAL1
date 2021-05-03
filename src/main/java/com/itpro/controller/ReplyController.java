package com.itpro.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.util.ClientInfo;

@Controller
public class ReplyController {
	
	private Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@RequestMapping(value="/replyinsert.do", method=RequestMethod.POST)
	public String replyInsert(HttpServletRequest request, Model model, ReplyInsertDto replyInsertDto) {
		
		logger.info("REPLY INSERT");
		//요청한 클라이언트의 ip주소를 얻어와 dto에 담음
		replyInsertDto.setRe_writerip(new ClientInfo().getClientIp(request));
		int replyInsertRes = replyBiz.insert(replyInsertDto);
		
		//되돌아갈 게시글 번호를 얻어옴 (댓글 작성한 게시글 번호)
		int bd_no = replyInsertDto.getBd_no();
		
		if(replyInsertRes>0) {
			return "redirect:studydetail.do?bd_no="+bd_no;
		}
		//실패시 구별을 위해 일단 list로 돌아가게끔 해놓자
		//나중에 공통으로 사용할 jsResponse를 생성해놓고
		//실패시 alert 출력 후 기존글로 이동할수있도록 처리
		return "redirect:studylist.do";
	}
}
