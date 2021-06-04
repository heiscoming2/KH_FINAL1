package com.itpro.model.dto.resume;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResumeProfileDto {
	//이력서 이미지 등록용 dto
	private int m_no; // 회원번호
	private int r_no; //이력서 번호
	private String r_img; // 이미지
	private String r_img_path; // 이미지경로
	
	public ResumeProfileDto(int m_no, String r_img, String r_img_path) {
		super();
		this.m_no = m_no;
		this.r_img = r_img;
		this.r_img_path = r_img_path;
	}
	
	
	
	

	
	

}
