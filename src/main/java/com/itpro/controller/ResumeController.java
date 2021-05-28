package com.itpro.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itpro.model.biz.Login_joinBiz;
import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.util.PageProcessing;

@Controller
public class ResumeController {

private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeBiz biz;

	// 이력서 목록
	@RequestMapping(value = "/resume_list.do")
	public String resumeList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page, HttpSession session) {
		logger.info("RESUEM LIST");
		
		if(session.getAttribute("login")!=null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
		}		
		
		//페이징을 위해 총 게시물수 count
		int resumeListCnt = biz.getResumeListCnt();
		System.out.println("resumeListCnt : "+resumeListCnt);
		
		//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
		PageProcessing pageProcessing = new PageProcessing(resumeListCnt,page);
			
		//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
		//(이 부분은 나중에 PageProcessing 클래스에서 map을 바로 리턴받는 형태로 변경하는게 나을듯)
		Map<String,Object> resumePageMap = new HashMap<String,Object>();
		resumePageMap.put("start", pageProcessing.getStartIndex());
		resumePageMap.put("end", pageProcessing.getEndIndex());
		System.out.println(pageProcessing.getStartIndex());
		System.out.println(pageProcessing.getEndIndex());
		List<ResumeDto> resumeList = biz.selectList(resumePageMap);
		
		//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
		model.addAttribute("pageProcessing",pageProcessing);
			
		//프로젝트 글 목록을 받아 model에 담아준다.
		model.addAttribute("resumeList",resumeList);		
		
		
		return "resume/resume_list";
	}

	//이력서 등록폼으로 이동
	@RequestMapping(value = "/resume_form.do")
	public String resumeForm(HttpSession session, Model model) {
		logger.info("RESUEM FORM");
		
//		if (session.getAttribute("login") != null) {
//			MemberDto res = (MemberDto) session.getAttribute("login");
//			int m_no = res.getM_no();
//			MemberDto resumeInsert = resumeBiz.selectOne(m_no);
//			model.addAttribute("resumeInsert", resumeInsert);
//
//			return "member/resume_form";
//		}

		return "resume/resume_form";
	}

	//이력서 상세페이지 이동
	@RequestMapping(value = "/resume_detail.do")
	public String resumeDetail() {
		logger.info("RESUEM DETIAL");

		return "resume/resume_detail";
	}

	//이력서 수정폼으로 이동
	@RequestMapping(value = "/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");

		return "resume/resume_update";
	}

}
