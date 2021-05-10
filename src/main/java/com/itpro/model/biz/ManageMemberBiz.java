package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.report.ReportDto;

public interface ManageMemberBiz {

	public List<ManageMemberDto> selectList();
	public ManageMemberDto selectOne(int m_no);
	public int update(ManageMemberDto dto);
	

}
