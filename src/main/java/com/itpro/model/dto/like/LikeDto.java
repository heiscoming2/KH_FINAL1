package com.itpro.model.dto.like;

import java.sql.Date;

public class LikeDto {

	private int m_no; // 회원 번호
	private int bd_no; // 게시글 번호
	private Date br_recommanddate; // 추천일

	public LikeDto() {
		super();
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

	public Date getBr_recommanddate() {
		return br_recommanddate;
	}

	public void setBr_recommanddate(Date br_recommanddate) {
		this.br_recommanddate = br_recommanddate;
	}

	public LikeDto(int m_no, int bd_no, Date br_recommanddate) {
		super();
		this.m_no = m_no;
		this.bd_no = bd_no;
		this.br_recommanddate = br_recommanddate;
	}

}
