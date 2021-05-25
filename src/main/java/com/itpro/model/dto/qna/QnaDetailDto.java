package com.itpro.model.dto.qna;

import java.util.Date;

public class QnaDetailDto {

	// 게시판
	private int bd_no; // 게시글 번호
	private String bd_title; // 제목
	private String bd_content; // 글 내용
	private Date bd_createddate; // 작성일
	private Date bd_modifydate; // 수정일
	private String bd_writerip; // 작성시 ip
	private int bd_replycount; // 댓글수
	private int bd_viewcount; // 조회수
	private int bd_recommandcount; // 추천수

	// 첨부 파일
	private String bf_originname; // 파일 저장명

	// 회원
	private String m_img_path; // 프로필 이미지 경로
	private String m_img; // 프로필 이미지
	private String m_nickname; // 닉네임
	private int m_no; // 회원 번호

	public QnaDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBd_no() {
		return bd_no;
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

	public Date getBd_createddate() {
		return bd_createddate;
	}

	public void setBd_createddate(Date bd_createddate) {
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

	public String getBf_originname() {
		return bf_originname;
	}

	public void setBf_originname(String bf_originname) {
		this.bf_originname = bf_originname;
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

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}

}
