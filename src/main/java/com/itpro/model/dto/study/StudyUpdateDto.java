package com.itpro.model.dto.study;

public class StudyUpdateDto {
	
	private int bd_no;
	private int st_nowperson;
	private int st_closeperson;
	private String st_addr1;
	private String st_addr2;
	private String st_addrdetail;
	
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public int getSt_nowperson() {
		return st_nowperson;
	}
	public void setSt_nowperson(int st_nowperson) {
		this.st_nowperson = st_nowperson;
	}
	public int getSt_closeperson() {
		return st_closeperson;
	}
	public void setSt_closeperson(int st_closeperson) {
		this.st_closeperson = st_closeperson;
	}
	public String getSt_addr1() {
		return st_addr1;
	}
	public void setSt_addr1(String st_addr1) {
		this.st_addr1 = st_addr1;
	}
	public String getSt_addr2() {
		return st_addr2;
	}
	public void setSt_addr2(String st_addr2) {
		this.st_addr2 = st_addr2;
	}
	public String getSt_addrdetail() {
		return st_addrdetail;
	}
	public void setSt_addrdetail(String st_addrdetail) {
		this.st_addrdetail = st_addrdetail;
	}
}
