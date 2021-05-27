package com.itpro.model.dto.resume;

import java.util.Date;

public class ResumeDto {

	private int m_no;// 회원번호

	// 이력서 기본사항
	private int r_no; //이력서 순서
	private String r_title; //이력서 제목
	private String r_selfletter; //자소서
	private String r_portfolio; //포트폴리오 주소
	private String r_img; //이력서 사진
	private String r_img_path; //이력서 사진 경로
	private Date r_regdate; //이력서 등록일

	// 경력 및 교육 사항
	private int ca_no;
	private String ca_title;
	private String ca_content;
	private String ca_start_date;
	private String ca_end_date;

	// 학력사항
	private int ed_no;
	private String ed_date;
	private String ed_schoolName;// 학교명
	private String ed_graduation;// 졸업, 휴학, 중퇴, 재학
	private String ed_major; // 전공
	private String ed_school;// 대학원, 대학교, 고등학교

	// 자격사항
	private int li_no;
	private String li_title;
	private String li_date;
	private String li_organ;

	public ResumeDto() {
		super();
	}

	public ResumeDto(int m_no, int r_no, String r_title, String r_selfletter, String r_portfolio, String r_img,
			String r_img_path, Date r_regdate, int ca_no, String ca_title, String ca_content, String ca_start_date,
			String ca_end_date, int ed_no, String ed_date, String ed_schoolName, String ed_graduation, String ed_major,
			String ed_school, int li_no, String li_title, String li_date, String li_organ) {
		super();
		this.m_no = m_no;
		this.r_no = r_no;
		this.r_title = r_title;
		this.r_selfletter = r_selfletter;
		this.r_portfolio = r_portfolio;
		this.r_img = r_img;
		this.r_img_path = r_img_path;
		this.r_regdate = r_regdate;
		this.ca_no = ca_no;
		this.ca_title = ca_title;
		this.ca_content = ca_content;
		this.ca_start_date = ca_start_date;
		this.ca_end_date = ca_end_date;
		this.ed_no = ed_no;
		this.ed_date = ed_date;
		this.ed_schoolName = ed_schoolName;
		this.ed_graduation = ed_graduation;
		this.ed_major = ed_major;
		this.ed_school = ed_school;
		this.li_no = li_no;
		this.li_title = li_title;
		this.li_date = li_date;
		this.li_organ = li_organ;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_selfletter() {
		return r_selfletter;
	}

	public void setR_selfletter(String r_selfletter) {
		this.r_selfletter = r_selfletter;
	}

	public String getR_portfolio() {
		return r_portfolio;
	}

	public void setR_portfolio(String r_portfolio) {
		this.r_portfolio = r_portfolio;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}

	public String getR_img_path() {
		return r_img_path;
	}

	public void setR_img_path(String r_img_path) {
		this.r_img_path = r_img_path;
	}

	public Date getR_regdate() {
		return r_regdate;
	}

	public void setR_regdate(Date r_regdate) {
		this.r_regdate = r_regdate;
	}

	public int getCa_no() {
		return ca_no;
	}

	public void setCa_no(int ca_no) {
		this.ca_no = ca_no;
	}

	public String getCa_title() {
		return ca_title;
	}

	public void setCa_title(String ca_title) {
		this.ca_title = ca_title;
	}

	public String getCa_content() {
		return ca_content;
	}

	public void setCa_content(String ca_content) {
		this.ca_content = ca_content;
	}

	public String getCa_start_date() {
		return ca_start_date;
	}

	public void setCa_start_date(String ca_start_date) {
		this.ca_start_date = ca_start_date;
	}

	public String getCa_end_date() {
		return ca_end_date;
	}

	public void setCa_end_date(String ca_end_date) {
		this.ca_end_date = ca_end_date;
	}

	public int getEd_no() {
		return ed_no;
	}

	public void setEd_no(int ed_no) {
		this.ed_no = ed_no;
	}

	public String getEd_date() {
		return ed_date;
	}

	public void setEd_date(String ed_date) {
		this.ed_date = ed_date;
	}

	public String getEd_schoolName() {
		return ed_schoolName;
	}

	public void setEd_schoolName(String ed_schoolName) {
		this.ed_schoolName = ed_schoolName;
	}

	public String getEd_graduation() {
		return ed_graduation;
	}

	public void setEd_graduation(String ed_graduation) {
		this.ed_graduation = ed_graduation;
	}

	public String getEd_major() {
		return ed_major;
	}

	public void setEd_major(String ed_major) {
		this.ed_major = ed_major;
	}

	public String getEd_school() {
		return ed_school;
	}

	public void setEd_school(String ed_school) {
		this.ed_school = ed_school;
	}

	public int getLi_no() {
		return li_no;
	}

	public void setLi_no(int li_no) {
		this.li_no = li_no;
	}

	public String getLi_title() {
		return li_title;
	}

	public void setLi_title(String li_title) {
		this.li_title = li_title;
	}

	public String getLi_date() {
		return li_date;
	}

	public void setLi_date(String li_date) {
		this.li_date = li_date;
	}

	public String getLi_organ() {
		return li_organ;
	}

	public void setLi_organ(String li_organ) {
		this.li_organ = li_organ;
	}

}
