package com.itpro.model.dto.resume;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResumeImgDto {
	
	private Integer r_no; //이력서 번호
	private String r_img; // 이미지
	private String r_img_path; // 이미지경로
	
	public ResumeImgDto(String r_img, String r_img_path) {
		this.r_img = r_img;
		this.r_img_path = r_img_path;
	}
}
