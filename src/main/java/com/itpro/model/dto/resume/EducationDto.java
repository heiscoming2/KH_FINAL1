package com.itpro.model.dto.resume;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM")
	private Date ed_startdate;//입학
	@DateTimeFormat(pattern = "yyyy-MM")
	private Date ed_gradudate; //졸업
	private String ed_schoolName;// 학교명
	private String ed_graduation;// 졸업, 휴학, 중퇴, 재학
	private String ed_major; // 전공
	private String ed_school;// 대학원, 대학교, 고등학교
	
	// //학력사항 리스트
	// private List<EducationDto> educationList;
}
