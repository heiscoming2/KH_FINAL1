package com.itpro.model.dto;

public class CompanyCrawlingDto {
	
	private int cc_code;
	private String cc_name;
	private String cc_title;
	private String cc_career;
	private String cc_education;
	private String cc_meta;
	private String cc_addr1;
	private String cc_addr2;
	private String cc_deadline;
	private int cc_carlevel;
	private int cc_edulevel;
	
	public int getCc_code() {
		return cc_code;
	}
	public void setCc_code(int cc_code) {
		this.cc_code = cc_code;
	}
	public String getCc_name() {
		return cc_name;
	}
	public void setCc_name(String cc_name) {
		this.cc_name = cc_name;
	}
	public String getCc_title() {
		return cc_title;
	}
	public void setCc_title(String cc_title) {
		this.cc_title = cc_title;
	}
	public String getCc_career() {
		return cc_career;
	}
	public void setCc_career(String cc_career) {
		this.cc_career = cc_career;
		if(cc_career.contains("무관")) {
			this.cc_carlevel=1;
		} else if(cc_career.contains("신입")) {
			this.cc_carlevel=2;
		} else {
			this.cc_carlevel=3;
		}
	}
	public String getCc_education() {
		return cc_education;
	}
	public void setCc_education(String cc_education) {
		this.cc_education = cc_education;
		if(cc_education.contains("무관")) {
			this.cc_edulevel=1;
		} else if(cc_education.contains("고졸")) {
			this.cc_edulevel=2;
		} else if(cc_education.contains("대학(2,3년)")) {
			this.cc_edulevel=3;
		} else {
			this.cc_edulevel=4;
		}
	}
	public String getCc_meta() {
		return cc_meta;
	}
	public void setCc_meta(String cc_meta) {
		this.cc_meta = cc_meta;
	}
	public String getCc_addr1() {
		return cc_addr1;
	}
	public void setCc_addr1(String cc_addr1) {
		this.cc_addr1 = cc_addr1;
	}
	public String getCc_addr2() {
		return cc_addr2;
	}
	public void setCc_addr2(String cc_addr2) {
		this.cc_addr2 = cc_addr2;
	}
	public String getCc_deadline() {
		return cc_deadline;
	}
	public void setCc_deadline(String cc_deadline) {
		this.cc_deadline = cc_deadline;
	}
	public int getCc_carlevel() {
		return cc_carlevel;
	}
	public void setCc_carlevel(int cc_carlevel) {
		this.cc_carlevel = cc_carlevel;
	}
	public int getCc_edulevel() {
		return cc_edulevel;
	}
	public void setCc_edulevel(int cc_edulevel) {
		this.cc_edulevel = cc_edulevel;
	}
		
	
	public CompanyCrawlingDto(int cc_code, String cc_name, String cc_title, String cc_career, String cc_education,
			String cc_meta, String cc_addr1, String cc_addr2, String cc_deadline, int cc_carlevel, int cc_edulevel) {
		super();
		this.cc_code = cc_code;
		this.cc_name = cc_name;
		this.cc_title = cc_title;
		this.cc_career = cc_career;
		this.cc_education = cc_education;
		this.cc_meta = cc_meta;
		this.cc_addr1 = cc_addr1;
		this.cc_addr2 = cc_addr2;
		this.cc_deadline = cc_deadline;
		this.cc_carlevel = cc_carlevel;
		this.cc_edulevel = cc_edulevel;
	}
	
	public CompanyCrawlingDto() {
		// TODO Auto-generated constructor stub
	}
	
}
