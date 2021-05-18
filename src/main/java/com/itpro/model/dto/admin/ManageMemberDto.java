package com.itpro.model.dto.admin;

import java.util.Date;

public class ManageMemberDto {
	//회원 입력사항
	private int m_no;//회원번호
	private String m_id;//아이디
	private String m_pw;//비밀번호
	private String m_nickname;//닉네임
	private String m_phone;//전화번호
	private String m_email;//이메일
	private String m_name;//이름
	private Date m_birth;//생년월일
	private String m_gender;//성별
	private String m_addr;//주소	
	//인증,권한
	private char m_used;//탈퇴여부(탈퇴Y,회원N)
	private String m_act;//활동여부(활동, 정지)
	private char m_mail_cert;//메일 인증(미인증N,인증Y)
	private String m_type;//회원타입(개인회원, 기업회원, 관리자)
	private char m_auth;//권한(N회원Y관리자)
	//기업회원 필드 없음.
	
	//이미지
	private String m_img_path;
	private Date m_regdate;
	
	
	public int getM_no() {
		return m_no;
	}
	
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_nickname() {
		return m_nickname;
	}
	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Date getM_birth() {
		return m_birth;
	}
	public void setM_birth(Date m_birth) {
		this.m_birth = m_birth;
	}
	public String getM_gender() {
		return m_gender;
	}
	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}
	public String getM_addr() {
		return m_addr;
	}
	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	public char getM_used() {
		return m_used;
	}
	public void setM_used(char m_used) {
		this.m_used = m_used;
	}
	public String getM_act() {
		return m_act;
	}
	public void setM_act(String m_act) {
		this.m_act = m_act;
	}
	public char getM_mail_cert() {
		return m_mail_cert;
	}
	public void setM_mail_cert(char m_mail_cert) {
		this.m_mail_cert = m_mail_cert;
	}
	public String getM_type() {
		return m_type;
	}
	public void setM_type(String m_type) {
		this.m_type = m_type;
	}
	public char getM_auth() {
		return m_auth;
	}
	public void setM_auth(char m_auth) {
		this.m_auth = m_auth;
	}
	public String getM_img_path() {
		return m_img_path;
	}
	public void setM_img_path(String m_img_path) {
		this.m_img_path = m_img_path;
	}
	public Date getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}	

	
	
}
