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
import com.itpro.model.dto.resume.ResumeImgDto;
import com.itpro.model.dto.resume.ResumeProfileDto;
import com.itpro.model.dto.resume.ResumeUploadDto;
import com.itpro.util.PageProcessing;

@Controller
public class ResumeController {

	private static final Logger logger = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeBiz biz;

	@Autowired
	private MemberBiz memberBiz;

	// ????????? ?????? ??????
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

	// ????????? ??????????????? ??????
	@RequestMapping(value = "/resume_detail.do")
	public String resumeDetail(Model model, int r_no) {
		logger.info("RESUEM DETIAL");

		// ????????? ???????????? ??????(detail)
		ResumeDetailDto resumeDetailDto = biz.resumeDetail(r_no);
		// ??????????????? ??????????????? ?????? ?????????
		int m_no = resumeDetailDto.getM_no();
		MemberDto memberDto = memberBiz.selectOne(m_no);

		// ????????? ???????????? ??????(list)
		List<EducationDto> educationList = biz.educationList(m_no);
		// ????????? ???????????? ??????(list)
		List<LicenceDto> licenceList = biz.licenceList(m_no);
		// ????????? ???????????? ??????(list)
		List<CareerDto> careerist = biz.careerList(m_no);

		// model
		model.addAttribute("resumeDetailDto", resumeDetailDto);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("educationList", educationList);
		model.addAttribute("licenceList", licenceList);
		model.addAttribute("careerList", careerist);

		return "resume/resume_detail";
	}

	// ????????? ??????????????? ??????
	@RequestMapping(value = "/resume_updateForm.do")
	public String resumeForm(Model model, int r_no) {
		logger.info("RESUEM UPDATE FORM");

		// ????????? ???????????? ??????(detail)
		ResumeDetailDto resumeDetailDto = biz.resumeDetail(r_no);
		// ??????????????? ??????????????? ?????? ?????????
		int m_no = resumeDetailDto.getM_no();
		MemberDto memberDto = memberBiz.selectOne(m_no);

		// ????????? ???????????? ??????(list)
		List<EducationDto> educationList = biz.educationList(m_no);
		// ????????? ???????????? ??????(list)
		List<LicenceDto> licenceList = biz.licenceList(m_no);
		// ????????? ???????????? ??????(list)
		List<CareerDto> careerist = biz.careerList(m_no);

		// model
		model.addAttribute("resumeDetailDto", resumeDetailDto);
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("educationList", educationList);
		model.addAttribute("licenceList", licenceList);
		model.addAttribute("careerList", careerist);

		return "resume/resume_update";
	}

	// ????????? ??????
	@RequestMapping(value = "/resume_update.do")
	public String resumeUpdate() {
		logger.info("RESUEM UPDATE");

		return "resume/resume_update";
	}

	// ????????? ?????????????????? ??????
	@RequestMapping(value = "/resume_form.do")
	public String resumeInsertForm(Model model, HttpSession session) {
		logger.info("RESUEM INSERT FORM");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		// ??????????????? ???????????? ?????? ?????????
		MemberDto memberDto = memberBiz.selectOne(m_no);

		// ????????? ???????????? ??????(list)
		List<EducationDto> educationList = biz.educationList(m_no);
		// ????????? ???????????? ??????(list)
		List<LicenceDto> licenceList = biz.licenceList(m_no);
		// ????????? ???????????? ??????(list)
		List<CareerDto> careerist = biz.careerList(m_no);

		// model
		model.addAttribute("memberDto", memberDto);
		model.addAttribute("educationList", educationList);
		model.addAttribute("licenceList", licenceList);
		model.addAttribute("careerList", careerist);

		return "resume/resume_form";
	}

	// ????????? ??????
	@RequestMapping(value = "/resume_insert.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer resumeInsert(ResumeUploadDto resumeUploadDto, HttpSession session, EducationDto educationDto) {
		logger.info("RESUEM INSERT");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		// 0. m_no ??????
		resumeUploadDto.setM_no(m_no);

		// 1. ????????? ?????? ?????? ?????? - mapper?????? update
		biz.resumeInsert(resumeUploadDto);

		// 2. ???????????? ????????????- mapper?????? insert
		MemberDto memberDto = resumeUploadDto.getMemberDto();
		biz.memResumeUpdate(memberDto);

		// return: ????????? ????????? ????????????????????? ????????????.
		int r_no = resumeUploadDto.getR_no();
		return r_no;
	}

	// ????????? ???????????? ??????
	@RequestMapping(value = "/resume_update_ajax.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer resumeUpdateAjax(HttpSession session, ResumeDetailDto dto) {
		logger.info("RESUEM UPDATE");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}
		dto.setM_no(m_no);

		int result = biz.resumeUpdate(dto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/educationInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public int educationInsert(HttpSession session, EducationDto educationDto) {
		logger.info("educationInsert");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		educationDto.setM_no(m_no);

		int result = biz.educationInsert(educationDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/educationUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public int educationUpdate(HttpSession session, EducationDto educationDto) {
		logger.info("educationUpdate");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		educationDto.setM_no(m_no);

		int result = biz.educationUpdate(educationDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/educationDelete.do", method = RequestMethod.POST)
	@ResponseBody
	public int educationDelete(HttpSession session, EducationDto educationDto) {
		logger.info("educationDelete");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		educationDto.setM_no(m_no);

		int result = biz.educationDelete(educationDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/licenceInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public int licenceInsert(HttpSession session, LicenceDto licenceDto) {
		logger.info("licenceInsert");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		licenceDto.setM_no(m_no);

		int result = biz.licenceInsert(licenceDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/licenceUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public int licenceUpdate(HttpSession session, LicenceDto licenceDto) {
		logger.info("licenceUpdate");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		licenceDto.setM_no(m_no);

		int result = biz.licenceUpdate(licenceDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/licenceDelete.do", method = RequestMethod.POST)
	@ResponseBody
	public int licenceDelete(HttpSession session, LicenceDto licenceDto) {
		logger.info("licenceDelete");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		licenceDto.setM_no(m_no);

		int result = biz.licenceDelete(licenceDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/careerInsert.do", method = RequestMethod.POST)
	@ResponseBody
	public int careerInsert(HttpSession session, CareerDto careerDto) {
		logger.info("careerInsert");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		careerDto.setM_no(m_no);

		int result = biz.careerInsert(careerDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/careerUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public int careerUpdate(HttpSession session, CareerDto careerDto) {
		logger.info("careerUpdate");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		careerDto.setM_no(m_no);

		int result = biz.careerUpdate(careerDto);
		return result;
	}

	// ????????? ???????????? ?????? ??????
	@RequestMapping(value = "/careerDelete.do", method = RequestMethod.POST)
	@ResponseBody
	public int careerDelete(HttpSession session, CareerDto careerDto) {
		logger.info("careerDelete");

		int m_no = 0;
		if (session.getAttribute("login") != null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
			m_no = login.getM_no();
		}

		// ???????????? ???????????? ?????????
		careerDto.setM_no(m_no);

		int result = biz.careerDelete(careerDto);
		return result;
	}

	// ????????? ??????
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

	// ????????? ????????????(ajax)
	@RequestMapping(value = "/resume_delete_ajax.do", method = RequestMethod.POST)
	@ResponseBody
	public int resumeDeleteAjax(int r_no) {
		logger.info("RESUEM DELETE AJAX");

		int res = biz.resumeDelete(r_no);

		return res;
	}

	// ????????? ????????? ????????? ????????????(?????? ??????????????? ??????????????? ????????? ????????? ??????????????? ???????)
	@RequestMapping(value = "/resumeProfile.do", method = RequestMethod.POST)
	@ResponseBody
	public Integer profileUpload(HttpServletRequest request, MultipartHttpServletRequest mtf)
			throws IllegalStateException, IOException {

		Map<String, String> map = new HashMap<String, String>();

		MemberDto res = (MemberDto) request.getSession().getAttribute("login");
		int m_no = res.getM_no();

		// ???????????? ?????? ??????
		MultipartFile file = mtf.getFile("r_img");
		// ?????? ?????? ??????
		String originName = file.getOriginalFilename();
		// ?????? ???????????????
		String fileType = originName.substring(originName.lastIndexOf("."));

		// ????????? ?????????
		String r_img = UUID.randomUUID() + fileType;
		// ?????? ????????????
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/profileimages/");

		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		file.transferTo(new File(realPath, r_img));

		String r_img_path = "profileimages/";
		logger.info("==============================");
		logger.info("??????:" + r_img_path + r_img);

		ResumeImgDto resumeImgDto = new ResumeImgDto(r_img, r_img_path);
		biz.uploadResumeImg(resumeImgDto);
		Integer r_no = resumeImgDto.getR_no();

		return r_no;
	}

}
