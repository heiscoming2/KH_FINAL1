package com.itpro.model.dto.company;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyResumeDto {
	
	//프로필 정보
	private int m_no;
	private String m_img_path;
	private String m_img;
	private String m_nickname;
	//이력서 정보
	private int bd_no;
	private int r_no;
	private String r_title; //resume테이블
	private Date ca_date;
	private String ca_status;
	
}
