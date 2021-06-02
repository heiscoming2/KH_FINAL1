package com.itpro.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.itpro.model.biz.Login_joinBiz;
import com.itpro.model.biz.MemberBiz;
import com.itpro.model.biz.ResumeBiz;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.resume.CareerDto;
import com.itpro.model.dto.resume.EducationDto;
import com.itpro.model.dto.resume.LicenceDto;
import com.itpro.model.dto.resume.ResumeDetailDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.resume.ResumeProfileDto;
import com.itpro.util.PageProcessing;

@Controller
public class ResumeController {

	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeBiz biz;

	@Autowired
	private MemberBiz memberBiz;

	// 이력서 목록 조회
	@RequestMapping(value = "/resume_list.do")
	public String resumeList(Model model, HttpSession session) {
		logger.info("RESUEM LIST");

		int m_no = 0;

		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		List<ResumeDto> resumeList = biz.resumeList(m_no);
		model.addAttribute("resumeList", resumeList);

		return "resume/resume_list";
	}

	// 이력서 상세페이지 이동
	@RequestMapping(value = "/resume_detail.do")
	public String resumeDetail(Model model, int r_no) {
		logger.info("RESUEM DETIAL");

		// 이력서 기본정보 조회(detail)
		ResumeDetailDto resumeDetailDto = biz.resumeDetail(r_no);

		// 회원번호로 멤버테이블 정보 가져옴
		int m_no = resumeDetailDto.getM_no();
		MemberDto memberDto = memberBiz.selectOne(m_no);

		// 이력서 학력사항 조회(list)
		List<EducationDto> educationList = biz.educationList(m_no);
		// 이력서 자격사항 조회(list)
		List<LicenceDto> licenceList = biz.licenceList(m_no);
		// 이력서 경력사항 조회(list)
		List<CareerDto> careerist = biz.careerList(m_no);

		// model
		model.addAttribute("resumeDetailDto", resumeDetailDto);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("educationList", educationList);
		model.addAttribute("licenceList", licenceList);
		model.addAttribute("careerList", careerist);

		return "resume/resume_detail";
	}

	// 이력서 수정폼으로 이동
	@RequestMapping(value = "/resume_updateForm.do")
	public String resumeForm(Model model, int r_no) {
		logger.info("RESUEM UPDATE FORM");

		// 이력서 기본정보 조회(detail)
		ResumeDetailDto resumeDetailDto = biz.resumeDetail(r_no);

		// 회원번호로 멤버테이블 정보 가져옴
		int m_no = resumeDetailDto.getM_no();
		MemberDto memberDto = memberBiz.selectOne(m_no);

		// 이력서 학력사항 조회(list)
		List<EducationDto> educationList = biz.educationList(m_no);
		// 이력서 자격사항 조회(list)
		List<LicenceDto> licenceList = biz.licenceList(m_no);
		// 이력서 경력사항 조회(list)
		List<CareerDto> careerist = biz.careerList(m_no);

		// model
		model.addAttribute("resumeDetailDto", resumeDetailDto);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("educationList", educationList);
		model.addAttribute("licenceList", licenceList);
		model.addAttribute("careerList", careerist);

		return "resume/resume_update";
	}

	// 이력서 수정
	@RequestMapping(value = "/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");

		return "resume/resume_update";
	}

	// 이력서 등록페이지로 이동
	@RequestMapping(value = "/resume_form.do")
	public String resumeInsertForm(Model model, HttpSession session) {
		logger.info("RESUEM INSERT FORM");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		// 회원번호로 멤버기본 정보 가져옴
		MemberDto memberDto = memberBiz.selectOne(m_no);

		// model
		model.addAttribute("memberDto", memberDto);

		return "resume/resume_form";
	}

	// 이력서 등록
	@RequestMapping(value = "/resume_insert.do")
	public String resumeInsert(MemberDto memberDto, ResumeDetailDto resumeDto, CareerDto careerDto,
			EducationDto educationDto, LicenceDto licenceDto) {
		logger.info("RESUEM INSERT");

		// 회원기본정보 등록 - mapper에서 update
		int memResumeUpdate = biz.memResumeUpdate(memberDto);

		// 이력서기본정보 등록 - mapper에서 insert
		int resumeInsert = biz.resumeInsert(resumeDto);

		// 경력 정보 등록 - mapper에서 insert
		int careerInsert = biz.careerInsert(careerDto);
		
		// 학력 정보 등록 - mapper에서 insert
		int educationInsert = biz.educationInsert(educationDto);

		// 자격증 정보 등록 - mapper에서 insert
		int licenseInsert = biz.licenseInsert(licenceDto);

		return "resume/resume_list";
	}

	// 이력서 개별삭제
	@RequestMapping(value = "/resume_delete.do")
	public String resumeDelete(int r_no) {
		logger.info("RESUEM DELETE");

		int res = biz.resumeDelete(r_no);
		if (res > 0) {

			return "redirect:resume_list.do";
		} else {
			return "redirect:resume_detail.do?r_no=" + r_no;
		}
	}

	// 이력서 멀티삭제
	@RequestMapping
	public String resumeListDel(int r_no) {
		logger.info("RESUEM DELETE");

		return null;
	}

	// 프로필 이미지 업로드 컨트롤러(왜 안될까....??)
	@RequestMapping(value = "/resumeProfile.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> profileUpload(HttpServletRequest request, MultipartHttpServletRequest mtf)
			throws IllegalStateException, IOException {

		Map<String, String> map = new HashMap<String, String>();

		MemberDto res = (MemberDto) request.getSession().getAttribute("login");
		int m_no = res.getM_no();

		// 넘어오는 파일 받음
		MultipartFile file = mtf.getFile("r_img");
		// 파일 실제 이름
		String originName = file.getOriginalFilename();
		// 파일 확장자타입
		String fileType = originName.substring(originName.lastIndexOf("."));

		// 저장될 파일명
		String r_img = UUID.randomUUID() + fileType;
		// 파일 저장경로
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/profileimages/");

		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(new File(realPath, r_img));

		String r_img_path = "profileimages/";
		logger.info("==============================");
		logger.info("경로:" + r_img_path + r_img);

		ResumeProfileDto resumeProfileDto = new ResumeProfileDto(m_no, r_img, r_img_path);
		biz.profileUpload(resumeProfileDto);

		map.put("path", "profileimages/" + r_img);
		logger.info("==============================");
		logger.info("map path:" + map);

		return map;
	}

}
