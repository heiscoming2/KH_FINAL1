package com.itpro.model.dto.resume;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LicenceDto {

	// 멤버 기본 정보
	private int m_no;// 회원번호
	
	// 자격사항
	private int li_no; 
	private String li_title; //자격증명
	private Date li_date; //취득일
	private String li_organ; //기관
}
