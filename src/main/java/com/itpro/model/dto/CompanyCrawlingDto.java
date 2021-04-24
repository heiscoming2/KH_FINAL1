package com.itpro.model.dto;

public class CompanyCrawlingDto {
	
	private int no;
	private String name;
	private String title;
	private String career;
	private String education;
	private String meta;
	private String addr1;
	private String addr2;
	private String url;
	private String deadline;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public CompanyCrawlingDto(int no, String name, String title, String career, String education, String meta,
			String addr1, String addr2, String url, String deadline) {
		super();
		this.no = no;
		this.name = name;
		this.title = title;
		this.career = career;
		this.education = education;
		this.meta = meta;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.url = url;
		this.deadline = deadline;
	}

}
