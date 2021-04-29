package com.itpro.model.dto;

import java.util.Date;

public class NoteDto {
	private int n_no;
	private String n_send;
	private String n_receiver;
	private String n_content;
	private Date n_date;
	
	public NoteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoteDto(int n_no, String n_send, String n_receiver, String n_content, Date n_date) {
		super();
		this.n_no = n_no;
		this.n_send = n_send;
		this.n_receiver = n_receiver;
		this.n_content = n_content;
		this.n_date = n_date;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getN_send() {
		return n_send;
	}

	public void setN_send(String n_send) {
		this.n_send = n_send;
	}

	public String getN_receiver() {
		return n_receiver;
	}

	public void setN_receiver(String n_receiver) {
		this.n_receiver = n_receiver;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}
	
	
	
}
