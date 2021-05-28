package com.itpro.model.dto.portfolio;

import java.util.Date;

public class PortfolioUpdateDto {

	// 게시판
	private int bd_no; // 게시글 번호
	private String bd_title; // 제목
	private String bd_content; // 글 내용
	private int bd_createddate; // 작성일
	private Date bd_modifydate; // 수정일
	private String bd_writerip; // 작성시 ip
	private String writerip; // 작성시 ip
	private int bd_replycount; // 댓글수
	private int bd_viewcount; // 조회수
	private int bd_recommandcount; // 추천수

	// 첨부 파일
	private String bf_originname; // 파일 저장명

	// 회원
	private String m_img_path; // 프로필 이미지 경로
	private String m_img; // 프로필 이미지
	private String m_nickname; // 닉네임

	// 포트폴리오
	private String port_prize; // 수상내역
	private String port_develop; // 사용 개발 기술
	private String port_link; // 링크

	public PortfolioUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getBf_originname() {
		return bf_originname;
	}

	public void setBf_originname(String bf_originname) {
		this.bf_originname = bf_originname;
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

	public int getBd_createddate() {
		return bd_createddate;
	}

	public void setBd_createddate(int bd_createddate) {
		this.bd_createddate = bd_createddate;
	}

	public Date getBd_modifydate() {
		return bd_modifydate;
	}

	public void setBd_modifydate(Date bd_modifydate) {
		this.bd_modifydate = bd_modifydate;
	}

	public String getBd_writerip() {
		return bd_writerip;
	}

	public void setBd_writerip(String bd_writerip) {
		this.bd_writerip = bd_writerip;
	}

	public String getWriterip() {
		return writerip;
	}

	public void setWriterip(String writerip) {
		this.writerip = writerip;
	}

	public int getBd_replycount() {
		return bd_replycount;
	}

	public void setBd_replycount(int bd_replycount) {
		this.bd_replycount = bd_replycount;
	}

	public int getBd_viewcount() {
		return bd_viewcount;
	}

	public void setBd_viewcount(int bd_viewcount) {
		this.bd_viewcount = bd_viewcount;
	}

	public int getBd_recommandcount() {
		return bd_recommandcount;
	}

	public void setBd_recommandcount(int bd_recommandcount) {
		this.bd_recommandcount = bd_recommandcount;
	}

	public String getM_img_path() {
		return m_img_path;
	}

	public void setM_img_path(String m_img_path) {
		this.m_img_path = m_img_path;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

}
