package com.itpro.model.dto.resume;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.itpro.model.dto.member.MemberDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResumeUploadDto {	
	// ResumeDetailDto
	private int r_no; // 이력서 번호 // 참고: Insert시 생성되어 update됨

	private String r_title; // 이력서 제목
	private String r_postcode;// 우편번호
	private String r_roadAddress;// 도로명주소
	private String r_jibunAddress;// 지번주소
	private String r_detailAddress;// 상세주소
	
	private String r_extraAddress;// 참고항목
	private String r_selfletter; // 자소서
	private String r_portfolio; // 포트폴리오 주소
	private Integer r_img_no; // 참고: R_RESUME_IMG 테이블
	
	// MemberDto
	private int m_no; // 회원번호
	private String m_name; // 이름
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date m_birth; // 생년월일
	private String m_gender; // 성별
	private String m_phone;// 전화번호
	
	public MemberDto getMemberDto() {
		MemberDto dto = new MemberDto();
		
		dto.setM_no(m_no);
		dto.setM_name(m_name);
		dto.setM_birth(m_birth);
		dto.setM_gender(m_gender);
		dto.setM_phone(m_phone);
		
		return dto;
	}
}
