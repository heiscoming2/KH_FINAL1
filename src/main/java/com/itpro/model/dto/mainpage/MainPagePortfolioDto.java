package com.itpro.model.dto.mainpage;

import java.util.Date;
import java.util.List;

import com.itpro.model.dto.resume.CareerDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainPagePortfolioDto {
	
	private int m_no;
	private String m_img;
	private String m_img_path;
	private String m_nickname;
	private Date m_birth;
	private int bd_no;
	private String bd_content;
	private String port_develop;
	private List<CareerDto> careerdto;
	private String port_prize;
	
	

}
