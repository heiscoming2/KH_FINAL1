package com.itpro.model.dto.resume;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EducationDto {

	// 학력사항
	private int m_no;

	// 학력사항
	private int ed_no;
	private String ed_startdate;
	private String ed_gradudate;
	private String ed_schoolName;// 학교명
	private String ed_graduation;// 졸업, 휴학, 중퇴, 재학
	private String ed_major; // 전공
	private String ed_school;// 대학원, 대학교, 고등학교

}
