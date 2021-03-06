package com.itpro.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.PostLookupDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.portfolio.PortfolioDetailDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

import lombok.extern.slf4j.Slf4j;
import oracle.sql.ARRAY;

@Controller
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberBiz biz;

	// ???????????? ??????????????? ?????? ????????????
	@RequestMapping(value = "/mypage_user.do")
	public String mypage() {
		logger.info("MYPAGE USER");

		return "member/mypage_user";
	}

	// ???????????? ????????????????????? ??????
	@RequestMapping(value = "/user_update_form.do")
	public String userUupdateForm(HttpSession session, Model model) {
		logger.info("USER UPDATE FORM");

		if (session.getAttribute("login") != null) {
			MemberDto res = (MemberDto) session.getAttribute("login");
			int m_no = res.getM_no();
			MemberDto update = biz.selectOne(m_no);
			model.addAttribute("selectUser", update);
			
			return "member/update_user";
		}

		return "member/mypage_user";
	}

	// ???????????? ?????? ??????
	@RequestMapping(value = "/user_update.do")
	public String userUpdate(MemberDto updateDto, HttpSession session) {
		logger.info("USER UPDATE");

		int res = biz.updateMember(updateDto);

		if (res > 0) {		
			
			// ?????? ??????
			session.invalidate();

			return "redirect:login.do";

		} else {
			
			return "member/mypage_user";
		}

	}

	// ???????????? ???????????????
	@RequestMapping(value = "/mypage_biz.do")
	public String mypage_biz() {
		logger.info("MYPAGE BIZ");

		return "member/mypage_biz";
	}

	// ???????????? ????????????????????? ??????
	@RequestMapping(value = "/biz_update_form.do")
	public String bizUpdateForm(HttpSession session, Model model) {
		logger.info("BIZ UPDATE FORM");

		if (session.getAttribute("login") != null) {
			MemberDto res = (MemberDto) session.getAttribute("login");
			int m_no = res.getM_no();
			MemberDto update = biz.selectOne(m_no);
			model.addAttribute("selectUser", update);

			return "member/update_biz";
		}

		return "member/mypage_biz";
	}

	// ?????????????????? ??????
	@RequestMapping(value = "/biz_update.do")
	public String bizUpdate(MemberDto updateDto, HttpSession session) {
		logger.info("BIZ UPDATE");

		int res = biz.updateMember(updateDto);

		if (res > 0) {

			// ?????? ??????
			session.invalidate();

			return "redirect:login.do";

		} else {
			return "redirect:biz_update_form.do";
		}

	}	
	

	// ???????????? ???????????????
	@RequestMapping(value = "/deleteForm.do")
	public String deleteForm() {
		logger.info("DELETE Form");

		return "member/delete_member";
	}

	// ???????????? ??????
	@RequestMapping(value = "/deleteMember.do")
	public String deleteMember(@RequestParam(required = false) String m_id, @RequestParam(required = false) String m_pw,
			HttpSession session) {
		logger.info("DELETE MEMBER");

		boolean res = biz.checkPw(m_id, m_pw);
		if (res) {
			biz.deleteMember(m_id);
			session.invalidate();

			return "redirect:main.do";
		} else {
			return "redirect:deleteForm.do";
		}

	}
	

	// ????????? ????????? ????????? ????????????
	@RequestMapping(value = "/profileUpload.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> profileUpload(HttpServletRequest request, MultipartHttpServletRequest mtf)
			throws IllegalStateException, IOException {

		Map<String, String> map = new HashMap<String, String>();

		MemberDto res = (MemberDto) request.getSession().getAttribute("login");
		int m_no = res.getM_no();

		// ???????????? ?????? ??????
		MultipartFile file = mtf.getFile("m_img");
		// ?????? ?????? ??????
		String originName = file.getOriginalFilename();
		// ?????? ???????????????
		String fileType = originName.substring(originName.lastIndexOf("."));	
		
		// ????????? ?????????
		String m_img = UUID.randomUUID() + fileType;
		// ?????? ????????????
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/profileimages/");
		

		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(new File(realPath, m_img));		
		
		
		String m_img_path = "profileimages/";
		logger.info("==============================");
		logger.info("??????:" + m_img_path + m_img);

		ProfileDto profileDto = new ProfileDto(m_no, m_img_path, m_img);
		biz.profileUpload(profileDto);

		map.put("path", "profileimages/" + m_img);
		logger.info("==============================");
		logger.info("map path:" + map);

		return map;
	}


	// ????????? ?????? ??????
	@RequestMapping(value = "/postlookup.do")
	public String postLookup(Model model, int m_no,
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value="category", required=false, defaultValue="0") int category,
			@RequestParam(value="keyword", required=false) String keyword) {
		logger.info("postlookup");
		
		
		Map<String,Object> postLookupPageMap = new HashMap<String,Object>();
		postLookupPageMap.put("m_no", m_no);
		postLookupPageMap.put("category",category);
		
		//????????? ??? ????????? ????????????.
		int postlookupcnt = biz.selectPostLookupCnt(postLookupPageMap);
		
		//list??? ??????????????? ????????? m_no, ????????? ????????? ????????? map??? ????????? ?????? ????????? ????????????.
		PageProcessing pageProcessing = new PageProcessing(postlookupcnt,page);
		postLookupPageMap.put("start", pageProcessing.getStartIndex());
		postLookupPageMap.put("end", pageProcessing.getEndIndex());
		postLookupPageMap.put("keyword", keyword);
		List<PostLookupDto> postLookupList = biz.selectPostLookup(postLookupPageMap);
		//??? ????????? ???
		model.addAttribute("postlookupcnt",postlookupcnt);
		//????????? list
		model.addAttribute("postLookupList",postLookupList);
		//????????? ??????
		model.addAttribute("pageProcessing",pageProcessing);
		//???????????? ?????? (??????????????? ?????? ?????????)
		model.addAttribute("category",category);
		//????????? ??????
		model.addAttribute("writer",biz.selectOne(m_no));
		//?????????
		model.addAttribute("keyword",keyword);
		return "member/postlookup";
	}
	

	
	

	
}
