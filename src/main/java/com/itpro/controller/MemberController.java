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

	// 개인회원 마이페이지 관련 컨트롤러
	@RequestMapping(value = "/mypage_user.do")
	public String mypage() {
		logger.info("MYPAGE USER");

		return "member/mypage_user";
	}

	// 개인회원 정보수정폼으로 이동
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

	// 개인회원 정보 수정
	@RequestMapping(value = "/user_update.do")
	public String userUpdate(MemberDto updateDto, HttpSession session) {
		logger.info("USER UPDATE");

		int res = biz.updateMember(updateDto);

		if (res > 0) {		
			
			// 세션 종료
			session.invalidate();

			return "redirect:login.do";

		} else {
			
			return "member/mypage_user";
		}

	}

	// 기업회원 마이페이지
	@RequestMapping(value = "/mypage_biz.do")
	public String mypage_biz() {
		logger.info("MYPAGE BIZ");

		return "member/mypage_biz";
	}

	// 기업회원 정보수정폼으로 이동
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

	// 기업회원정보 수정
	@RequestMapping(value = "/biz_update.do")
	public String bizUpdate(MemberDto updateDto, HttpSession session) {
		logger.info("BIZ UPDATE");

		int res = biz.updateMember(updateDto);

		if (res > 0) {

			// 세션 종료
			session.invalidate();

			return "redirect:login.do";

		} else {
			return "redirect:biz_update_form.do";
		}

	}	
	

	// 회원탈퇴 페이지이동
	@RequestMapping(value = "/deleteForm.do")
	public String deleteForm() {
		logger.info("DELETE Form");

		return "member/delete_member";
	}

	// 회원탈퇴 처리
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
	

	// 프로필 이미지 업로드 컨트롤러
	@RequestMapping(value = "/profileUpload.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> profileUpload(HttpServletRequest request, MultipartHttpServletRequest mtf)
			throws IllegalStateException, IOException {

		Map<String, String> map = new HashMap<String, String>();

		MemberDto res = (MemberDto) request.getSession().getAttribute("login");
		int m_no = res.getM_no();

		// 넘어오는 파일 받음
		MultipartFile file = mtf.getFile("m_img");
		// 파일 실제 이름
		String originName = file.getOriginalFilename();
		// 파일 확장자타입
		String fileType = originName.substring(originName.lastIndexOf("."));	
		
		// 저장될 파일명
		String m_img = UUID.randomUUID() + fileType;
		// 파일 저장경로
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/profileimages/");
		

		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(new File(realPath, m_img));		
		
		
		String m_img_path = "profileimages/";
		logger.info("==============================");
		logger.info("경로:" + m_img_path + m_img);

		ProfileDto profileDto = new ProfileDto(m_no, m_img_path, m_img);
		biz.profileUpload(profileDto);

		map.put("path", "profileimages/" + m_img);
		logger.info("==============================");
		logger.info("map path:" + map);

		return map;
	}


	// 작성글 목록 전체
	@RequestMapping(value = "/postlookup.do")
	public String postLookup(Model model, int m_no,
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value="category", required=false, defaultValue="0") int category,
			@RequestParam(value="keyword", required=false) String keyword) {
		logger.info("postlookup");
		
		
		Map<String,Object> postLookupPageMap = new HashMap<String,Object>();
		postLookupPageMap.put("m_no", m_no);
		postLookupPageMap.put("category",category);
		
		//게시물 총 갯수를 받아온다.
		int postlookupcnt = biz.selectPostLookupCnt(postLookupPageMap);
		
		//list를 얻어오는데 작성자 m_no, 받아올 페이지 정보를 map에 담아서 해당 내용을 가져온다.
		PageProcessing pageProcessing = new PageProcessing(postlookupcnt,page);
		postLookupPageMap.put("start", pageProcessing.getStartIndex());
		postLookupPageMap.put("end", pageProcessing.getEndIndex());
		postLookupPageMap.put("keyword", keyword);
		List<PostLookupDto> postLookupList = biz.selectPostLookup(postLookupPageMap);
		//총 게시물 수
		model.addAttribute("postlookupcnt",postlookupcnt);
		//게시물 list
		model.addAttribute("postLookupList",postLookupList);
		//페이징 정보
		model.addAttribute("pageProcessing",pageProcessing);
		//카테고리 정보 (하이라이트 효과 위해서)
		model.addAttribute("category",category);
		//작성자 정보
		model.addAttribute("writer",biz.selectOne(m_no));
		//검색어
		model.addAttribute("keyword",keyword);
		return "member/postlookup";
	}
	

	
	

	
}
