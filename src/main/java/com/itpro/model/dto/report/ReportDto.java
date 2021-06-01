package com.itpro.model.dto.report;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ReportDto {

	private int report_no;
	private int m_no;
	private int bd_no;
	private String report_reason;
	private Date report_date;
	private String bd_title;
	private String name;
	private String code;
	private String m_nickname;
	private int cnt;
	
	

	
	
}
	
