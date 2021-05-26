package com.itpro.model.dto.report;

import java.util.Date;

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
	
	
	
	
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public String getReport_reason() {
		return report_reason;
	}
	public void setReport_reason(String report_reason) {
		this.report_reason = report_reason;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	
	
	@Override
	public String toString() {
		return "ReportDto [report_no=" + report_no + ", m_no=" + m_no + ", bd_no=" + bd_no + ", report_reason="
				+ report_reason + ", report_date=" + report_date + ", bd_title=" + bd_title + ", name=" + name
				+ ", code=" + code + ", m_nickname=" + m_nickname + "]";
	}
	
	
}
	
