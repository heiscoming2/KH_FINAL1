package com.itpro.model.dao;

import java.util.List;

import com.itpro.model.dto.resume.CareerDto;

public interface CareerDao {
	String NAMESPACE = "career.";

	public List<CareerDto> selectOne(int m_no);

}
