package com.itpro.model.dto.portfolio;

public class PortfolioInsertDto {
	// 게시판
	public int bd_no; // 게시글 번호
	public String bd_title; // 게시글 제목
	public String bd_content; // 게시글 내용
	public String bd_writerip; // 작성시 ip

	private int m_no;

	// 포트폴리오
	private String port_prize; // 수상내역
	private String port_develop; // 사용 개발 기술
	private String port_link; // 링크

	private String is_phone_open; //전화번호 공개여부

	public PortfolioInsertDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public String toString() {
		return "PortfolioInsertDto [bd_no=" + bd_no + ", bd_title=" + bd_title + ", bd_content=" + bd_content
				+ ", bd_writerip=" + bd_writerip + ", m_no=" + m_no + ", port_prize=" + port_prize + ", port_develop="
				+ port_develop + ", port_link=" + port_link + "]";
	}



	public String getIs_phone_open() {
		return is_phone_open;
	}



	public void setIs_phone_open(String is_phone_open) {
		this.is_phone_open = is_phone_open;
	}



	public int getBd_no() {
		return bd_no;
	}



	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}



	public String getBd_title() {
		return bd_title;
	}



	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}



	public String getBd_content() {
		return bd_content;
	}



	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}



	public String getBd_writerip() {
		return bd_writerip;
	}



	public void setBd_writerip(String bd_writerip) {
		this.bd_writerip = bd_writerip;
	}



	public int getM_no() {
		return m_no;
	}



	public void setM_no(int m_no) {
		this.m_no = m_no;
	}



	public String getPort_prize() {
		return port_prize;
	}



	public void setPort_prize(String port_prize) {
		this.port_prize = port_prize;
	}



	public String getPort_develop() {
		return port_develop;
	}



	public void setPort_develop(String port_develop) {
		this.port_develop = port_develop;
	}



	public String getPort_link() {
		return port_link;
	}



	public void setPort_link(String port_link) {
		this.port_link = port_link;
	}


}
