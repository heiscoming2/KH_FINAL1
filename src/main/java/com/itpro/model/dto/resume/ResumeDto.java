package com.itpro.model.dto.resume;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResumeDto {

	// 멤버 기본 정보
	private int m_no;// 회원번호
	private String m_phone;// 전화번호
	private String m_email;// 이메일
	private String m_name; // 이름
	private String m_birth; // 생년월일
	private String m_gender; // 성별	

	// 이력서 기본사항
	private int r_no; // 이력서 순서
	private String r_title; // 이력서 제목
	private String r_postcode;// 우편번호
	private String r_roadAddress;// 도로명주소
	private String r_jibunAddress;// 지번주소
	private String r_detailAddress;// 상세주소
	private String r_extraAddress;// 참고항목
	private String r_selfletter; // 자소서
	private String r_portfolio; // 포트폴리오 주소
	private Integer r_img_no;
	private String r_img; // 이력서 사진
	private String r_img_path; // 이력서 사진 경로
	private Date r_regdate; // 이력서 등록일

	// 경력 및 교육 사항
	private int ca_no;
	private String ca_title;
	private String ca_content;
	private String ca_start_date;
	private String ca_end_date;

	// 학력사항
	private int ed_no;
	private String ed_date;
	private String ed_schoolName;// 학교명
	private String ed_graduation;// 졸업, 휴학, 중퇴, 졸업예정
	private String ed_major; // 전공
	private String ed_school;// 대학원, 대학교, 고등학교

	// 자격사항
	private int li_no; 
	private String li_title; //자격증명
	private String li_date; //취득일
	private String li_organ; //기관
}
