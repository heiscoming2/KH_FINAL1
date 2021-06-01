package com.itpro.model.dto.portfolio;

import java.util.Date;
import java.util.List;

import com.itpro.model.dto.board.BoardDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.resume.CareerDto;
import com.itpro.model.dto.resume.EducationDto;

public class PortfolioDetailDto {

	// 게시판
	private BoardDto board;
	public int bd_no;
	// 첨부 파일
	private String bf_originname; // 파일 저장명

	private MemberDto member;
	// 포트폴리오
	private String port_prize; // 수상내역
	private String port_develop; // 사용 개발 기술
	private String port_link; // 링크

	// 경력 및 교육 사항
	private List<CareerDto> career;
	// 학력사항
	private EducationDto edu;

	public PortfolioDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public BoardDto getBoard() {
		return board;
	}



	public void setBoard(BoardDto board) {
		this.board = board;
	}



	public String getBf_originname() {
		return bf_originname;
	}



	public void setBf_originname(String bf_originname) {
		this.bf_originname = bf_originname;
	}



	public MemberDto getMember() {
		return member;
	}



	public void setMember(MemberDto member) {
		this.member = member;
	}



	public List<CareerDto> getCareer() {
		return career;
	}



	public void setCareer(List<CareerDto> list) {
		this.career = list;
	}



	public EducationDto getEdu() {
		return edu;
	}



	public void setEdu(EducationDto edu) {
		this.edu = edu;
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
