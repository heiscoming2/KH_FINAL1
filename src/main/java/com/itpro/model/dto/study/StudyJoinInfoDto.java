package com.itpro.model.dto.study;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudyJoinInfoDto {
	
	private int m_no;
	private int bd_no;
	private Date sj_joindate;
	private String sj_message;
	private char sj_isjoin;
	private Date sj_acceptdate;

}
