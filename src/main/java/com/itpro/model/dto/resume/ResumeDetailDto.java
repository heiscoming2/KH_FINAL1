package com.itpro.model.dto.resume;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResumeDetailDto {

	// 멤버 기본 정보
	private int m_no;// 회원번호

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
	private String r_img; // 이력서 사진
	private String r_img_path; // 이력서 사진 경로
	private Date r_regdate; // 이력서 등록일

}
