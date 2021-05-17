package com.itpro.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;
import com.itpro.util.ClientInfo;

@Controller
public class ReplyController {
	
	private Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyBiz replyBiz;
	
	//댓글 INSERT
	@RequestMapping(value="/replyinsert.do", method=RequestMethod.POST)
	@ResponseBody
	public Boolean replyInsert(HttpServletRequest request, Model model, @RequestBody ReplyInsertDto replyInsertDto) {
		logger.info("REPLY INSERT");
		//요청한 클라이언트의 ip주소를 얻어와 dto에 담음
		replyInsertDto.setRe_writerip(new ClientInfo().getClientIp(request));
		System.out.println(replyInsertDto.getRe_parentno());
		
		int replyInsertRes = replyBiz.insert(replyInsertDto);
		
		System.out.println("controller reparent_no"+replyInsertDto.getRe_parentno());
		return replyInsertRes>0? true:false;
	}
	
	
	@RequestMapping(value="/replyupdate.do" , method=RequestMethod.POST)
	@ResponseBody
	public Boolean replyUpdate(@RequestBody ReplyUpdateDto replyUpdateDto) {
		logger.info("REPLY UPDATE");
		boolean updateCheck = false;
		int replyUpdateRes = replyBiz.update(replyUpdateDto);
		if(replyUpdateRes>0) {
			updateCheck = true;
		}
		return updateCheck;
	}
	
	@RequestMapping(value="/replydelete.do" , method=RequestMethod.POST)
	@ResponseBody
	public Boolean replyDelete(@RequestParam(value="re_no") int re_no) {
		System.out.println("re_no "+re_no);
		logger.info("REPLY DELETE");
		boolean deleteCheck = false;
		int replyDeteleRes = replyBiz.delete(re_no);
		if(replyDeteleRes>0) {
			deleteCheck = true;
		}
		return deleteCheck;
	}
	
	
}
