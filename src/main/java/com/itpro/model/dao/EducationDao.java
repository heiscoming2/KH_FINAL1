package com.itpro.model.dao;

import com.itpro.model.dto.resume.EducationDto;

public interface EducationDao {
	String NAMESPACE = "education.";

	public EducationDto selectOne(int m_no);


}
