package com.itpro.model.dto.report;

import java.util.Date;

public class ReportDto {

	private int report_no;
	private int m_no;
	private int bd_no;
	private String report_board;
	private String report_reason;
	private Date report_date;
	private int report_sum;
	private String bd_title;
	
	
	
	
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
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
	public String getReport_board() {
		return report_board;
	}
	public void setReport_board(String report_board) {
		this.report_board = report_board;
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
	public int getReport_sum() {
		return report_sum;
	}
	public void setReport_sum(int report_sum) {
		this.report_sum = report_sum;
	}
	
	
}
