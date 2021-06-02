package com.itpro.model.dto.resume;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CareerDto {

	// 멤버 기본 정보
	private int m_no;// 회원번호

	// 경력 및 교육 사항
	private int ca_no;
	private String ca_title;
	private String ca_content;
	private String ca_start_date;
	private String ca_end_date;
}
